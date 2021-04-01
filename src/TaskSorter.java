import java.util.Comparator;

public class TaskSorter  implements Comparator<Task> {
    public int compare(Task a, Task b)
    {
        if(a.getStartTime() == b.getStartTime()){
            if(a.getPrio()==b.getPrio())
                return a.getName().compareTo(b.getName());
            else
                return (a.getPrio() > b.getPrio()) ? -1 : 1;
        }
        else{
            return (a.getStartTime() > b.getStartTime()) ? 1 : -1;
        }
    }
}
