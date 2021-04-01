import java.util.Comparator;

public class resSort  implements Comparator<Task> {
    public int compare(Task a, Task b)
    {
        if(a.getStartTime() == b.getStartTime())
            return a.getBeerkezes()-b.getBeerkezes();
        return a.getStartTime()-b.getStartTime();
    }
}
