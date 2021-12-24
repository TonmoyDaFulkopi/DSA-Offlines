import java.util.Scanner;

public class Arr2 {

    /**
     * Stack ADT
     */
    public interface Stack<E> {
        /**
         * Reinitialize the stack. The user is responsible for
         * reclaiming the storage used by the stack elements.
         */
        public int clear();

        /**
         * Push an element onto the top of the stack.
         *
         * @param it The element being pushed onto the stack.
         */
        public int push(E it);

        /**
         * Remove and return the element at the top of the stack.
         *
         * @return The element at the top of the stack.
         */
        public E pop();

        /**
         * @return A copy of the top element.
         */
        public E topValue();

        /**
         * @return The number of elements in the stack.
         */
        public int length();
    }

    ;

    /**
     * Array-based stack implementation
     */
    static class AStack<E> implements Stack<E> {
        private static final int defaultSize = 10;
        private int maxSize; // Maximum size of stack
        private int top; // Index for top Object
        private E[] listArray; // Array holding stack
        private int inc;
        public int direction = 1;

        /**
         * Constructors
         * @param direction
         * @param temp
         */
        AStack(int direction, int[] temp) {
            this(defaultSize);
        }

        @SuppressWarnings("unchecked")
            // Generic array allocation
        AStack(int size) {
            maxSize = size;
            inc = size;
            top = 0;
            listArray = (E[]) new Object[size]; // Create listArray
        }

        AStack(int direction, E[] arr)
        {
//            maxSize = size;
//            inc = size;
            if(direction==1) {
                top = 0;
                listArray = arr; // Create listArray
            }
            else if(direction==-1) {
                top = 0;
                listArray = arr; // Create listArray
            }
        }

        public void insert_ini(E it) {
//            assert listSize < maxSize : "List capacity exceeded";
            listArray[top++] = it;

//            return (E) this;
        }

        /**
         * Reinitialize stack
         */
        public int clear() {
            top = 0;
            System.out.println("<>");
            return -1;
        }

        /**
         * Push "it" onto stack
         */
        public int push(E it) {
//            assert top != maxSize : "Stack is full";
            if(direction==1) {
                listArray[top++] = it;
            }
            else if(direction==-1){
                listArray[maxSize-1-top] = it;
                System.out.println(maxSize-1-top);
                top++;
            }
            return -1;
        }

        /**
         * Remove and top element
         */

        public E pop() {
            if(direction==1) {
                assert top != 0 : "Stack is empty";
                return listArray[--top];
            }
            else if(direction==-1){
//                int temp = top;
                top--;
                return listArray[maxSize-1-(top)];
            }
            return null;
        }


        /**
         * @return Top element
         */
        public E topValue() {
            assert top != 0 : "Stack is empty";
            return listArray[top - 1];
        }

        /**
         * @return Stack size
         */
        public int length() {
            return top;
        }

        public void print() {
            if (direction==1) {
                System.out.print("<");
                System.out.print(listArray[0]);

                for (int i = 1; i < top; i++) {
                    System.out.print(" " + listArray[i]);
                }
                System.out.print(">");
                System.out.println("");
            }
            else if (direction==-1)
            {
//                System.out.print("<");
//                System.out.print(listArray[top]);
//
//                for (int i = top - 1; i >= 0; i--) {
//                    System.out.print(" " + listArray[i]);
//                }
//                System.out.print(">");
//                System.out.println("");
                System.out.print("<");
                System.out.print(listArray[0]);

                for (int i = 1; i < top; i++) {
                    System.out.print(" " + listArray[i]);
                }
                System.out.print(">");
                System.out.println("");
            }
        }

        public void print(AStack<E> obj) {
            if(direction==1) {
                System.out.print("<");
                System.out.print(listArray[0]);
                for (int i = 1; i < top; i++) {             //Change it later to top
                    System.out.print(" " + listArray[i]);
                }
                System.out.print(">");
                System.out.println("");
            }
            else if(direction==-1)
            {
//                System.out.print("<");
//                System.out.print(listArray[top-1]);
//
//                for (int i = top - 2; i >= 0; i--) {
//                    System.out.print(" " + listArray[i]);
//                }
//                System.out.print(">");
//                System.out.println("");

                System.out.println("Calling from here");
                System.out.print("<");
                for (int i = maxSize-top; i<maxSize; i++) {
                    System.out.print(" " + listArray[i]);
                }
                System.out.print(">");
                System.out.println("");
            }
        }


        private AStack<E> memInc() {
            AStack<E> obj = new AStack<E>(maxSize + inc);
            for (int i = 0; i < this.top; i++) {
                obj.listArray[i] = (E) this.listArray[i];
            }
            obj.top = this.top;

            return obj;
        }

        private AStack<E> setDirection(int direction, AStack<E> obj) {
            this.direction = direction;
            top = 0;
//            for(int i=0; i<maxSize; i++) listArray[i]=null;
            return obj;
        }

//        public E pop() {
//            return listArray[--top];
//        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k;  //initial length
        int x;  //memory chunk

        k = scn.nextInt();
        x = scn.nextInt();
        AStack<Integer> obj1 = new AStack<>(x);

        for (int i = 0; i < k; i++) {
            int ini = scn.nextInt();
            obj1.insert_ini(ini);
        }

        obj1.print();

        int input = -1;
        int input2 = -1;

        while (input != 0 && input2 != 0) {
            input = scn.nextInt();
            if (input == 1) {
                int ignore = scn.nextInt();
                int a = obj1.clear();
//                obj1.print(obj1);
                System.out.println(a);
            } else if (input == 2) {
                if (obj1.top == obj1.maxSize) {
                    obj1 = obj1.memInc();
                }
                input2 = scn.nextInt();
                int ret;
                ret = obj1.push(input2);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 3) {
                int ignore = scn.nextInt();
                if (obj1.length() == 0) {
                    System.out.println("<>");
                    System.out.println("null");
                    continue;
                }
                int ret = obj1.pop();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 4) {
                int ignore = scn.nextInt();
                int ret = obj1.length();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 5) {
                int ignore = scn.nextInt();
                int ret = obj1.topValue();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 6) {
                input2 = scn.nextInt();
                int ret;
                obj1 = obj1.setDirection(input2, obj1);
                System.out.println("<>");
                System.out.println("-1");
            } else System.out.println("Invalid Output!");

        }
    }
}
