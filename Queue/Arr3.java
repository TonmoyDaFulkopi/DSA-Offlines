import java.util.Scanner;


public class Arr3 {
    /** Queue ADT */
    public interface Queue<E> {
        /** Reinitialize the queue. The user is responsible for
         reclaiming the storage used by the queue elements. */
        public int clear();
        /** Place an element at the rear of the queue.
         @param it The element being enqueued. */
        public int enqueue(E it);
        /** Remove and return element at the front of the queue.
         @return The element at the front of the queue. */
        public E dequeue(AQueue<E> obj);
        /** @return The front element. */
        public E frontValue();
        /** @return The number of elements in the queue. */
        public int length();
    }

    /** Array-based queue implementation */
    static class AQueue<E> implements Queue<E> {
        private static final int defaultSize = 10;
        private int maxSize; // Maximum size of queue
        private int front; // Index of front element
        private int rear; // Index of rear element
        private E[] listArray; // Array holding queue elements
        public int inc;

        /**
         * Constructors
         */
        AQueue() {
            this(defaultSize);
        }

        @SuppressWarnings("unchecked")
            // For generic array
        AQueue(int size) {
            maxSize = size + 1; // One extra space is allocated
            this.inc = size;
            rear = 0;
            front = 1;
            listArray = (E[]) new Object[maxSize]; // Create listArray
        }

        /**
         * Reinitialize
         */
        public int clear() {
            rear = 0;
            front = 1;
            return -1;
        }

        /**
         * Put "it" in queue
         */
        public int enqueue(E it) {
//            assert ((rear + 2) % maxSize) != front : "Queue is full";
            rear = (rear + 1) % maxSize; // Circular increment
            listArray[rear] = it;
            return -1;
        }

        /**
         * Remove and return front value
         */
        public E dequeue(AQueue<E> obj1) {
//            assert length() != 0 : "Queue is empty";
            E it = listArray[front];
//            front = front + 1; // Circular increment
            for(int i=1; i<=rear-1; i++)
            {
                listArray[i] = listArray[i+1];
            }

//            this.maxSize--;
            this.rear--;
//            if(length()==0){
//                obj1.maxSize--;
//                obj1.rear--;
//            }
            return it;
        }

        /**
         * Deque the rear element
         */
        public E leaveQueue(AQueue<E> obj1) {
            E it = listArray[rear];

            this.maxSize--;
            this.rear--;
//            if(length()==0){
//                obj1.maxSize--;
//                obj1.rear--;
//            }
            return it;
        }

        /**
         * @return Front value
         */
        public E frontValue() {
//            assert length() != 0 : "Queue is empty";
            return listArray[front];
        }

        public E rearValue() {
//            assert length() != 0 : "Queue is empty";
            return listArray[rear];
        }

        /**
         * @return Queue size
         */
        public int length() {
//            return ((rear + maxSize) - front + 1) % maxSize;
            return rear;
        }

        /**
         * Print function/s
         */
        public void print(AQueue<E> obj) {
                System.out.print("<");
                System.out.print(listArray[1]);
                for (int i = 2; i <= obj.rear; i++) {             //Change it later to top
                    System.out.print(" " + listArray[i]);
                }
                System.out.print(">");
                System.out.println("");
        }


        /**
         * Memory increment
         */
        private AQueue<E> memInc(AQueue<E> obj1) {
            AQueue<E> obj = new AQueue<E>(maxSize + inc);
            for (int i = 0; i <= obj1.rear; i++) {
                obj.listArray[i] = (E) obj1.listArray[i];
            }
            obj.rear = obj1.rear;

            return obj;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k;  //initial length
        /**
         * Memory chunk is ignored
         */
        int x;  //memory chunk

        k = scn.nextInt();
        AQueue<Integer> obj1 = new AQueue<>(k);

        /**
         * No need for insert_ini
         */

        int input = -1;
        int input2 = -1;

        while (input != 0 && input2 != 0) {
            input = scn.nextInt();

            if(input==1)
            {
                int ignore = scn.nextInt();
                int a = obj1.clear();
//                obj1.print(obj1);
                System.out.println(a);
            }
            else if(input==2)
            {
                if (obj1.rear == obj1.maxSize-1) {
                    obj1 = obj1.memInc(obj1);
                }
                input2 = scn.nextInt();
                int ret;
                ret = obj1.enqueue(input2);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==3)
            {
                int ignore = scn.nextInt();
                if (obj1.length() == 0) {
                    System.out.println("<>");
                    System.out.println("null");
                    continue;
                }
                int ret = obj1.dequeue(obj1);
                if (obj1.length() == 0) {
                    System.out.println("<>");
                    System.out.println(ret);
                    continue;
                }
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==4)
            {

                int ignore = scn.nextInt();
                int ret = obj1.length();
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==5)
            {
                int ignore = scn.nextInt();
                int ret = obj1.frontValue();
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==6)
            {
                int ignore = scn.nextInt();
                int ret = obj1.rearValue();
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==7)
            {
                int ignore = scn.nextInt();
                if (obj1.length() == 0) {
                    System.out.println("<>");
                    System.out.println("null");
                    continue;
                }
                int ret = obj1.leaveQueue(obj1);
                if (obj1.length() == 0) {
                    System.out.println("<>");
                    System.out.println(ret);
                    continue;
                }
                obj1.print(obj1);
                System.out.println(ret);
            }
            else System.out.println("Invalid Input!");
        }
    }
}
