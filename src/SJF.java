import java.util.ArrayList;

public class SJF {
    private ArrayList<Task> list = new ArrayList<>();
    private Task currJob=null;

    public void addList(ArrayList<Task> l){
        for(int i=0;i<l.size();++i)
            list.add(l.get(i));
    }
    public boolean vegrehajt(){
        remove();
        if(list.size() == 0) return true;


        if(currJob== null || currJob.done()) {
            Task min = list.get(0);
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i).getLoket() < min.getLoket())
                    min = list.get(i);
            }

            if (currJob != null && min != currJob && currJob.done())
                currJob.stop();

            if (min != currJob && (currJob == null || currJob.done()))
                currJob = min;
        }
        for(int i=0;i<list.size();++i)
            if(list.get(i) != currJob)
                list.get(i).varakozas();

        currJob.vegrehajt();

        return false;
    }
    @Override
    public String toString(){
        String out="============SJF============\n";
        for(int i=0;i< list.size();++i)
            out = out + list.get(i).toString() + "\n";
        out=out+"============END============";
        return out;
    }
    public void remove(){
        for(int i=0;i<list.size();++i){
            if(list.get(i).done()) {
                list.remove(list.get(i));
            }
        }
    }
}
