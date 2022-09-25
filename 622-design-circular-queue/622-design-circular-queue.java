class MyCircularQueue {

    private int[] arr;
    private int capacity;
    private int count;
    private int front;
    
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        capacity = k;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        print();
        
        if(!isFull()) {
            arr[(front+count)%arr.length] = value;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        print();
        
        if(!isEmpty()) {
            front = (front+1)%arr.length;
            count--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : arr[(front+count-1)%arr.length];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==arr.length;
    }
    
//     private int increment(int idx) {
//         return (idx+1)%arr.length;
//     }
    
//     private int decrement(int idx) {
//         return (idx-1+arr.length)%arr.length;
//     }
    
    private void print() {
        System.out.println(front + " " + count);
        
        // if(!isEmpty()) {
        //     for(int i=increment(front) ; i!=rear ; i=increment(i))
        //         System.out.print(arr[i] + " ");
        //     System.out.println();
        // }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */