import java.util.Scanner;

public class Arr {

    /**
     * List ADT
     */
    interface List<E> {
        /**
         * Remove all contents from the list, so it is once again
         * empty. Client is responsible for reclaiming storage
         * used by the list elements.
         */
        public int clear();

        /**
         * Insert an element at the current location. The client
         * must ensure that the list’s capacity is not exceeded.
         *
         * @param item The element to be inserted.
         */
        public int insert(E item);

        /**
         * Append an element at the end of the list. The client
         * must ensure that the list’s capacity is not exceeded.
         *
         * @param item The element to be appended.
         */
        public int append(E item);

        /**
         * Remove and return the current element.
         *
         * @return The element that was removed.
         */
        public E remove();

        /**
         * Set the current position to the start of the list
         */
        public int moveToStart();

        /**
         * Set the current position to the end of the list
         */
        public int moveToEnd();

        /**
         * Move the current position one step left. No change
         * if already at beginning.
         */
        public int prev();

        /**
         * Move the current position one step right. No change
         * if already at end.
         */
        public int next();

        /**
         * @return The number of elements in the list.
         */
        public int length();

        /**
         * @return The position of the current element.
         */
        public int currPos();

        /**
         * Set current position.
         *
         * @param pos The position to make current.
         */
        public int moveToPos(int pos);

        /**
         * @return The current element.
         */
        public E getValue();
    }

    /**
     * Array-based list implementation
     */
    public static class AList<E> implements List<E> {
        private static final int defaultSize = 10; // Default size
        public int maxSize; // Maximum size of list
        public int listSize; // Current # of list items
        private int curr; // Position of current element
        public E[] listArray; // Array holding list elements
        private int inc;    //memory allotment increase

        public void print(AList<E> obj) {
            System.out.print("<");
            for (int i = 0; i < listSize; i++) {
                if (curr == i) System.out.print("| ");
                System.out.print(listArray[i] + " ");
            }
            System.out.print(">");
            System.out.println("");
        }

        public void print() {
            System.out.print("<");
            for (int i = 0; i < listSize; i++) {
                if (curr == i) System.out.print("| ");
                System.out.print(listArray[i] + " ");
            }
            System.out.print(">");
            System.out.println("");
        }

        public void print(int x) {
            if((int)listArray[0] == -1) System.out.print("");
            else System.out.print(listArray[0]);
            for (int i = 1; i < listSize; i++) {
//                if (curr == i) ;
                if ((int)listArray[i] == -1)
                {
                    System.out.print(",");
                }
                else System.out.print("," + listArray[i]);
            }

            System.out.println("");
        }

        public void print(int x, int y) {
            if((int)listArray[0] == -1) System.out.print("");
            else System.out.print(listArray[0]);
            for (int i = 1; i < listSize; i++) {
//                if (curr == i) ;
                if ((int)listArray[i] == -1)
                {
                    System.out.print(",");
                }
                else System.out.print("," + listArray[i]);
            }

            System.out.println("");
        }
/** Constructors */
        /**
         * Create a list with the default capacity.
         */
        AList() {
            this(defaultSize);
        }

        /**
         * Create a new list object.
         *
         * @param size Max # of elements list can contain.
         */
        @SuppressWarnings("unchecked")
        public
        // Generic array allocation
        AList(int size) {
            maxSize = size;
            inc = size;
            listSize = curr = 0;
            listArray = (E[]) new Object[size]; // Create listArray
        }

        public int clear() // Reinitialize the list
        {
            listSize = curr = 0;
            listArray[curr] = null;
//            print(this);
            return -1;
        } // Simply reinitialize values

        private AList<E> memInc()
        {
            AList<E> obj = new AList<E>(maxSize+inc);
            for(int i=0; i<this.listSize; i++)
            {
                obj.listArray[i] = (E) this.listArray[i];
            }
            obj.listSize = this.listSize;

            return obj;
        }

        /**
         * Insert "it" at current position
         */
        public int insert(E it) {
            for (int i = listSize; i > curr; i--) // Shift elements up
                listArray[i] = listArray[i - 1]; // to make room
            listArray[curr] = it;
            listSize++; // Increment list size
//            print(this);
            return -1;
        }

        public int update(E it) {
//            for (int i = listSize; i > curr; i--) // Shift elements up
//                listArray[i] = listArray[i - 1]; // to make room
            listArray[curr] = it;
//            listSize++; // Increment list size
//            print(this);
            return -1;
        }
        public int duplicate() {
            for (int i = listSize; i > curr; i--) // Shift elements up
                listArray[i] = listArray[i - 1]; // to make room
            listArray[curr] = listArray[curr+1];
            listSize++; // Increment list size
//            print(this);
            return -1;
        }

        public  E insert_ini(E it) {
            assert listSize < maxSize : "List capacity exceeded";
            listArray[listSize++] = it;

            return (E) this;
        }

        /**
         * Append "it" to list
         */
        public int append(E it) {
            if(listSize>=maxSize)
            {
                System.out.println("Size exceeded!!!!");
                return -2;
            }
            listArray[listSize++] = it;
//            print(this);
            return -1;
        }

        /**
         * Remove and return the current element
         */
        public E remove() {
            if ((curr < 0) || (curr >= listSize)) // No current element
                return null;
            E it = listArray[curr]; // Copy the element
            for (int i = curr; i < listSize - 1; i++) // Shift them down
                listArray[i] = listArray[i + 1];
            listSize--; // Decrement size
//            print(this);
            return it;
        }

        public int moveToStart() {
            curr = 0;
//            print(this);
            return -1;
        } // Set to front

        public int moveToEnd() {
            curr = listSize - 1;
//            print(this);
            return -1;
        } // Set at end

        public int prev() {
            if (curr != 0) curr--;
//            print(this);
            return -1;
        } // Back up

        public int next() {
            if (curr < listSize) curr++;
//            print(this);
            return -1;
        }

        /**
         * @return List size
         */
        public int length() {
//            print(this);
            return listSize;
        }

        /**
         * @return Current position
         */
        public int currPos() {
//            print(this);
            return curr;
        }

        /**
         * Set current list position to "pos"
         */
        public int moveToPos(int pos) {
            assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
            curr = pos;
//            print(this);
            return -1;
        }

        /**
         * @return Current element
         */
        public E getValue() {
            assert (curr >= 0) && (curr < listSize) : "No current element";
//            print(this);
            return listArray[curr];
        }
        public int Search(E it)
        {
            for(int i=0; i<listSize; i++)
            {
                if(it==listArray[i])
                {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k;  //initial length
        int x;  //memory chunk

        k = scn.nextInt();
        x = scn.nextInt();
        AList<Integer> obj1 = new AList<Integer>(x);

        for(int i=0; i<k; i++)
        {
            int ini = scn.nextInt();
            obj1.insert_ini(ini);
        }

        obj1.print();

        while (true) {
            int input = scn.nextInt();
            if (input == 1) {
                int ignore = scn.nextInt();
                int a = obj1.clear();
                obj1.print(obj1);
                System.out.println(a);
            } else if (input == 2) {
                if(obj1.listSize==obj1.maxSize)
                {
                    obj1 = obj1.memInc();
                }
                int input2 = scn.nextInt();
                int ret;
                ret = obj1.insert(input2);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 3) {
                if(obj1.listSize==obj1.maxSize)
                {
                    obj1 = obj1.memInc();
                }
                int input2 = scn.nextInt();
                int ret = obj1.append(input2);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 4) {
                int ignore = scn.nextInt();
                int ret = obj1.remove();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 5) {
                int ignore = scn.nextInt();
                int ret = obj1.moveToStart();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 6) {
                int ignore = scn.nextInt();
                int ret = obj1.moveToEnd();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 7) {
                int ignore = scn.nextInt();
                int ret = obj1.prev();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 8) {
                int ignore = scn.nextInt();
                int ret = obj1.next();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 9) {
                int ignore = scn.nextInt();
                int ret = obj1.length();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 10) {
                int ignore = scn.nextInt();
                int ret = obj1.currPos();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 11) {
                int input2 = scn.nextInt();
                int ret = obj1.moveToPos(input2);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 12) {
                int ignore = scn.nextInt();
                int ret = obj1.getValue();
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 13) {
                int input2 = scn.nextInt();
                int ret = obj1.Search(input2);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input == 14)
            {
                int input2 = scn.nextInt();
                int ret;
                ret = obj1.update(input2);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input == 15)
            {
                int ignore = scn.nextInt();
                int ret = obj1.duplicate();
                obj1.print(obj1);
                System.out.println(ret);
            }
            else System.out.println("Invalid Input!");
        }
    }
}