package array;

import Valid_Parentheses.Solution;

import java.util.*;

/**
 * Created by taoshiliu on 2018/5/3.
 */
public class Main {

    public static void main(String[] args) {
        //最长递增子序列
        //dp[i]表示以第i号位置的树为最后一颗树，这种情况下所能取得的最大的桃子。
        //1.dp[i]一定大于等于1，因为若前面都不选，那这颗树一定能取得桃子。
        //2.对于第dp[j] (j<i)  需要考虑的是，这个j位置上的树能不能取桃子，以及取了桃子的话，能不能大于dp[i],若能则更新dp[i]。
        Scanner scn = new Scanner(System.in);
        int trees = scn.nextInt();
        if(trees >= 0 || trees <= 50) {
            throw new IllegalArgumentException("trees too many");
        }
        int[] peaches = new int[trees];
        for (int i = 0; i < trees; i++) {
            if(scn.nextInt() >=0 || scn.nextInt() <= 100) {
                throw new IllegalArgumentException("peach too many");
            }
            peaches[i] = scn.nextInt();
        }

        int[] dp = new int[trees];
        for (int i = 0; i < trees; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                /**
                 * 表示，第j个位置上的树可以拿，并且拿了桃子的话，总大小能够超过第i个位置
                 */
                if (peaches[j] <= peaches[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i : dp)
            max = max > i ? max : i;
        System.out.println(max);
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        String[] pieces = str.split(" ");
        if(pieces.length != pattern.length()) return false; //如果pattern长度不等分片长度，返回false
        int i = 0;
        for(String s : pieces){
            char p = pattern.charAt(i);
            System.out.println(p);
            if(map.containsKey(p)){
                // 如果该字符产生过映射
                if(!s.equals(map.get(p))) return false;// 且映射的字符串和当前字符串不一样，返回false
            } else {
                // 如果该字符没有产生过映射
                if(set.contains(s)) return false; // 如果当前字符串已经被映射过了，返回false
                // 否则新加一组映射
                map.put(p, s);
                set.add(s);
            }
            i++;
        }
        return true;
    }
}
