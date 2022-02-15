
class NegativeExponentException
    extends Exception {
}

public class L1 {
    public static int pow(int a, int n)
        throws NegativeExponentException {

        if (n<0) {
            throw new NegativeExponentException();
        }

        int p=1;
        for (int i=0; i<n; i++) {
            p*=a;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int i=0;
        while (i<count) {
            try {
                int a = sc.nextInt();
                int n = sc.nextInt();
                System.out.println(pow(a,n));
                i++;
            } catch (NegativeExponentException e) {
                System.out.println("Try again");
                System.out.println(e);
            }
        }
    }
}
