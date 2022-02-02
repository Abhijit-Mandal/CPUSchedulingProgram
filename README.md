# CPU Scheduling Program #
### **Project Description:** ###
The JAVA program provides an interface to the user to implement the following
scheduling policies as per the choice provided:
1. First Come First Served (FCFS)
2. Shortest Job First (SJF)
3. Shortest Remaining Time First (SRTF)
4. Round Robin (RR)

Appropriate option needs to be chosen from a switch case based menu driven program with an
option of “Exit from program” in case 5 and accordingly a scheduling policy will print the Gantt
chart and the average waiting time, average turnaround time and average response time. The
program will take Process ids, its arrival time, and its CPU burst time as input. For implementing
RR scheduling, user also needs to specify the time quantum. Assume that the process ids should be
unique for all processes. Each process consists of a single CPU burst (no I/O bursts), and processes
are listed in order of their arrival time. Further assume that an interrupted process gets placed at the
back of the Ready queue, and a newly arrived process gets placed at the back of the Ready queue as
well. The output should be displayed in a formatted way for clarity of understanding and visual.

### Output Example: ###
![](https://i.imgur.com/W1rv337l.png)
