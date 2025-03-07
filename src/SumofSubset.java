import java.util.*;
public class SumofSubset {
    static int[] a={10,12,13,5,18,11,23,15,3,2,4,7};
    static int target=30;
    static List<List<Integer>> allsubset;
    static List<Integer> currentsubset;


    public static void main(String[] args) {
    allsubset=new ArrayList<>();
    currentsubset=new ArrayList<>();
    //for optimization
    Arrays.sort(a);
    subset(0,0);

    for (List<Integer> ans:allsubset){
        System.out.println(ans);
    }
    }

    static void subset(int index,int currentsum){
        if (currentsum==target){
            //new arraylist as the java using call by reference
            allsubset.add(new ArrayList<>(currentsubset));
            return;
        }

        for (int i=index;i<a.length;i++){
            if (currentsum+a[i]<=target){

                currentsubset.add(a[i]);
                subset(i+1,currentsum+a[i]);
                //backtrack
                currentsubset.removeLast();
            }
        }
    }
}
