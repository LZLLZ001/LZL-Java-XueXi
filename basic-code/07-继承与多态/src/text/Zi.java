package text;

public class Zi extends Fu {
    private int c3;
    private int c2;

    public Zi(int c3, int c2) {
        this.c3 = c3;
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    @Override
    public int getC2() {
        return c2;
    }

    @Override
    public void setC2(int c2) {
        this.c2 = c2;
    }

    public Zi(int c1, int c2, int c3, int c21) {
        super(c1, c2);
        this.c3 = c3;
        this.c2 = c21;
    }

    public Zi() {
    }

    public void funZi1() {
        System.out.println("funZi1");
    }

    @Override
    public void fun1() {
        super.fun1();
        System.out.println("fun1-Zi");
        funZi2();
    }

    public void funZi2() {
        System.out.println(c2);
        System.out.println(this.c2);
        System.out.println(getC2());
        System.out.println(getC1());
        System.out.println(super.getC2());
    }
}
