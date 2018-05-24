package Set;

/**
 * Created by taoshiliu on 2018/5/22.
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
