package TestingFrameworks.Mockito;

import TestingFrameworks.Model.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order = new Order(100);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(orderRepository.getOrderById(1)).thenReturn(order);
    }

    @Test
    public void givenNoSale_whenGetCost_ReturnNormalPrice() throws Exception {
        assertEquals(100, orderService.getCostById(1));
        verify(orderRepository, times(1)).getOrderById(1);
    }

    @Test
    public void givenIsSale_whenGetCost_ReturnDiscountedPrice() throws Exception {
        orderService.startSale();
        assertEquals(50, orderService.getCostById(1));
        verify(orderRepository, times(1)).getOrderById(1);
    }
}
