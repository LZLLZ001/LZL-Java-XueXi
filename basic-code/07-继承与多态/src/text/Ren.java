package text;

public abstract class Ren {
    private int c0;

    public int getC0() {
        return c0;
    }

    public void setC0(int c0) {
        this.c0 = c0;
    }

    public Ren() {
    }

    public Ren(int c0) {
        this.c0 = c0;
    }

    public void funRen1(){
        System.out.println("funRen1");
    }

    public abstract void funRenA();
    public abstract void funRenB();

}
