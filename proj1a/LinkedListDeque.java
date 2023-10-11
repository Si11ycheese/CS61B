public class LinkedListDeque<T> {
    private class IntNode{
        public T item;
        public IntNode next;
        public IntNode pre;
        public IntNode(T i,IntNode p,IntNode n){
            item=i;
            next=n;
            pre=p;
        }
        /** for sentinel */
        public IntNode(IntNode p,IntNode n){
            pre=p;
            next=n;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel =new IntNode(null,null);
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
    }
    public void addFirst(T item){
        IntNode add_new=new IntNode(item,sentinel,sentinel.next);
        sentinel.next.pre=add_new;
        sentinel.next=add_new;
        size+=1;
    }
    public void addLast(T item){
        IntNode p=new IntNode(item,sentinel.pre,sentinel);
        sentinel.pre.next=p;
        sentinel.pre=p;
        size+=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        IntNode p=sentinel.next;
        while(p!=sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        IntNode p=sentinel.next;
        T item=p.item;
        sentinel.next=p.next;
        p.next.pre=sentinel;
        size--;
        return item;
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        IntNode p=sentinel.pre;
        T item=p.item;
        p.pre.next=sentinel;
        sentinel.pre=p.pre;
        size--;
        return item;
    }
   public T get(int index){
        IntNode p=sentinel;
        if(index>=size){
            return null;
        }
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return p.item;
   }
   private T getREcursivehelper(IntNode p,int index){
        if(index==0){
            return p.item;
        }
        return getREcursivehelper(p.next,index-1);
   }
   public T getRecursive(int index){
        if(index>=size){
            return null;
        }
        IntNode p=sentinel;
        return getREcursivehelper(p.next,index);
   }
}
