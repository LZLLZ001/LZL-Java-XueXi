package text;

public interface Itf2 {
    public static final int BBB = 2;

    public abstract void fun2abs();

    public abstract void funabs();

    public default void fun2def() {
        System.out.println("fun2def");
    }

    public default void fundef() {
        System.out.println("fundef");
    }

    public static void fun2sta() {
        System.out.println("fun2sta");
    }

    public static void funsta() {
        System.out.println("funsta");
    }

    private void fun2pri() {
        System.out.println("fun2pri");
    }

    private void funpri() {
        System.out.println("funpri");
    }
}
