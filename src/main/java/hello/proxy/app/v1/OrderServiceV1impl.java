package hello.proxy.app.v1;

public class OrderServiceV1impl implements OrderServiceV1{
    private final OrderRepositoryV1 orderRepository;

    public OrderServiceV1impl(OrderRepositoryV1 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
