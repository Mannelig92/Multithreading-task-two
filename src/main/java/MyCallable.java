import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    String nameOfThread;
    int count;

    public MyCallable(String nameOfThread) {
        this.nameOfThread = nameOfThread;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < new Random().nextInt(); i++) {
            count++;
            System.out.printf("Я %s. Всем привет!\n", nameOfThread);
        }
        return count;
    }
}
