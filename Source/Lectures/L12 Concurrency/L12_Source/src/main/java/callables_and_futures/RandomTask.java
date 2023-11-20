package callables_and_futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return ThreadLocalRandom.current().nextInt(1,100+1);
    }
}
