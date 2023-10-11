public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int last;
    private int length;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        last = 4;
        length = 8;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int addone(int index, int length) {
        index %= length;
        if (index == length - 1) {
            return 0;
        }
        index += 1;
        return index;
    }

    private int minusone(int index) {
        if (index == 0) {
            return length - 1;
        }
        index -= 1;
        return index;
    }

    private void grow() {
        T[] newarray = (T[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != last) {
            newarray[ptr2] = items[ptr1];
            ptr1 = addone(ptr1, length);
            ptr2 = addone(ptr2, length * 2);
        }
        front = length;
        last = ptr2;
        length *= 2;
        items = newarray;
    }

    /** When we use the following method,we should know:
     *  For arrays of length 16 or more, the usage factor should always be at least 25%.
     *  For smaller arrays, your usage factor can be arbitrarily low.
     *  Usage Ratio,which in current class is the size divided by the length.
     *  When Usage Ratio is less 25%,then we should halve the size of the items(which is the array of the class)
     */
    private void shrink() {
        T[] newarray = (T[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 4;
        while (ptr1 != last) {
            newarray[ptr2] = items[ptr1];
            ptr1 = addone(ptr1, length);
            ptr2 = addone(ptr2, length / 2);
        }
        front = length / 4;
        last = ptr2;
        length /= 2;
        items = newarray;
    }
    public void addFirst(T item){
        if(size==length){
            grow();
        }
        front=minusone(front);
        items[front]=item;
    }
    public void addLast(T item){
       if(size==length){
           grow();
       }
       items[last]=item;
       last=addone(last,length);
    }
    public T removeFirst(){
        if(length>=16&&(size/length<=0.25)){
            shrink();
        }
        if(size==0){
            return null;
        }
        T temp=items[front];
        items[front]=null;
        front=addone(front,length);
        size--;
        return temp;
    }
    public T removeLast(){
        if(length>=16&&(size/length<=0.25)){
            shrink();
        }
        if(size==0){
            return null;
        }
        T temp=items[minusone(last)];
        items[minusone(last)]=null;
        last=minusone(last);
        size--;
        return temp;
    }
    public void printDeque(){
        int ptr1=front;
        while(ptr1!=last){
            System.out.print(items[ptr1]+" ");
            ptr1=addone(ptr1,length);
        }
    }
    public T get(int index){
        if(index>=length){
            return null;
        }
        int ptr1=front;
        for(int i=0;i<index;i++){
            ptr1=addone(ptr1,length);
        }
        return items[ptr1];
    }


}