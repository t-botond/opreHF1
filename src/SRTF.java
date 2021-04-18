import java.util.ArrayList;
import java.util.Collections;

public class SRTF {
    private ArrayList<Task> list = new ArrayList<>();
    private Task currentTask=null;
    private int idoegyseg = 2;
    public SRTF(){}
    public void addList(ArrayList<Task> l){
        for(int i=0;i<l.size();++i)
            list.add(l.get(i));
    }
    public void vegrehajt(boolean enabled){
        if(enabled) {
            if(list.size()!=0) {
                for(int i=0;i<list.size();++i){
                    if(list.get(i).done()){
                        list.remove(list.get(i));
                    }
                }
                Task tmp=list.get(0);
                int c=0;
                for(int i=0;i< list.size();++i){
                    if(list.get(i).getLoket() <= tmp.getLoket()){
                        if(list.get(i).getStartTime() >= tmp.getStartTime()) {
                            tmp = list.get(i);
                        }
                    }
                }
                if(currentTask!=null && currentTask!=tmp) {
                    currentTask.stop();
                    list.remove(currentTask);
                    if(! currentTask.done())
                        list.add(currentTask);
                }

                currentTask=tmp;
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
