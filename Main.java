
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;
public class Main
{
    public static void main(String[] args)
    {
    	
    	int c=1;
        Scanner sc = new Scanner(System.in);
        int p;
     
        System.out.println("Enter the Values... ");
        System.out.print("Enter the number of processes(P): ");
        p=sc.nextInt();
        System.out.println();
        int process[]=new int[p*2];
        for(int i=0;i<p*2;i=i+2) {
        	System.out.println("--For Process P"+i+"--\nEnter Arrival time and Burst time:");
        	process[i]=sc.nextInt();
        	process[i+1]=sc.nextInt();
        }
        System.out.print("Enter the time quantum: ");
		int t=sc.nextInt();
		System.out.println();
    	
    	System.out.println("+-------------------------------------------------+");
    	System.out.println("|----Welcome to the CPU Scheduling Calculator-----|");
    	System.out.println("|-----------------Press 1 for FCFS----------------|");
        
        System.out.println("|-----------------Press 2 for SJF-----------------|");
        
        System.out.println("|-----------------Press 3 for SRT-----------------|");
        
        System.out.println("|-----------------Press 4 for RR------------------|");
        
        System.out.println("|-------------Press 5 to Exit Program-------------|");
        System.out.println("+-------------------------------------------------+");
       
        
        
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        System.out.println();
       
        
        while(choice!=5) {
        
        	
        	switch(choice) {
        	case 1:
        		CPUScheduler fcfs = new FirstComeFirstServe();
        		c=1;
        		for(int i=0;i<p*2;i=i+2) {
        			String pr="P"+c;
        			fcfs.add(new Row(pr, process[i], process[i+1]));
        			c++;
        			
        		}
        		fcfs.process();
        	    display(fcfs);
        	    
        		break;
        	
        	
        case 2:
        	CPUScheduler sjf = new ShortestJobFirst();
        	c=1;
    		for(int i=0;i<p*2;i=i+2) {
    			String pr="P"+c;
    			sjf.add(new Row(pr, process[i], process[i+1]));
    			c++;
    			
    		}
    		sjf.process();
            display(sjf);
    		break;
    		
        case 3:
        	CPUScheduler srt = new ShortestRemainingTime();
        	c=1;
    		for(int i=0;i<p*2;i=i+2) {
    			String pr="P"+c;
    			srt.add(new Row(pr, process[i], process[i+1]));
    			c++;
    			
    		}
    		srt.process();
            display(srt);
    		break;
    	
        case 4:
        	CPUScheduler rr = new RoundRobin();
        	
    		rr.setTimeQuantum(t);
    		c=1;
    		for(int i=0;i<p*2;i=i+2) {
    			String pr="P"+c;
    			rr.add(new Row(pr, process[i], process[i+1]));
    			c++;
    			
    		}

    		rr.process();
            display(rr);
    		break;
    	}
        	System.out.println("\n\n+-------------------------------------------------+");
        	try {
        		System.out.print("|----");
        		String s ="Welcome to the CPU Scheduling Calculator";
                for (int i = 0; i < s.length() ; i++) {
                    Thread.sleep(100);
                    System.out.print(s.charAt(i));
                }
                System.out.print("-----|");
            }
            catch (Exception e) {

                System.out.println(e);
            }
        	System.out.println();
        	
        	System.out.println("|-----------------Press 1 for FCFS----------------|");
            
            System.out.println("|-----------------Press 2 for SJF-----------------|");
            
            System.out.println("|-----------------Press 3 for SRT-----------------|");
            
            System.out.println("|-----------------Press 4 for RR------------------|");
            
            System.out.println("|-------------Press 5 to Exit Program-------------|");
            System.out.println("+-------------------------------------------------+");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            System.out.println();
           
        
        }
        getMin(process,p,t);
        
        System.out.print("\n\nExiting the program");
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        }
        catch (Exception e) {

            System.out.println(e);
        }
        System.out.println();
        System.out.println("Thank you!\n-Abhijit Mandal");
    }
    
    
    public static void getMin(int process[],int p, int t) {
    	double min=Integer.MAX_VALUE;
    	String res="";
    	int c=1;
    	CPUScheduler fcfs = new FirstComeFirstServe();
		for(int i=0;i<p*2;i=i+2) {
			String pr="P"+c;
			fcfs.add(new Row(pr, process[i], process[i+1]));
			c++;
			
		}
		fcfs.process();
		if(min>fcfs.getAverageWaitingTime()) {
			min=fcfs.getAverageWaitingTime();
			res="Min average wating time is given by FCFS";
		}
		CPUScheduler sjf = new ShortestJobFirst();
		c=1;
		for(int i=0;i<p*2;i=i+2) {
			String pr="P"+c;
			sjf.add(new Row(pr, process[i], process[i+1]));
			c++;
			
		}
		sjf.process();
		if(min>sjf.getAverageWaitingTime()) {
			min=sjf.getAverageWaitingTime();
			res="Min average wating time is given by SJF";
		}
		CPUScheduler srt = new ShortestRemainingTime();
    	c=1;
		for(int i=0;i<p*2;i=i+2) {
			String pr="P"+c;
			srt.add(new Row(pr, process[i], process[i+1]));
			c++;
			
		}
		srt.process();
		if(min>srt.getAverageWaitingTime()) {
			min=srt.getAverageWaitingTime();
			res="Min average wating time is given by SRT";
		}
		CPUScheduler rr = new RoundRobin();
    	
		rr.setTimeQuantum(t);
		c=1;
		for(int i=0;i<p*2;i=i+2) {
			String pr="P"+c;
			rr.add(new Row(pr, process[i], process[i+1]));
			c++;
			
		}

		rr.process();
		if(min>rr.getAverageWaitingTime()) {
			min=rr.getAverageWaitingTime();
			res="Min average waiting time is given by RR";
		}
		
		System.out.printf(res+" :%.2f",min);
		
    	
    }
    public static void display(CPUScheduler object)
    {
        System.out.println("Process\tAT\tBT\tWT\tTAT");

        for (Row row : object.getRows())
        {
            System.out.println(row.getProcessName() + "\t" + row.getArrivalTime() + "\t" + row.getBurstTime() + "\t" + row.getWaitingTime() + "\t" + row.getTurnaroundTime());
        }
        
        System.out.println();
        System.out.println("|---Gantt Chart---|");
        for (int i = 0; i < object.getTimeline().size(); i++)
        {
            List<Event> timeline = object.getTimeline();
            System.out.print(timeline.get(i).getStartTime() + "(" + timeline.get(i).getProcessName() + ") | ");
            
            if (i == object.getTimeline().size() - 1)
            {
                System.out.print(timeline.get(i).getFinishTime());
            }
        }
        
        System.out.printf("\n\nAverage WT: %.2f \nAverage TAT: %.2f", object.getAverageWaitingTime(),  object.getAverageTurnAroundTime());
    }
    
    
}
