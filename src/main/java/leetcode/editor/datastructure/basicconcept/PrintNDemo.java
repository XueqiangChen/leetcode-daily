package leetcode.editor.datastructure.basicconcept;

public class PrintNDemo {

    public void printNByLoop(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public void printNByRecursive(int n) {
        if (n != 0) {
            printNByRecursive(n -1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        PrintNDemo demo = new PrintNDemo();

        long startTime = System.currentTimeMillis();
        System.out.println("---- print n by loop ----");
        demo.printNByLoop(n);
        long spendTime = System.currentTimeMillis() - startTime;
        System.out.println(spendTime/1000 + "s");

        // ----- StackOverflowError error ----
        // 递归对空间的占用很大，把能用的空间全部吃掉了，所以如果在空间不够的情况下，千万不要用递归
        long startTime2 = System.currentTimeMillis();
        System.out.println("---- print n by recursive ----");
        demo.printNByRecursive(n);
        System.out.println((System.currentTimeMillis() - startTime2) /1000 + "s");
    }
}
