package hello.order.v2;

import hello.order.OrderService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV2 implements OrderService {


    private AtomicInteger stock = new AtomicInteger(100);



    @Counted(value = "my.order", description = "order")
    @Override
    public void order() {
        log.info("order");
        stock.decrementAndGet();
    }

    @Counted(value = "my.order", description = "cancel")
    @Override
    public void cancel() {
        log.info("cancel");
        stock.incrementAndGet();

    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
