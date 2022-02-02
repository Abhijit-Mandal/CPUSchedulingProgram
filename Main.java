
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;
public class Main
{
    public static void main(String[] args)
    {
    	
    	System.out.println("+-------------------------------------------------+");
    	System.out.println("|----Welcome to the CPU Scheduling Calculator-----|");
    	System.out.println("|-----------------Press 1 for FCFS----------------|");
        
        System.out.println("|-----------------Press 2 for SJF-----------------|");
        
        System.out.println("|-----------------Press 3 for SRT-----------------|");
        
        System.out.println("|-----------------Press 4 for RR------------------|");
        
        System.out.println("|-------------Press 5 to Exit Program-------------|");
        System.out.println("+-------------------------------------------------+");
       
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        System.out.println();
        int p;
        
        while(choice!=5) {
        	switch(choice) {
        	case 1:
        		CPUScheduler fcfs = new FirstComeFirstServe();
        		System.out.print("Enter the number of processes: ");
        		p=sc.nextInt();
        		System.out.println();
        		for(int i=1;i<=p;i++) {
        			System.out.println("--For Process P"+i+"--\nEnter Arrival time and Burst time:");
        			int a=sc.nextInt();
        			int b=sc.nextInt();
        			String pr="P"+i;
        			fcfs.add(new Row(pr, a, b));
        			
        		}
        		fcfs.process();
        	    display(fcfs);
        		break;
        	
        	
        case 2:
        	CPUScheduler sjf = new ShortestJobFirst();
        	System.out.print("Enter the number of processes: ");
    		p=sc.nextInt();
    		System.out.println();
    		for(int i=1;i<=p;i++) {
    			System.out.println("--For Process P"+i+"--\nEnter Arrival time and Burst time:");
    			int a=sc.nextInt();
    			int b=sc.nextInt();
    			String pr="P"+i;
    			sjf.add(new Row(pr, a, b));
    			
    		}
    		sjf.process();
            display(sjf);
    		break;
    		
        case 3:
        	CPUScheduler srt = new ShortestRemainingTime();
        	System.out.print("Enter the number of processes: ");
    		p=sc.nextInt();
    		System.out.println();
    		for(int i=1;i<=p;i++) {
    			System.out.println("--For Process P"+i+"--\nEnter Arrival time and Burst time:");
    			int a=sc.nextInt();
    			int b=sc.nextInt();
    			String pr="P"+i;
    			srt.add(new Row(pr, a, b));
    			
    		}
    		srt.process();
            display(srt);
    		break;
    	
        case 4:
        	CPUScheduler rr = new RoundRobin();
        	System.out.print("Enter the number of processes: ");
    		p=sc.nextInt();
    		System.out.println();
    		System.out.print("Enter the time quantum: ");
    		int t=sc.nextInt();
    		System.out.println();
    		rr.setTimeQuantum(t);
    		for(int i=1;i<=p;i++) {
    			System.out.println("--For Process P"+i+"--\nEnter Arrival time and Burst time:");
    			int a=sc.nextInt();
    			int b=sc.nextInt();
    			String pr="P"+i;
    			rr.add(new Row(pr, a, b));
    			
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
        
        System.out.print("Exiting the program");
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
        
        System.out.println("\n\nAverage WT: " + object.getAverageWaitingTime() + "\nAverage TAT: " + object.getAverageTurnAroundTime());
    }
}