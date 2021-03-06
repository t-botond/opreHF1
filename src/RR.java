import java.util.ArrayList;
import java.util.Collections;

public class RR {
    private ArrayList<Task> list = new ArrayList<>();
    private Task currentTask=null;
    private int idoegyseg = 2;
    public RR(){}
    public void addList(ArrayList<Task> l){
        for(int i=0;i<l.size();++i)
            list.add(l.get(i));
    }
    public void vegrehajt(boolean enabled){
        if(enabled) {
            if(list.size()!=0) {

                if(currentTask==null)
                    currentTask=list.get(0);

                if(currentTask.getRrCnt() == idoegyseg || currentTask.done()){
                    currentTask.stop();
                    list.remove(currentTask);
                    if(! currentTask.done())
                        list.add(currentTask);
                    if(list.size() !=0)
                        currentTask = list.get(0);
                    else
                        currentTask = null;
                }
                if(currentTask!=null)
                    currentTask.vegrehajt();
            }
        }
        else{
            if(currentTask != null){
                currentTask.stop();
                list.remove(currentTask);
                if(! currentTask.done())
                    list.add(currentTask);
                currentTask=null;
            }
        }

        for(int i=0;i<list.size();++i)
            if(list.get(i) != currentTask)
                list.get(i).varakozas();
    }
}
