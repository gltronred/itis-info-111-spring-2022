
class MyThread extends Thread {
    private int x;
    public MyThread(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(x*1000);
        } catch (InterruptedException e) {}
        System.out.println(x);
    }
}

public class L1 {
    public static void timeSort(int[] a) {
        for (int x : a) {
            MyThread t = new MyThread(x);
            t.start();
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{5,3,8,2};
        timeSort(a);
    }
}
