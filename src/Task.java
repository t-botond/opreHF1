import java.util.Comparator;

public class Task {
    private String name;
    private int prio;
    private int startTime;
    private int loket;
    private int delay;
    private int rrCnt;
    private boolean vegrehajtasAlatt;
    private int beerkezes;
    private static int sorrend=0;

    public Task(String taskName, int prioritas, int kezdoIdo, int cpuLoket){
        name=taskName;
        prio=prioritas;
        startTime=kezdoIdo;
        loket=cpuLoket;
        delay=0;
        rrCnt=0;
        vegrehajtasAlatt=false;
        beerkezes= sorrend++;
    }
    public int getLoket(){
        return loket;
    }
    public int getDelay(){
        return delay;
    }
    public int getStartTime(){
        return startTime;
    }
    public int getPrio(){
        return prio;
    }
    public String getName(){
        return name;
    }
    public void vegrehajt(){
        if(loket > 0){
            --loket;
        }
        if(loket==0) Main.addDoneTask(this);
        if(vegrehajtasAlatt == false){
            System.out.print(name);
            vegrehajtasAlatt=true;
        }
        ++rrCnt;
    }
    public void varakozas(){
        ++delay;
        vegrehajtasAlatt=false;
    }
    public void stop(){
        rrCnt=0;
    }
    @Override
    public String toString(){
        return name +"\t" +prio + "\t" + startTime + "\t" + loket + "\t" + delay+"\tRR: "+rrCnt;
    }
    public boolean done(){
        return loket == 0;
    }
    public int getRrCnt(){
        return rrCnt;
    }
    public int getBeerkezes() {
        return beerkezes;
    }
}
