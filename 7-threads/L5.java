import java.util.*;

class MyThread extends Thread {
    private int x;
    private List<Integer> res;
    public MyThread(int x, List<Integer> res) {
        this.x = x;
        this.res = res;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(x*300);
        } catch (InterruptedException e) {}
        res.add(x);
    }
}

public class L5 {
    public static List<Integer> timeSort(int[] a) {
        List<Integer> l = Collections.synchronizedList(new LinkedList<>());
        MyThread[] ts = new MyThread[a.length];
        for (int i=0; i<a.length; i++) {
            ts[i] = new MyThread(a[i],l);
            ts[i].start();
        }
        try {
            for (MyThread t : ts) {
                t.join();
            }
        } catch (InterruptedException e) {}
        return l;
    }
    public static void main(String[] args) {
        int[] a = new int[10000];
        Random r = new Random();
        for (int i=0; i<10000; i++) {
            a[i] = r.nextInt(10) + 1;
        }
        List<Integer> l = timeSort(a);
        System.out.println(l.get(0) + " " + l.get(1));
        System.out.println(l.size());
    }
}
