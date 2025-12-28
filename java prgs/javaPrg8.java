class Q {
    int n;
    boolean flag = false;

    synchronized void put(int n) {
        while (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        System.out.println("PUT : " + n);
        flag = true;
        notify();
    }

    synchronized int get() {
        while (flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("GET: " + n);
        flag = false;
        notify();
        return n;
    }
}

class Producer extends Thread {
    Q q;

    Producer(Q q) {
        this.q = q;
        this.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer extends Thread {
    Q q;

    Consumer(Q q) {
        this.q = q;
        this.start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class ProdCons {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}