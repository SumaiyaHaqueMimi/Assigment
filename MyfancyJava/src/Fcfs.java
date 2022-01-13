package Fcfs;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
public class Fcfs {

        static PriorityQueue<Proces> processQueue = new PriorityQueue<Proces>(10, new Comparator<Proces>() {
            public int compare(Proces process1, Proces process2) {
            return (int)(process1.getArrivalTime()-process2.getArrivalTime());
        }
    });
    static PriorityQueue<Proces> readyQueue = new PriorityQueue<Proces>(10, new Comparator<Proces>() {
            public int compare(Proces process1, Proces process2) {
            return (int)(process1.getArrivalTime()-process2.getArrivalTime());
        }
    });
    static GlobalTimer globalTimer = new GlobalTimer(0);
    public static void main(String[] args) {
        processQueue.add(new Proces(1,3,2,globalTimer));
        processQueue.add(new Proces(2,6,3,globalTimer));
        processQueue.add(new Proces(3,1,4,globalTimer));
        processQueue.add(new Proces(4,4,5,globalTimer));
        int total=0;
        System.out.println("Modified First time");
        while(globalTimer.time < 100){
            // TASK: Write your code here
            if(checkIfNewProcessArrived()==true){
                readyQueue.add(processQueue.poll());
                Proces head=new Proces(readyQueue.peek());
                Proces head=new Proces(readyQueue.peek());
                if(head.getArrivalTime()>=globalTimer.time){
                    int wt;
                    wt=globalTimer.time-head.getArrivalTime();
                    runProcessInCpu(head);
                    globalTimer=head.getGlobalTimer();
                    int tat;
                    tat=globalTimer.time-head.getArrivalTime();
                    total=total+wt;
                    System.out.println("Process waiting time : "+wt);
                    System.out.println("Process turnaround time : "+tat);
                    
                    
                    
                    
                    
                }
            }
            else{
                System.out.println(+globalTimer.time);
                System.out.println("No process is running at global timer " +globalTimer.time);
            }
            
            // You may look for available priority queue methods here: https://www.javatpoint.com/java-priorityqueue
            // Check for processes that have arrived using checkIfNewProcessArrived()
            // If found, move them to ready queue
            // If any process is ready to run, run a process from ready queue following the queue policy
            // Otherwise print the global time and mention that no process is ready to run
        }

        // TASK: Write your code here
        float avg=0;
        avg=total/4;
        System.out.println("Average waiting time is : "+avg );
        
        // Print performance statistics
    }
     public static boolean checkIfNewProcessArrived(){
        // TASK: Write your code here
       Proces p1=new Proces(processQueue.peek());
       if(p1.getArrivalTime() >= globalTimer){
           return true;
       }
       else
           return false;
        // return True/False by comparing the earliest arrival time from process queue with the global time
    
    }
    public static void runProcessInCpu(Proces p){
        // TASK: Write your code here
        p.runProcess();
        // Retrieve a process that is ready to run and run it

    }
}
