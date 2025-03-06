import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequencememo {
   static String s1;
   static String s2;
   static char[] a;
   static char[] b;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First string");
        s1=sc.next();
        System.out.println("Enter Second string");
        s2=sc.next();

        a=s1.toCharArray();
        b=s2.toCharArray();

        int n=a.length;
        int m=b.length;

        int[][] dp=new int[n+1][m+1];
        for (int[] row:dp){
        Arrays.fill(row,-1);
        }

        int ans=lcs(0,0,dp);
        System.out.println(ans);
    }

    static int lcs(int i,int j,int[][] dp){
        if(i==a.length||j==b.length){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        if (a[i]==b[j]){
            return 1+lcs(i+1,j+1,dp);
        }
        dp[i][j]=Math.max(lcs(i+1,j,dp),lcs(i,j+1,dp));
        return dp[i][j];
    }
}
