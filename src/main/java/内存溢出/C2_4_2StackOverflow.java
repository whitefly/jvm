package 内存溢出;

public class C2_4_2StackOverflow {
    private int count = 0;

    public void show() {
        count++;
        show();

    }

    public static void main(String[] args) {
        C2_4_2StackOverflow s = new C2_4_2StackOverflow();
        try {
            s.show();
        } catch (StackOverflowError e) {
            System.out.println("栈溢出时的深度:" + s.count);
            throw e;

        }
    }
}

