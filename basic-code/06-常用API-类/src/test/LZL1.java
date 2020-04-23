package test;

import java.util.Objects;

public class LZL1 {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LZL1 lzl1 = (LZL1) o;
        return id == lzl1.id &&
                name.equals(lzl1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "LZL1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LZL1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static int yy = 1;

    public LZL1() {
    }

    static {
        System.out.println(yy);
        yy = 2;
        System.out.println(yy);
    }

    public LZL1(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getYy() {
        return yy;
    }

    public static void setYy(int yy) {
        LZL1.yy = yy;
    }

    public static void fun1() {
        System.out.println(yy);
    }


    public int add(int a, int b) {
        return a + b;
    }
}
