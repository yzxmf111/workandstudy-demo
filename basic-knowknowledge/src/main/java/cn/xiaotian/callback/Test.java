package cn.xiaotian.callback;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaotian
 * @description
 * @date 2022-12-01 09:56
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
        //
        //ExecutorService executorService = ExecutorServiceUtil.newExecutorService();
        //Future<String> future = executorService.submit(() -> {
        //    Thread.sleep(2000);
        //    return "hello world";
        //});
        //while (true) {
        //    if (future.isDone()) {
        //        System.out.println(future.get());
        //
        //        break;
        //    }
        //}
        //
        //
        //CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        //    try {
        //        Thread.sleep(10000L);
        //        return "hello world";
        //    } catch (Exception e) {
        //        return "failed";
        //    }
        //});
        //System.out.println(future2.join());
        Float a =null;
        Float b  = a * 1;
        System.out.println(b);
    }
}
