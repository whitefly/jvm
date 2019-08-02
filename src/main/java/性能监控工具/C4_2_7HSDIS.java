package 性能监控工具;

public class C4_2_7HSDIS {
    private int a = 1;
    private static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new C4_2_7HSDIS().sum(3);
    }
}
