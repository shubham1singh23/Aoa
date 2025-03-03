import java.util.Arrays;

class Job{
    int profit,deadline;

    Job(int profit,int deadline){
       this.profit=profit;
       this.deadline=deadline;
    }
}
 class JobSequencing {
     public static void main(String[] args) {

    int n=5;
     Job[] jobs=new Job[n];

     jobs[0] = new Job(100, 2);
     jobs[1] = new Job(200, 1);
     jobs[2] = new Job(50, 3);
     jobs[3] = new Job(150, 2);
     jobs[4] = new Job(300, 1);

     Arrays.sort(jobs,(a,b)->Integer.compare(b.profit,a.profit));

     int maxD=jobs[0].deadline;

     for (Job ditto:jobs){
         if(ditto.deadline>maxD){
             maxD=ditto.deadline;
         }
     }

     int[] timeSlots=new int[maxD];
         Arrays.fill(timeSlots,-1);
         int maxProfit=0;

         for (Job current:jobs){
             for (int j=current.deadline-1;j>=0;j--){
                 if(timeSlots[j]==-1){
                     timeSlots[j]=current.profit;
                     maxProfit+=current.profit;
                     break;
                 }
             }
         }

         System.out.println("Job Sequence is ");

         for (int i:timeSlots){
             System.out.print(i+" -> ");
         }
         System.out.println();
         System.out.println("Max Profit: "+maxProfit);

     }

}
