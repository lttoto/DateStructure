package array;

/**
 * Created by taoshiliu on 2018/5/2.
 */
public class initTestMain {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for(int i = 0;i < arr.length;i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100,99,66};
        for(int i = 0;i < scores.length;i++) {
            System.out.println(scores[i]);
        }
        for(int score:scores) {
            System.out.println(score);
        }
    }
}
