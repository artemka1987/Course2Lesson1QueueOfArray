package ru.kupchenkov;

public class App {

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        queue.print();
        System.out.println("-------- Size of queue:" + queue.getSize());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        System.out.println("-------- Size of queue:" + queue.getSize());
        queue.dequeue();
        queue.print();
        System.out.println("-------- Size of queue:" + queue.getSize());
        queue.enqueue(123);
        queue.print();

    }

}
