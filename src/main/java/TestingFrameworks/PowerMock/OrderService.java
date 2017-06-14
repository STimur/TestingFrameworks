package TestingFrameworks.PowerMock;

/**
 * Created by Timur on 14-Jun-17.
 */
public class OrderService {
    private OrderRepository orderRepository;

    public int getCostById(int id) {
        return orderRepository.getOrderById(id).getPrice();
    }
}
