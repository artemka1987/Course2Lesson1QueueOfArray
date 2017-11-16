package ru.kupchenkov;

public class Queue<E> {

    private Object[] queue;
    private int size = 16;
    private int eCount;
    private int first;
    private int last;

    public Queue(){
        queue = new Object[size];
        last = -1;
    }

    //add
    public boolean enqueue(E value){
        if (last + 1 == size){
            if (!increase()) return false;
        }
        queue[++last] = value;
        eCount++;
        return true;
    }

    //remove
    public boolean dequeue(){
        if (isEmpty()){
            System.err.println("Queue is empty!");
            return false;
        }
        first++;
        eCount--;
        // shift queue to left
        if (first >= size / 3){
            System.arraycopy(queue, first, queue, 0, eCount);
            first = 0;
            last = eCount - 1;
        }
        return true;
    }

    //print
    public void print(){
        if (isEmpty()) System.out.println("Queue is empty.");
        for(int i = first; i < eCount + first; i++){
            System.out.println("value: " + queue[i] + " (index = " + i + ")");
        }
    }

    //increase
    private boolean increase(){
        int newSize;
        if (size == Integer.MAX_VALUE){
            System.err.println("A queue cannot be increased. This is the maximum size.");
            return false;
        }else if(size >= Integer.MAX_VALUE / 1.5f){
            newSize = Integer.MAX_VALUE;
        }else{
            newSize = (int)(size * 1.5f);
        }
        Object[] newQueue = new Object [newSize];
        System.arraycopy(queue, first, newQueue, 0, eCount);
        first = 0;
        last = eCount - 1;
        size = newSize;
        queue = newQueue;
        return true;
    }

    public boolean isEmpty(){
        return eCount == 0;
    }

    public int getSize(){
        return eCount;
    }

}
