import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

    //number of vertices
   static int V=5;

    //number of colors
  static   int m=3;

    static int[][] graph = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {0, 1, 1, 1, 0}
    };

  static   int[] color=new int[V];

 static    List<List<Integer>> solutions=new ArrayList<>();

   static boolean isSafe(int node,int col){
        for (int i=0;i<V;i++){
            if (graph[node][i]==1&&color[i]==col){
                return false;
            }
        }
        return true;
    }

  static   void solve(int node){
        if (node==V){
            List<Integer> currsoln=new ArrayList<>();
            for (int i:color){
                currsoln.add(i);
            }
            solutions.add(currsoln);
            return;
        }


        //Assume m colors from i to m  and assign zero to backtrack
        for (int col = 1; col <=m; col++){
            if (isSafe(node,col)){
                color[node]=col;

                solve(node+1);

                color[node]=0;

            }

        }


    }

    public static void main(String[] args) {
        solve(0);

        for (List<Integer> solution:solutions){
            System.out.println(solution);
        }
    }
}
