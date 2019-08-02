package 并发;

public class C12_3_3volatile {
    volatile int a;

    public int show() {
        int before1, before2, after1, after2;

        before1 = 1;
        before2 = 2;
        a = 1000;
        after1 = 3;
        after2 = 4;

        return before1 + before2 + a + after1 + after2;
    }

    public static void main(String[] args) {
        C12_3_3volatile s = new C12_3_3volatile();
        s.show();
    }
}
