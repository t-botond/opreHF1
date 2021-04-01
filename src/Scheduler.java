import java.util.ArrayList;
import java.util.LinkedList;

public class Scheduler {
    private ArrayList<Task> list = new ArrayList<>();
    private ArrayList<Task> done = new ArrayList<>();
    private int currtime=0;
    private RR rr;
    private SJF sjf;
    public Scheduler(ArrayList<Task> s){
        list = s;
        rr=new RR();
        sjf=new SJF();
    }
    public void step(){
        ArrayList<Task> prio0 = new ArrayList<>();
        ArrayList<Task> prio1 = new ArrayList<>();

        for(int i=0;i<list.size();++i) {
            if (list.get(i).getStartTime() == currtime) {
                Task t = list.get(i);
                if(t.getPrio() == 0)
                    prio0.add(t);
                if(t.getPrio() == 1)
                    prio1.add(t);
            }
        }
        sjf.addList(prio1);
        rr.addList(prio0);

        rr.vegrehajt(sjf.vegrehajt());

        ++currtime;
    }
    public boolean kesz(){
        for(int i=0;i<list.size();++i){
            if(! list.get(i).done())return false;
        }
        return true;
    }
}
