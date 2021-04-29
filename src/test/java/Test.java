import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int num = 10;
        int num2 = 2;
        System.out.println(Math.pow(num, num2));
        int[] nums = {13, 7, 6, 45, 21, 9, 101, 102};
        // sort by ascending order
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        test3("hello");
    }
    
    public void testExecutor(String msg) {
        System.out.println(msg);
    }

    public void test3(String msg) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Run Task!!!!");
                testExecutor(msg);
            }
        });

    }
}
