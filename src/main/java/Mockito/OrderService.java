package Mockito;

public class OrderService {
    private OrderRepository orderRepository;
    private boolean isSale;

    public int getCostById(int id) {
        int cost = orderRepository.getOrderById(id).getPrice();
        return !isSale ? cost : (int) (0.5 * cost);
    }

    public void startSale() {
        isSale = true;
    }
}
