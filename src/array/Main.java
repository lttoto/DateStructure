package array;

/**
 * Created by taoshiliu on 2018/5/3.
 */
public class Main {

    public static void main(String[] args) {
        Array arr = new Array(20);
        for(int i = 0;i < 10;i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
