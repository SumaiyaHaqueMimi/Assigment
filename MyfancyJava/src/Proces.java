
public class Proces {
    int id;
    int arrivalTime;
    int duration;
    GlobalTimer globalTimer;
    public Proces(int id,int arrivalTime, int duration, GlobalTimer globalTimer){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer=globalTimer;
    }
    public Proces(Proces p){
        this.id=p.id;
        this.arrivalTime=p.arrivalTime;
        this.duration=p.duration;
        this.globalTimer=p.globalTimer;
    }
    public void runProcess(){
        
       System.out.println("Process id is : " +id);
       globalTimer.time = globalTimer.time + duration;
       System.out.println("Globaltimer after execution : " +globalTimer.time);
        // The process will print it's id and global time for the duration specified by burst time
        
    }
    public int getId() {
        return id;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getDuration() {
        return duration;
    }
    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }
    
}