package array;

/**
 * Created by taoshiliu on 2018/5/13.
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
