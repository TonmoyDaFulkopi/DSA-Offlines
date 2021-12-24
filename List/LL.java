import java.util.Scanner;


public class LL {
    /**
     * List ADT
     */
    public interface List<E> {
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
        public int insert(E item, int x, LList<E> obj);

        /**
         * Append an element at the end of the list. The client
         * must ensure that the list’s capacity is not exceeded.
         *
         * @param item The element to be appended.
         */
        public int append(E item, LList<E> obj);

        /**
         * Remove and return the current element.
         *
         * @return The element that was removed.
         */
        public E remove(LList<E> obj);

        /**
         * Set the current position to the start of the list
         */
        public int moveToStart(LList<E> obj, int x);

        /**
         * Set the current position to the end of the list
         */
        public int moveToEnd(LList<E> obj);

        /**
         * Move the current position one step left. No change
         * if already at beginning.
         */
        public int prev(LList<E> obj);

        /**
         * Move the current position one step right. No change
         * if already at end.
         */
        public int next(LList<E> obj);

        /**
         * @return The number of elements in the list.
         */
        public int length(LList<E> obj);

        /**
         * @return The position of the current element.
         */
        public int currPos(LList<E> obj);

        /**
         * Set current position.
         *
         * @param pos The position to make current.
         */
        public int moveToPos(int pos, LList<E> obj);

        /**
         * @return The current element.
         */
        public E getValue(LList<E> obj);
    }

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


    /**
     * Linked list implementation
     */
    public static class LList<E> implements List<E> {
        private Link<E> head; // Pointer to list header
        private Link<E> tail; // Pointer to last element
        protected Link<E> curr; // Access to current element
        private int cnt; // Size of list

        /**
         * Constructors
         */
        LList(int size) {
            this();
        } // Constructor -- Ignore size

        public LList() {
            curr = tail = head = new Link<E>(null); // Create header
            cnt = 0;
        }

        /**
         * Remove all elements
         */
        public int clear() {
            head.setNext(null); // Drop access to links
            curr = tail = head = new Link<E>(null); // Create header
            cnt = 0;
            System.out.println("<>");
            return -1;
        }

        /**
         * Insert "it" at current position
         */
        public int insert(E it, int x, LList<E> obj) {
            if(x>1)
            {
                curr = curr.next;
                curr.setNext(new Link<E>(it, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
            }
            else if(x==1){
                curr.setNext(new Link<E>(it, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
            }

            else if(x==0){                              //THE NORMAL ONE
                curr.setNext(new Link<E>(it, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
//                print(obj);
            }
            return -1;
        }

        /**
         * Append "it" to list
         */
        public int append(E it, LList<E> obj) {
            tail = tail.setNext(new Link<E>(it, null));
            if (curr == tail)
            {
                curr = obj.prev(obj, 1);
            }
            cnt++;
//            print(obj);
            return -1;
        }

        /**
         * Remove and return current element
         */
        public E remove(LList<E> obj) {
            if (curr.next() == null) return null; // Nothing to remove
            E it = curr.next().element(); // Remember value
            if (tail == curr.next()) tail = curr; // Removed last
            curr.setNext(curr.next().next()); // Remove from list
            cnt--; // Decrement count
//            print(obj);
            return it; // Return value
        }

        /**
         * Set curr at list start
         */
        public int moveToStart(LList<E> obj, int x) {
            if(x==0) {
                curr = head;
            }
            else if(x==1)
            {
                curr = head;
//                print(obj);
            }
            return -1;
        }

        /**
         * Set curr at list end
         */
        public int moveToEnd(LList<E> obj) {
            Link<E> temp = head;
            for (int i=0; i<cnt; i++)
            {
                if(temp.next==obj.tail) break;
                temp = temp.next;
            }
            curr = temp;
//            print(obj);
            return -1;
        }

        /**
         * Move curr one step left; no change if now at front
         */
        public int prev(LList<E> obj) {
            if (curr == head) {
//                print(obj);
                return -1; // No previous element
            }
            Link<E> temp = head;
// March down list until we find the previous element
            while (temp.next() != curr) temp = temp.next();
            curr = temp;
//            print(obj);
            return -1;
        }

        private Link<E> prev(LList<E> obj, int x) {     //For Append trouble
            Link<E> temp = head;
// March down list until we find the previous element
            while (temp.next() != curr) temp = temp.next();
            curr = temp;
            return curr;
        }

        /**
         * Move curr one step right; no change if now at end
         */
        public int next(LList<E> obj) {
//            Link<E> temp = obj.head;
//            temp = temp.next();
//// March down list until we find the previous element
//            while (temp.next() != curr && temp!=null) temp = temp.next();
//            if(temp.next() == tail) return -1;

            if (curr.next != tail && curr!=tail)
            {
                curr = curr.next();
            }
//            print(obj);
            return -1;
        }

        /**
         * @return List length
         */
        public int length(LList<E> obj) {
//            print(obj);
            return cnt;
        }

        /**
         * @return The position of the current element
         */
        public int currPos(LList<E> obj) {
            Link<E> temp = head;
            int i;
            for (i = 0; curr != temp; i++)
                temp = temp.next();
//            print(obj);
            return i;
        }

        /**
         * Move down list to "pos" position
         */
        public int moveToPos(int pos, LList<E> obj) {
            assert (pos >= 0) && (pos <= cnt) : "Position out of range";
            curr = head;
            for (int i = 0; i < pos; i++) curr = curr.next();
//            print(obj);
            return -1;
        }

        /**
         * @return Current element value
         */
        public E getValue(LList<E> obj) {
            if (curr.next() == null)
            {
//                print(obj);
                return null;
            }
//            print(obj);
            return curr.next().element();
        }

        //////UPDATE//////

        public int update(E input, LList<E> obj) {
            if (curr.next() == null)
            {
//                print(obj);
                return -1;
            }
//            print(obj);
//            curr.next().element() = input;
            curr.next.setElement(input);
            return -1;
        }

        public int duplicate(int x, LList<E> obj) {
            E dup = curr.next.element;
            if(x>1)
            {
                curr = curr.next;
                curr.setNext(new Link<E>(dup, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
            }
            else if(x==1){
                curr.setNext(new Link<E>(dup, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
            }

            else if(x==0){                              //THE NORMAL ONE
                curr.setNext(new Link<E>(dup, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
//                print(obj);
            }
            return -1;
        }

        public void print(LList<E> obj) {
            Link<E> temp = obj.head.next;   //After the blank Node

            System.out.print("<");
//            if(obj.curr == obj.head) System.out.print("| ");    ////If the is in the blank head
            for (int i = 0; i < cnt; i++) {
                if(obj.curr == null || obj.curr.next == null) {
                    if ((curr == tail) && (temp == tail)) System.out.print("| ");
                }
                else{
                    if (temp == obj.curr.next() || ((curr == tail) && (temp == tail))) System.out.print("| ");
                }
                System.out.print(temp.element + " ");
                temp = temp.next();
            }
            System.out.print(">");
            System.out.println("");
        }

        public void print(LList<E> obj, int x) {
            Link<E> temp = obj.head.next;   //After the blank Node


            if((int)temp.element == -1){                                 ///////EXPLICITLY TYPECASTED
                System.out.print("");
                temp = temp.next();
            }
            else {
                System.out.print(temp.element);
                temp = temp.next();
            }

//            if(obj.curr == obj.head) System.out.print("| ");    ////If the is in the blank head
            for (int i = 0; i < cnt-1; i++) {
//                if (temp == obj.curr.next || ((curr == tail) && (temp==tail))) System.out.print("| ");
                if((int)temp.element == -1){                                 ///////EXPLICITLY TYPECASTED
                    System.out.print(",");
                    temp = temp.next();
                }
                else {
                    System.out.print("," + temp.element);
                    temp = temp.next();
                }
            }
        }

        public int Search(int x, LList<E> obj)
        {
            Link<E> temp = obj.head.next;   //After the blank Node
            for (int i=0; i<cnt; i++)
            {
                if((Integer) temp.element==x) return 1;
                temp = temp.next();
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
        LList<Integer> obj1 = new LList<Integer>();

        for(int i=0; i<k; i++)
        {
            int ini = scn.nextInt();
            obj1.insert(ini, i+1, obj1);
        }

        obj1.moveToStart(obj1, 0);
        obj1.print(obj1);

        while (true) {
            int input = scn.nextInt();
            if (input == 1) {
                int ignore = scn.nextInt();
                System.out.println(obj1.clear());
            } else if (input == 2) {
                int input2 = scn.nextInt();
                int ret = obj1.insert(input2,0, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 3) {
                int input2 = scn.nextInt();
                int ret = obj1.append(input2, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 4) {
                int ignore = scn.nextInt();
                int ret = obj1.remove(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 5) {
                int ignore = scn.nextInt();
                int ret = obj1.moveToStart(obj1, 1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 6) {
                int ignore = scn.nextInt();
                int ret = obj1.moveToEnd(obj1);
                System.out.println(ret);
            } else if (input == 7) {
                int ignore = scn.nextInt();
                int ret = obj1.prev(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 8) {
                int ignore = scn.nextInt();
                int ret = obj1.next(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 9) {
                int ignore = scn.nextInt();
                int ret = obj1.length(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 10) {
                int ignore = scn.nextInt();
                int ret = obj1.currPos(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 11) {
                int input2 = scn.nextInt();
                int ret = obj1.moveToPos(input2, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 12) {
                int ignore = scn.nextInt();
                int ret = obj1.getValue(obj1);
                obj1.print(obj1);
                System.out.println(ret);
            } else if (input == 13) {
                int input2 = scn.nextInt();
                int ret = obj1.Search(input2, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input == 14)
            {
                int input2 = scn.nextInt();
                int ret = obj1.update(input2, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else if(input == 15)
            {
                int input2 = scn.nextInt();
                int ret = obj1.duplicate(0, obj1);
                obj1.print(obj1);
                System.out.println(ret);
            }
            else System.out.println("Invalid Input!");
        }
    }
}
