import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Task> List = new ArrayList<>();
    private static ArrayList<Task> done = new ArrayList<>();
    public static void main(String[] args){
        readInput();
        Collections.sort(List, new TaskSorter());
        Scheduler s = new Scheduler(List);
        while(!s.kesz())
            s.step();
        System.out.println();

        Collections.sort(done, new resSort());
        if(done.size() > 0) {
            for (int i = 0; i < done.size(); ++i) {
                Task t = done.get(i);
                System.out.print(t.getName() + ":" + t.getDelay());
                if(i!=done.size()-1) System.out.print(",");
            }
        }
    }
    public static void readInput(){
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String line = s.nextLine();
            parser(line);
        }
    }
    public static void parser(String l){
        if(l.length() < 7) return;
        int idx=0;
        String[] data = new String[4];
        for(int i=0;i<4;++i)
            data[i]="";
        for(int i=0;i<l.length();++i){
            if(l.charAt(i) == ','){
                ++idx;
            }else{
                data[idx] = data[idx] + l.charAt(i);
            }
        }
        Task tmp = new Task(data[0],Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        List.add(tmp);
    }
    public static void addDoneTask(Task t){
        done.add(t);
    }
}
