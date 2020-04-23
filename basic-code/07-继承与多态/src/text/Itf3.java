package text;

public interface Itf3 extends Itf,Itf2{
    default void fundef(){
        System.out.println("3重写fundef");
    }

    @Override
    default void fun1def() {

        System.out.println("3重写fun1def");
    }
}
