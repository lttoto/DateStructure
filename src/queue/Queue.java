package queue;

/**
 * Created by taoshiliu on 2018/5/15.
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
