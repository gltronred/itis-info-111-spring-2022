
class Coll<E> {
    void add(E e) {}
    void addAll(Coll<? extends E> otherColl) {}
    void removeIf(Pred<? super E> predicate) {}
}

interface Pred<E> {
    boolean test(E e);
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


class MyThings implements Pred<Thing> {
    public boolean test(Thing t) {
        return t.getOwner().equals("Me");
    }
}
class LargePC implements Pred<Computer> {
    public boolean test(Computer c) {
        return c.getCpus() > 3;
    }
}
class SmallNotebooks implements Pred<Notebook> {
    public boolean test(Notebook n) {
        return n.getDiag() < 14;
    }
}


public class L2 {
    public static void main(String[] args) {
        Coll<Computer> computers = new Coll<>();
        computers.add(new Computer("Me",4));
        //computers.add(new Thing("Me"));
        computers.add(new Notebook("Me",4,13.1));

        Coll<Notebook> notebooks = new Coll<>();
        computers.addAll(notebooks);
        //Coll<Thing> things = new Coll<>();
        //computers.addAll(things);

        computers.removeIf(new LargePC());
        computers.removeIf(new MyThings());
        //computers.removeIf(new SmallNotebooks());
    }
}
