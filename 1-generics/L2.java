
class Coll<E> {
    void add(E e) {}
}


class Thing {
    private String owner;
    public Thing(String owner) {
        this.owner = owner;
    }
    public String getOwner() { return owner; }
}
class Computer extends Thing {
    private int cpus;
    public Computer(String owner, int cpus) {
        super(owner);
        this.cpus = cpus;
    }
    public int getCpus() { return cpus; }
}
class Notebook extends Computer {
    private double diag;
    public Notebook(String o, int c, double d) {
        super(o,c);
        this.diag = d;
    }
    public double getDiag() { return diag; }
}

public class L2 {
    public static int main(String[] args) {
    }
}
