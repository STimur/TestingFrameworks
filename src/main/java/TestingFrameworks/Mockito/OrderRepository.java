package TestingFrameworks.Mockito;

import TestingFrameworks.Model.Order;

public interface OrderRepository {
    Order getOrderById(int id);
}
