import java.util.ArrayList;
import java.util.List;

public class NaiveStringMatching {
    static String s="AABABBAABAABABBAABAABA";
    static String pattern="AABA";

    public static void main(String[] args) {
        int window=pattern.length();
        int n=s.length();
        boolean isSame;
        List<Integer> ans=new ArrayList<>();

        for (int i=0;i<=n-window;i++){
            isSame=true;
            for (int j=i;j<i+window;j++){
                if (s.charAt(j)!=pattern.charAt(j-i))
                {

                    isSame=false;
                    break;
                }


            }

            if (isSame){
                ans.add(i);
            }
        }
        System.out.println(s);
        System.out.println(pattern);
        System.out.println(ans);
    }
}
