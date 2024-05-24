package datastructures;

public class MyArrayList {
    private int[] array;
    private static final int INITIAL_SIZE = 5;
    private int size;

    public MyArrayList() {
        init();
    }

    private void init() {
        array = new int[INITIAL_SIZE];
        size = 0;
    }

    public void add(int element) {
        if(isFull()) array = grow();
        array[size++] = element;
    }

    public void add(int index, int element) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if(isFull()) array = grow();

        for(int i=size; i>index; i--) {
            array[i] = array[i-1];
        }

        array[index] = element;
        size++;
    }

    public void set(int index, int element) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        array[index] = element;
    }

    public int remove(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        int removed = array[index];
        for(int i=index; i<size-1; i++) {
            array[i] = array[i+1];
        }
        size--;

        return removed;
    }

    public int indexOf(int element) {
        for(int i=0; i<size; i++) {
            if(array[i] == element)
                return i;
        }
        return -1;
    }

    public int get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return array[index];
    }

    public boolean contains(int element) {
        for(int i=0; i<size; i++) {
            if(array[i] == element)
                return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        init();
    }

    private boolean isFull() {
        return size == array.length;
    }

    private int[] grow() {
        int[] temp = new int[array.length * 2];
        System.arraycopy(array, 0, temp, 0, size);
        return temp;
    }

    @Override
    public String toString() {
        if(size == 0)  return "[]";

        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<size-1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");

        return sb.toString();
    }
}
