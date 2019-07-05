package 垃圾回收;

public class C3_2_4逃脱GC {
    private static C3_2_4逃脱GC global;
    private String name;

    public C3_2_4逃脱GC(String name) {
        this.name = name;
    }

    private void isAlive() {
        System.out.println("yes" + "," + name + " 还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize()方法被触发,又引用在global变量上");
        global = this; //自我拯救,强行又挂在global变量上
    }

    public static void main(String[] args) throws InterruptedException {
        global = new C3_2_4逃脱GC("胡汉三");

        //企图自杀
        企图自杀();
        //再次企图自杀
        企图自杀();
    }

    private static void 企图自杀() throws InterruptedException {
        System.out.println("作死开始");
        global = null;
        System.gc();
        Thread.sleep(500);
        if (global != null) {
            global.isAlive();
        } else {
            System.out.println("本对象死透了");
        }
        System.out.println();
    }


}
