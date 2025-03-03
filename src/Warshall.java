 class Warshall {
    static final int Inf=Integer.MAX_VALUE;
     public static void main(String[] args) {
         int n=4;
         int[][] D={
                 {0,5,9,Inf},
                 {Inf,0,1,Inf},
                 {Inf,Inf,0,Inf},
                 {Inf,3,2,0}
         };


         for (int i=0;i<n;i++){
             for (int j=0;j<n;j++){
                 for (int k=0;k<n;k++){
                     if(D[j][i]!=Inf&&D[i][k]!=Inf){
                         if(D[j][i]+D[i][k]<D[j][k]){
                             D[j][k]=D[j][i]+D[i][k];
                         }
                     }
                 }
             }


         }

         for (int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 System.out.print(D[i][j]+" ");
             }
             System.out.println();
         }

     }
}
