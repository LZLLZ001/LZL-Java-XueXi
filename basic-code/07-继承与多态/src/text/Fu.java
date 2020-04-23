package text;


public class Fu extends XinRen {
    private int c1;
    private int c2;

    public Fu() {
    }

    public Fu(int c1, int c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public void funFu1() {
        System.out.println("funFu1");
    }


    public void fun1() {
        System.out.println("fun1-Fu");
    }

    @Override
    public void funRenB() {
        System.out.println("重写funRenB");
    }
}
