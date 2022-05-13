
public class L2 {
    public static void timeSort(int[] a) {
        for (int x : a) {
            new Thread(() -> {
                    try {
                        Thread.sleep(x*300);
                    } catch (InterruptedException e) {}
                    System.out.println(x);
            }).start();
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{5,3,8,2};
        timeSort(a);
    }
}
