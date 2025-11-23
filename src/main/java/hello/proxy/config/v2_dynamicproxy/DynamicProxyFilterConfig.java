package hello.proxy.config.v2_dynamicproxy;

import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {
    private static final String[] PATTERNS = {"request*", "orders*", "save*"};


    @Bean
    public OrderControllerV1 OrderControllerV1(LogTrace logTrace){
        OrderControllerV1Impl target = new OrderControllerV1Impl(OrderServiceV1(logTrace));
        OrderControllerV1 proxy = (OrderControllerV1)Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(),
                new Class[]{OrderControllerV1.class},
                new LogTraceFilterHandler(target, logTrace, PATTERNS));
        return proxy;
    }

    @Bean
    public OrderServiceV1 OrderServiceV1(LogTrace logTrace){
        OrderServiceV1impl target = new OrderServiceV1impl(orderRepositoryV1(logTrace));
        OrderServiceV1 proxy = (OrderServiceV1)Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(),
                new Class[]{OrderServiceV1.class},
                new LogTraceFilterHandler(target, logTrace, PATTERNS));

        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1Impl target = new OrderRepositoryV1Impl();
        OrderRepositoryV1 proxy = (OrderRepositoryV1)Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(),
                new Class[]{OrderRepositoryV1.class},
                new LogTraceFilterHandler(target, logTrace,PATTERNS));

        return proxy;
    }

}
