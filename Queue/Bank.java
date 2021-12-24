import java.util.Scanner;

public class Bank {

    public static class Customer {
        public int person;
        public int time;
        public int endTime;
        public int queueName;

        Customer(int person, int time, int endTime, int queueName) {
            this.person = person;
            this.time = time;
            this.endTime = endTime;
            this.queueName = queueName;
        }
    }

    public static void main(String[] args) {
        int n;
        boolean t1Busy = false;
        boolean t2Busy = false;

        int index_1 = 0;
        int index_2 = 0;

        int runtime = 0;

        Customer serving1 = null;
        Customer serving2 = null;

        int cus_cnt = 0;

        int endTime1 = -1;
        int endTime2 = -1;

        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        int cnt = 0;

        int[] t = new int[n];
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = scn.nextInt();
            s[i] = scn.nextInt();
        }

        LL3.LQueue<Customer> queue1 = new LL3.LQueue<>(n);
        LL3.LQueue<Customer> queue2 = new LL3.LQueue<>(n);

//        Arr3.AQueue<Customer> queue1 = new Arr3.AQueue<>(n);
//        Arr3.AQueue<Customer> queue2 = new Arr3.AQueue<>(n);

        int q1Finish = 0, q2Finish = 0;


        for (runtime = 0; ; runtime++) {
            /**
             * Work Done of Customer
             */

//            if(cnt==n && t1Busy==false && t2Busy==false) break;

            if (runtime == endTime1) {
                System.out.println("Customer " + (serving1.person + 1) + " Left from queue " + serving1.queueName + " leaving at " + runtime);
                t1Busy = false;
                q1Finish = runtime;
            }
            if (runtime == endTime2) {
                System.out.println("Customer " + (serving2.person + 1) + " Left from queue " + serving2.queueName + " leaving at " + runtime);
                t2Busy = false;
                q2Finish = runtime;
            }
//            System.out.println(cus_cnt+" " + runtime +" " + endTime1 + " " + endTime2 );

            /**
             * CUSTOMER ENTERING PERIOD
             */
            if (cnt < n && runtime == t[cnt]) {
                int q1l = queue1.length();
                if(t1Busy) q1l++;
                int q2l = queue2.length();
                if(t2Busy) q2l++;

                if (q1l <= q2l) {
                    queue1.enqueue(new Customer(cnt, t[cnt], s[cnt], 1));
                } else {
                    queue2.enqueue(new Customer(cnt, t[cnt], s[cnt], 2));
                }
                cnt++;
            }


            /**
             * If theres a free teller in other queue
             */
            int q1l = queue1.length();
            if(t1Busy) q1l++;
            int q2l = queue2.length();
            if(t2Busy) q2l++;

            if (q2l != 0) {
                if (q1l - q2l >= 2) {
                    queue2.enqueue(queue1.leaveQueue());
//                        queue2.enqueue(queue1.leaveQueue(queue2));
                    System.out.println("Switching from queue 1 to 2 ");

                }
            }

            if (q1l != 0) {

                if (q2l - q1l >= 2) {
                    queue1.enqueue(queue2.leaveQueue());
//                        queue1.enqueue(queue2.dequeue(queue1));
                    System.out.println("Switching from queue 2 to 1 ");

                }
            }

            /**
             * Is Busy Enabler
             */
            if (!t1Busy && queue1.length() != 0) {
                t1Busy = true;
                serving1 = queue1.dequeue();
//                serving1 = queue1.dequeue(queue1);

                endTime1 = runtime + serving1.endTime;
            }

            if (!t2Busy && queue2.length() != 0) {
                t2Busy = true;
                serving2 = queue2.dequeue();
//                serving2 = queue2.dequeue(queue2);
                endTime2 = runtime + serving2.endTime;
            }

            if (!t1Busy && !t2Busy && queue1.length() == 0 && queue2.length() == 0 && cnt == n) {
                System.out.println("Queue 1 is finished at " + q1Finish);
                System.out.println("Queue 2 is finished at " + q2Finish);
                break;
            }
        }

    }
}
