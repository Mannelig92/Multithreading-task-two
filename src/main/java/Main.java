import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<Integer> callable1 = new MyCallable("Поток №1");
        Callable<Integer> callable2 = new MyCallable("Поток №2");
        Callable<Integer> callable3 = new MyCallable("Поток №3");
        Callable<Integer> callable4 = new MyCallable("Поток №4");

        List<Callable<Integer>> task = new ArrayList<>();
        Collections.addAll(task, callable1, callable2, callable3, callable4);

        List<Future<Integer>> results = threadPool.invokeAll(task);
        for (Future<Integer> result : results) {
            System.out.println("Количество итераций: " + result.get());
        }
        threadPool.shutdown();
    }

}