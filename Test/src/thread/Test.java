package thread;
public class Test {

    protected long l = -1l;
    protected static int count = 0;
    public static void main(String[] args) {
        System.out.println(toBinary(-1l));
        System.out.println(toBinary(1l));
        Test t = new Test();
        Worker w1 = new Worker(t);
        Worker2 w2 = new Worker2(t);
        w1.setDaemon(true);
        w2.setDaemon(true);
        w1.start();
        w2.start();
        while (true) {
            count++;
            if (t.l != -1l && t.l != 1l) {
                System.out.println(toBinary(t.l));
                System.out.println("l的写不是原子操作");
                break;
            }
            System.out.println(count);
        }
    }

    private static String toBinary(long l) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(l));
        while (sb.length() < 64) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}

class Worker extends Thread {

    public Worker(Test t) {
        this.t = t;
    }

    private Test t;

    public void run() {
        while (true) {
            t.l = -1l;
        }
    }
}

class Worker2 extends Thread {

    public Worker2(Test t) {
        this.t = t;
    }

    private Test t;

    public void run() {
        while (true) {
            t.l = 1l;
        }
    }

    }