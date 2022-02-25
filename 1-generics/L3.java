
//////////////////////////////////////////////////
// Выложите решение (интерфейсы, классы и т.п.)
// в папку tasks/1

//////////////////////////////////////////////////
// Интерфейс Func<T,R>, представляющий собой
// вычисление, принимающее значение типа
// T и возвращающее значение типа R
//
// Метод
// R apply(T t),
// запускающий вычисление функции
//
// Метод
// Func<T,T> identity(),
// возвращающий функцию, которая ничего
// не делает и возвращает переданный ей
// аргумент
//
// Метод
// Func<V,R> compose(??? before),
// принимает функцию before для выполнения до
// текущей (которая принимает V и
// возвращает T) и возвращает её композицию
// с текущей
//
// Метод
// Func<T,V> andThen(??? after),
// принимает функцию after для выполнения
// после текущей (которая принимает R и
// возвращает V) и возвращает композицию
// текущей функции с after
interface Func<T,R> {
        R apply(T t);
        Func<T,T> identity();
        <V> Func<V,R> compose(Func<? super V,? extends T> before);
        <V> Func<T,V> andThen(Func<? super R,? extends V> after);
}

// Напишите абстрактный класс DefaultFunc<T,R>,
// в котором будут реализации методов
// identity, compose и andThen

abstract class DefaultFunc<T,R> implements Func<T,R> {
        public abstract R apply(T t);
        public Func<T,T> identity() {
                return new IdentityFunc<T>();
        }
        public <V> Func<V,R> compose(Func<? super V,? extends T> before){
                return new ComposeFunc<>(before, this);
        }
        public <V> Func<T,V> andThen(Func<? super R,? extends V> after){
                return new ComposeFunc<>(this, after);
        }
}

class IdentityFunc<T> extends DefaultFunc<T,T> {
        public T apply(T t) { return t; }
}

class ComposeFunc<V,T,R> extends DefaultFunc<V,R> {
        private Func<? super V,? extends T> before;
        private Func<? super T,? extends R> after;
        public ComposeFunc(Func<? super V,? extends T> before, Func<? super T,? extends R> after) {
                this.before = before;
                this.after = after;
        }
        public R apply(V v) {
                T t = before.apply(v);
                return after.apply(t);
        }
}

// Реализации для Func<Integer,Integer>:
// - Mult, которая умножает входное число на
//   заданное в конструкторе
// - Sub, которая вычитает из входного числа
//   заданное в конструкторе
// - Div, которая делит входное число на
//   заданное в конструкторе

class Mult extends DefaultFunc<Integer,Integer> {
        private int k;
        public Mult(int k) { this.k = k; }
        public Integer apply(Integer x) { return k*x; }
}

class Sub extends DefaultFunc<Integer,Integer> {
        private int k;
        public Sub(int k) { this.k = k; }
        public Integer apply(Integer x) { return x-k; }
}

class Div extends DefaultFunc<Integer,Integer> {
        private int k;
        public Div(int k) { this.k = k; }
        public Integer apply(Integer x) { return x/k; }
}

class Str extends DefaultFunc<Double, String> {
        public String apply(Double x) { return x.toString(); }
}

class Len extends DefaultFunc<String, Integer> {
        public Integer apply(String s) { return s.length(); }
}

//////////////////////////////////////////////////
// Класс Option, в котором хранится либо
// "пустое" значение, либо значение типа T
//
// Статический метод
// Option<T> empty()
// возвращает "пустое" значение
//
// Методы
// boolean isPresent()
// boolean isEmpty()
//
// Метод
// T orElse(T other),
// который возвращает значение, если оно
// есть, или other, если значение "пустое"
//
// Метод
// Option<U> map(Func<? super T,? extends U> mapper),
// который принимает Func mapper, и
// применяет его к значению, если оно не
// пустое (или возвращает пустое значение,
// если хранится пустое значение)
class Option<T> {
        private T contents;
        public static <U> Option<U> empty() {
                return new Option<>(null);
        }
        public Option(T t) {
                this.contents = t;
        }
        public boolean isPresent() { return contents != null; }
        public boolean isEmpty() { return contents == null; }
        public T orElse(T other) {
                if (isEmpty()) {
                        return other;
                } else {
                        return contents;
                }
        }
        public <U> Option<U> map(Func<? super T,? extends U> mapper) {
                if (isEmpty()) {
                        return empty();
                } else {
                        return new Option<>(mapper.apply(contents));
                }
        }
}

public class L3 {
    public static void main(String[] args) {
        Func<Integer,Integer> m3 = new Mult(3);
        Func<Integer,Integer> d2 = new Div(2);
        Func<Integer,Integer> s1 = new Sub(1);

        System.out.println(m3.apply(4)); // 12
        System.out.println(d2.apply(6)); // 3
        System.out.println(s1.apply(8)); // 7

        System.out.println(m3.compose(d2).apply(2)); // 3
        System.out.println(m3.andThen(s1).apply(3)); // 8

        System.out.println(new Str().andThen(new Len()).andThen(s1).apply(3.01)); // 3
        System.out.println(s1.compose(new Len()).compose(new Str()).apply(3.2)); // 2

        Option<Double> o1 = Option.empty();
        Option<Double> o2 = new Option<>(3.0);

        System.out.println(o1.isPresent());
        System.out.println(o1.isEmpty());

        System.out.println(o1.orElse(9000.0));
        System.out.println(o2.orElse(9000.0));

        System.out.println(o1.map(new Str()).orElse("no value"));
        System.out.println(o2.map(new Str()).orElse("no value"));
    }
}
