import java.util.ArrayList;
import java.util.List;

public class NaiveStringMatching {
    static String s="AABABBAABAABABBAABAABA";
    static String pattern="AABA";

    public static void main(String[] args) {
        int window=pattern.length();
        int n=s.length();

        List<Integer> ans=new ArrayList<>();

        for (int i=0;i<=n-window;i++){
           if (s.substring(i,i+window).equals(pattern)){
               ans.add(i);
           }
        }
        System.out.println(s);
        System.out.println(pattern);
        System.out.println(ans);
    }
}
