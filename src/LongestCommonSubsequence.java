import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First string");
        String s1=sc.next();
        System.out.println("Enter Second string");
        String s2=sc.next();

        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();

        int n=a.length;
        int m=b.length;

        int[][] dp=new int[n+1][m+1];

        //column and row zero is already zero
        //fill the dp table according to algorithm


        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (a[i-1]==b[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i=n;
        int j=m;
        StringBuilder ans=new StringBuilder();

        //backtrack to get the longest subsequence

        while (i>0&&j>0){
            if (a[i-1]==b[j-1]){
                ans.append(a[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }

        //reverse the string and print

        System.out.println("The longest common subsequence is "+ans.reverse());
        System.out.println("The size is "+dp[n][m]);


    }
}
