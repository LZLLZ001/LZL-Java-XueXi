package text;

public interface Itf {
    public static final int AAA = 1;

    public abstract void fun1abs();

    public abstract void funabs();

    public default void fun1def() {
        System.out.println("fun1def");
    }

    public default void fundef() {
        System.out.println("fundef");
    }

    public static void fun1sta() {
        System.out.println("fun1sta");
    }

    public static void funsta() {
        System.out.println("funsta");
    }

    private void fun1pri() {
        System.out.println(AAA);
    }

    private void funpri() {
        System.out.println("funpri");
    }
}
