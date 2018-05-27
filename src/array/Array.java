package array;

/**
 * Created by taoshiliu on 2018/5/2.
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[])new Object[arr.length];
        for(int i = 0;i < arr.length;i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        if(size != data.length) {
            data[size] = e;
            size++;
        }else {
            throw new IllegalArgumentException("AddLast fail");
        }

        //this.add(size,e);
    }

    public void addFirst(E e) {
        this.add(0,e);
    }

    public void add(int index,E e) {
        if(size == data.length) {
            resize(2*data.length);
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add fail");
        }

        for(int i = size - 1;i >= index;i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail");
        }
        return data[index];
    }

    public E getFirst() {
        return get(size - 1);
    }

    public E getLast() {
        return get(0);
    }

    public void set(int index,E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for(int i = 0; i <size ;i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for(int i = 0; i <size ;i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw  new IllegalArgumentException("Remove failed");
        }
        E ret = data[index];
        for(int i = index + 1;i < size;i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public void swap(int i,int j) {
        if(i < 0 || i >= size || j < 0 ||j >= size) {
            throw new IllegalArgumentException("Index error");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d ,capacity = %d\n",size,data.length));
        res.append('[');
        for(int i = 0;i < size; i++) {
            res.append(data[i]);
            if(i != size - 1 ) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0;i < size ;i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
