package src.main.lib;

import java.util.concurrent.ThreadLocalRandom;

final class Worker extends Thread {
    final Population population;
    //
    final int maxExchanges;
    int exchanges;
    ThreadLocalRandom rng = ThreadLocalRandom.current();
    /*
     * Example use case:
     *  int randomInt = random.nextInt(100);
     *  double randomDouble = random.nextDouble();
     *  int randomInRange = random.nextInt(5, 11);
     */
    Worker(Population population, int maxExchanges) {
        this.population = population;
        this.maxExchanges = maxExchanges;
    }
    public void run() {
        try {
            int le = population.subpops.length;
        }
    }
}

