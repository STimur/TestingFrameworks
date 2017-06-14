package TestingFrameworks.PowerMock;

import TestingFrameworks.Model.Order;

/**
 * Created by Timur on 14-Jun-17.
 */
public interface OrderRepository {
    // Some very computation intensive db load
    Order getOrderById(int id);
}
