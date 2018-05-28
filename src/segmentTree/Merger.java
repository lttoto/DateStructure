package segmentTree;

/**
 * Created by taoshiliu on 2018/5/27.
 */
public interface Merger<E> {
    E merge(E a,E b);
}
