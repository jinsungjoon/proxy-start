package hello.proxy.pureproxy.concretproxy;

import hello.proxy.pureproxy.concretproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concretproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concretproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void proxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
