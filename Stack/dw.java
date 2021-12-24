import java.util.Scanner;

public class dw {

    public static class dish{
        public int person;
        public int time;
        public int dishName;

        dish(int person, int time, int dishName)
        {
            this.person = person;
            this.time = time;
            this.dishName = dishName;
        }
    }

    public static void main(String[] args) {
        int n, x;
        boolean isBusy = false;

        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        x = scn.nextInt();
        int[] a = new int[x];       //dish time
        for (int i=0; i<x; i++)
        {
            a[i] = scn.nextInt();
        }

        int[] k = new int[20];
        int[] t = new int[20];
        int[] s = new int[20];


        /**
         * 2 Stack 1 Array
         */
//        dish[] temp = new dish[50];
//
//        Arr2.AStack<dish> dirty = new Arr2.AStack<dish>(-1, temp);
//        Arr2.AStack<dish> clean = new Arr2.AStack<dish>(1, temp);
//        Arr2.AStack<Integer> full = new Arr2.AStack<>(28);

/**
 * Array Stack Implementation
 */
        Arr2.AStack<dish> dirty = new Arr2.AStack<>(15);
        Arr2.AStack<dish> clean = new Arr2.AStack<>(15);
        Arr2.AStack<Integer> full = new Arr2.AStack<>(10);

/**
 * Linked Stack Implementation
 */
//        LL2.LStack<dish> dirty = new LL2.LStack<>(15);
//        LL2.LStack<dish> clean = new LL2.LStack<>(15);
//        LL2.LStack<Integer> full = new LL2.LStack<>(10);

        int size = 0;
        while(true){
            k[size] = scn.nextInt();
            t[size] = scn.nextInt();
            s[size] = scn.nextInt();
            if(k[size]==0) break;

            if(s[size]==x)  full.push(k[size]);

            size++;
        }

        int clean_index = 0;
        int dirty_index = 0;

        dish washing = null;

        int endTime = -1;

        int[] output_array1 = new int[size];

        int runTime = 0;

        for(runTime=0;; runTime++)
        {
            /**
             * DIRTY ADDER
             */
            if(runTime == t[dirty_index])       //if reached to that time, add to dirty
            {
                dirty.push(new dish(k[dirty_index], t[dirty_index], s[dirty_index]));     //Push to Dirty
                dirty_index++;
            }

            /**
             *Not busy && Dirty dish available
             */
            /**
             * washing push
             */
            if(!isBusy && dirty.length()!=0)
            {
                isBusy = true;
                washing = dirty.pop();
                endTime = a[washing.dishName-1] + runTime - 1;
            }

            if(runTime == endTime)
            {
                isBusy = false;
                clean.push(washing);
                output_array1[clean_index++] = runTime;
            }

            if(!isBusy && dirty.length()==0 && dirty_index==size)
            {
                break;
            }

        }

        System.out.println(runTime);

        System.out.print(output_array1[0]);
        for(int i=1; i<size; i++)   System.out.print("," + output_array1[i]);

        System.out.println("");

        if(full.length()==n) System.out.println("Y");
        else System.out.println("N");

        System.out.print(full.pop());
        while(full.length()>0) {
            System.out.print("," + full.pop());
        }
    }
}
