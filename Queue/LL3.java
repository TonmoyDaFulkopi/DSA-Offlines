import java.util.Scanner;

public class LL3 {

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
        public E dequeue();
        /** @return The front element. */
        public E frontValue();
        /** @return The number of elements in the queue. */
        public int length();
    }


    static class Link<E> {
        private E element; // Value for this node
        private Link<E> next; // Pointer to next node in list

        // Constructors
        Link(E it, Link<E> nextval) {
            element = it;
            next = nextval;
        }

        Link(Link<E> nextval) {
            next = nextval;
        }

        Link<E> next() {
            return next;
        } // Return next field

        Link<E> setNext(Link<E> nextval) // Set next field
        {
            return next = nextval;
        } // Return element field

        E element() {
            return element;
        } // Set element field

        E setElement(E it) {
            return element = it;
        }
    }

    /** Linked queue implementation */
    static class LQueue<E> implements Queue<E> {
        private Link<E> head; // Pointer to list header
        private Link<E> front; // Pointer to front queue node
        private Link<E> rear; // Pointer to rear queuenode
        private int size; // Number of elements in queue

        /**
         * Constructors
         */
        public LQueue() {
            init();
        }

        public LQueue(int size) {
            init();
        } // Ignore size

        /**
         * Initialize queue
         */
        private void init() {
            front = rear = new Link<E>(null); // Create header
            size = 0;
        }

        /**
         * Reinitialize queue
         */
        public int clear() {
            init();
            return -1;
        }

        /**
         * Put element on rear
         */
        public int enqueue(E it) {
            rear.setNext(new Link<E>(it, null));
            rear = rear.next();
            size++;
            return -1;
        }

        /**
         * Remove and return element from front
         */
        public E dequeue() {
//            E it = front.element();
//            front.setNext(front.next());
            E it = front.next().element(); // Store dequeued value
            front.setNext(front.next().next()); // Set Next Link Pointer for front

            if (front.next() == null) rear = front; // Last Object
            size--;

            return it; // Return Object
        }

        public E leaveQueue() {
//            E it = front.next().element(); // Store dequeued value

            Link<E> temp = front;
            E it = null;

            for (int i=0; i< this.size; i++)
            {
                if(temp.next==this.rear) {
                    it = temp.next.element();
                    break;
                }
                temp = temp.next;
            }

            this.rear = temp;
            this.size--;

            return it; // Return Object
        }

        /**
         * @return Front element
         */
        public E frontValue() {
            assert size != 0 : "Queue is empty";
            return front.next().element();
        }

        /**
         * @return Rear element
         */
        public E rearValue() {
            return rear.element();
        }

        /**
         * @return Queue size
         */
        public int length() {
            return size;
        }

        /**
         * Print Function/s
         */
        public void print(LQueue<E> obj) {
                Link<E> temp = obj.front.next();   //After the blank Node

                System.out.print("<");

                int[] a = new int[obj.size];    // [7] 0 - 6

//            System.out.print(temp.element);
//                a[obj.length() - 1] = (int) temp.element;
//                a[1] = (int) temp.element;
//                temp = temp.next();

                for (int i = 0; i < obj.size; i++) {   // 0 - 6
//                System.out.print(" " + temp.element);
                    a[i] = (int) temp.element;
                    temp = temp.next();
                }

                System.out.print(a[0]);

                for (int i = 1; i < obj.size; i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.print(">");
                System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int k;  //initial length
        k = scn.nextInt();

        LQueue<Integer> obj1 = new LQueue<Integer>(k);

        for(int i=0; i<k; i++)
        {
            int ini = scn.nextInt();
            obj1.enqueue(ini);
        }

        obj1.print(obj1);

        int input = -1;
        int input2 = -1;

        while(input!=0 && input2!=0) {
            input = scn.nextInt();

            if(input==1)
            {
                int ignore = scn.nextInt();
                obj1.print(obj1);
                System.out.println(obj1.clear());
            }
            else if(input==2)
            {
                input2 = scn.nextInt();
                int ret = obj1.enqueue(input2);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==3)
            {
                int ignore = scn.nextInt();
                int ret = obj1.dequeue();
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==4)
            {
                int ignore = scn.nextInt();
                obj1.print(obj1);
                System.out.println(obj1.length());
            }
            else if(input==5)
            {
                int ignore = scn.nextInt();
                obj1.print(obj1);
                System.out.println(obj1.frontValue());
            }
            else if(input==6)
            {
                int ignore = scn.nextInt();
                obj1.print(obj1);
                System.out.println(obj1.rearValue());
            }
            else if(input==7)
            {
                if(obj1.size==1)
                {
                    System.out.println("<>");
                    System.out.println(obj1.dequeue());
                    continue;
                }
                int ignore = scn.nextInt();
                int ret = obj1.leaveQueue();
                obj1.print(obj1);
                System.out.println(ret);
            }
        }

    }

}
