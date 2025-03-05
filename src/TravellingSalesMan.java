import java.util.Arrays;

public class TravellingSalesMan {
    static int[][] dist;
   static int[][] dp;
    static int n;

    static int tsp(int mask,int pos){

        //if all cities are visited then return cost from current city to source 0
        if (mask==(1<<n)-1){
            return dist[pos][0];
        }

        //if the solution is already calculated
        if (dp[pos][mask]!=-1){
            return dp[mask][pos];
        }

        int minCost=Integer.MAX_VALUE/2;

        for (int city=0;city<n;city++){

            //check if city is visited
            if ((mask & (1<<city))==0){
                int newCost=dist[pos][city]+tsp(mask |(1<<city),city);
                minCost=Math.min(newCost,minCost);
            }

        }

        //memoization
        dp[pos][mask]=minCost;
        return minCost;
    }

    public static void main(String[] args) {
        dist=new int[][]{
                {0,12,10,2},
                {20,0,11,22},
                {10,22,0,21},
                {11,22,33,0}
        };
        n= dist.length;

        dp=new int[n][1<<n];

        for (int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans=tsp(1,0);

        System.out.println("The shortest path is "+ans);
    }
}
