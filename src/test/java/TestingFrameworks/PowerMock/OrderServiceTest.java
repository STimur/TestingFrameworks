package TestingFrameworks.PowerMock;

import TestingFrameworks.Model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by Timur on 14-Jun-17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(OfferService.class)
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
    public void getCostOfSpecialOffer() throws Exception {
        mockStatic(OfferService.class);
        when(OfferService.getSpecialOfferId()).thenReturn(1);

        assertEquals(100, orderService.getCostById(OfferService.getSpecialOfferId()));
        verifyStatic(times(1));
        OfferService.getSpecialOfferId();
    }
}
