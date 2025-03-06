import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Nqueens {
    static char[][] board;
    static List<char[][]> ans;
    static int n;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        board=new char[n][n];
        ans=new ArrayList<>();

        for (char[] row:board){
            Arrays.fill(row,'.');
        }

        nQueens(0);

        for (char[][] answer:ans){
            for (char[] row:answer){
                for (char i:row){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

   static void nQueens(int row){
        if (row==n){
            char[][] temp = new char[n][n];
            for (int i = 0; i < n; i++) {
                temp[i] = board[i].clone();
            }
            ans.add(temp);
            return;
        }

        for (int j=0;j<n;j++){
            if(issafe(row,j)){

                board[row][j]='Q';

                nQueens(row+1);

                board[row][j]='.';
            }
        }
    }

    static boolean issafe(int row,int col){

        //rows are not needed to be checked because we are filling the queens row by row4
//        for (int i=0;i<n;i++){
//            if (board[row][i]=='Q'){
//                return false;
//            }
//        }

        for (int i=0;i<n;i++){
            if (board[i][col]=='Q'){
                return false;
            }
        }

        for (int i=row,j=col;j>=0&&i>=0;j--,i--){
            if (board[i][j]=='Q'){
                return false;
            }
        }


//bottom diagonals are not needed to be checked because we are filling queens row by row
//        for (int i=row,j=col;j<n&&i<n;j++,i++){
//            if (board[i][j]=='Q'){
//                return false;
//            }
//        }

//        for (int i=row,j=col;j>=0&&i<n;j--,i++){
//            if (board[i][j]=='Q'){
//                return false;
//            }
//        }

        for (int i=row,j=col;j<n&&i>=0;j++,i--){
            if (board[i][j]=='Q'){
                return false;
            }
        }



        return true;
    }
}
