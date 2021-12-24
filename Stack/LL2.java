import java.util.Scanner;

public class LL2 {

    /** Stack ADT */
    public interface Stack<E> {
        /** Reinitialize the stack. The user is responsible for
         reclaiming the storage used by the stack elements. */
        public int clear();
        /** Push an element onto the top of the stack.
         @param it The element being pushed onto the stack. */
        public int push(E it);
        /** Remove and return the element at the top of the stack.
         @return The element at the top of the stack. */
        public E pop();
        /** @return A copy of the top element. */
        public E topValue();
        /** @return The number of elements in the stack. */
        public int length();
    };

    /**
     * Singly linked list node
     */
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


    /** Linked stack implementation */
    static class LStack<E> implements Stack<E> {
        private Link<E> top; // Pointer to first element
        private int size; // Number of elements
        public int direction;

        /**
         * Constructors
         */
        public LStack() {
            top = null;
            size = 0;
        }

        public LStack(int size) {
            top = null;
            size = 0;
        }

        /**
         * Reinitialize stack
         */
        public int clear() {
            top = null;
            size = 0;
            return -1;
        }

        /**
         * Put "it" on stack
         */
        public int push(E it) {
            top = new Link<E>(it, top);
            size++;
            return -1;
        }

        /**
         * Remove "it" from stack
         */
        public E pop() {
//            assert top != null : "Stack is empty";
            E it = top.element();
            top = top.next();
            size--;
            return it;
        }

        /**
         * @return Top value
         */
        public E topValue() {
            assert top != null : "Stack is empty";
            return top.element();
        }

        /**
         * @return Stack length
         */
        public int length() {
            return size;
        }

        public void insert(E it, LStack<E> obj) {

            obj.top = new Link<E>(it, top);
            size++;

//            if(x>1)
//            {
//                curr = curr.next;
//                curr.setNext(new Link<E>(it, curr.next()));
//                if (tail == curr) tail = curr.next(); // New tail
//                cnt++;
//            }
//            else if(x==1){
//                curr.setNext(new Link<E>(it, curr.next()));
//                if (tail == curr) tail = curr.next(); // New tail
//                cnt++;
//            }
//
//            else if(x==0){                              //THE NORMAL ONE
//                curr.setNext(new Link<E>(it, curr.next()));
//                if (tail == curr) tail = curr.next(); // New tail
//                cnt++;
//            }

        }

        public void print(LStack<E> obj) {
            Link<E> temp = obj.top;   //After the blank Node

            if(direction==1) {
                System.out.print("<");
                int[] a = new int[obj.length()];

//            System.out.print(temp.element);
                a[obj.length() - 1] = (int) temp.element;
                temp = temp.next();

                for (int i = obj.length() - 2; i >= 0; i--) {
//                System.out.print(" " + temp.element);
                    a[i] = (int) temp.element;
                    temp = temp.next();
                }

                System.out.print(a[0]);

                for (int i = 1; i < obj.length(); i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.print(">");
                System.out.println("");
            }
            else if (direction==-1)
            {
                System.out.print("<");
//                int[] a = new int[obj.length()];

            System.out.print(temp.element);
//                a[obj.length() - 1] = (int) temp.element;
                temp = temp.next();

                for (int i = 1; i < obj.length(); i++) {
                System.out.print(" " + temp.element);
//                    a[i] = (int) temp.element;
                    temp = temp.next();
                }

//                System.out.print(a[0]);
//
//                for (int i = 1; i < obj.length(); i++) {
//                    System.out.print(" " + a[i]);
//                }

                System.out.print(">");
                System.out.println("");
            }
        }

        public void setDirection(int direction)
        {
            this.direction = direction;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int k;  //initial length
        int x;  //memory chunk

        k = scn.nextInt();
        x = scn.nextInt();
        LStack<Integer> obj1 = new LStack<Integer>();

        for(int i=0; i<k; i++)
        {
            int ini = scn.nextInt();
            obj1.insert(ini, obj1);
        }

//        System.out.println(obj1.topValue());

        obj1.print(obj1);

        int input = -1;
        int input2 = -1;

        while(input!=0 && input2!=0){
            input = scn.nextInt();

            if(input==1)
            {
                int ignore = scn.nextInt();
                System.out.println(obj1.clear());
            }
            else if(input==2)
            {
                input2 = scn.nextInt();
                int ret = obj1.push(input2);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input==3)
            {
                int ignore = scn.nextInt();
                int ret = obj1.pop();
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
                System.out.println(obj1.topValue());
            }
            else if(input==6)
            {
                input2 = scn.nextInt();
                obj1.print(obj1);
                obj1.setDirection(input2);
            }
            else System.out.println("Invalid Output!");
        }
    }

}
