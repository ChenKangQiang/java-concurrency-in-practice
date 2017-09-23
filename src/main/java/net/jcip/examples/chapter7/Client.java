package net.jcip.examples.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author chenkangqiang
 * @Data 2017/9/23
 */
public class Client {

    public static void main(String[] args) {
        BlockingDeque<BigInteger> primes = new LinkedBlockingDeque<>();
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            while (true) {
                primes.take();
            }
        } catch (InterruptedException ex) {

        } finally {
            producer.cancel();
        }

    }

}
