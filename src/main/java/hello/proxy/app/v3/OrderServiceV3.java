package hello.proxy.app.v3;

import org.springframework.stereotype.Repository;

@Repository
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3(OrderRepositoryV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
