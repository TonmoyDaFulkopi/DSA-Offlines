import java.util.Scanner;
//import Headers.*;

public class TNL {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int K, L, M, T;                                          ///K=rickshaw, L=bus, M=train///
        K = scn.nextInt();
        L = scn.nextInt();

        //For rickshaw
        int[] arr_r = new int[K];
        for(int i=0; i<K; i++)
        {
            arr_r[i] = i;
        }

        //For bus

        int[] arr_b = new int[K];

        for(int i=0; i<L; i++)
        {
            int input = scn.nextInt();
            arr_b[input]=1;
        }
        for (int i=0; i<K; i++) {
            if (arr_b[i] != 1) arr_b[i] = -1;
            else arr_b[i] = i;
        }
//
//        for(int i=0; i<K; i++)
//            System.out.println(arr_b[i]);

        //For train
        int[] arr_t = new int[K];

        M = scn.nextInt();

        for(int i=0; i<M; i++)
        {
            int input = scn.nextInt();
            arr_t[input]=1;
        }
        for (int i=0; i<K; i++)
            if(arr_t[i]!=1) arr_t[i] = -1;
            else arr_t[i] = i;

                                                                        //Arr implementation//


//        Arr.AList<Integer> obj_r = new Arr.AList<Integer>(K);
//        for (int i=0; i<K; i++)
//        {
//            int ini = arr_r[i];
//            obj_r.insert_ini(ini);
//        }
//
//        Arr.AList<Integer> obj_b = new Arr.AList<Integer>(K);
//        for (int i=0; i<K; i++)
//        {
//            int ini = arr_b[i];
//            obj_b.insert_ini(ini);
//        }
//
//        Arr.AList<Integer> obj_t = new Arr.AList<Integer>(K);
//        for (int i=0; i<K; i++)
//        {
//            int ini = arr_t[i];
//            obj_t.insert_ini(ini);
//        }
//
//        obj_r.print(1);
//        obj_b.print(1);
//        obj_t.print(1);
//
//        int input;
//        input = scn.nextInt();

                                                                            ///Arr Implement///




                                                                        ///LL Implement///
        LL.LList<Integer> obj_r = new LL.LList<Integer>();

        for (int i=0; i<K; i++)
        {
            int ini = arr_r[i];
            obj_r.insert(ini, i+1, obj_r);
        }

        obj_r.moveToStart(obj_r, 0);
        obj_r.print(obj_r, 1);

        System.out.println("");

        LL.LList<Integer> obj_b = new LL.LList<Integer>();

        for (int i=0; i<K; i++)
        {
            int ini = arr_b[i];
            obj_b.insert(ini, i+1, obj_b);
        }

        obj_b.moveToStart(obj_b, 0);
        obj_b.print(obj_b, 1);

        System.out.println("");
        LL.LList<Integer> obj_t = new LL.LList<Integer>();

        for (int i=0; i<K; i++)
        {
            int ini = arr_t[i];
            obj_t.insert(ini, i+1, obj_t);
        }

        obj_t.moveToStart(obj_t, 0);
        obj_t.print(obj_t, 1);

                                                                            ////LL Implement////




        System.out.println("");

    }
}
