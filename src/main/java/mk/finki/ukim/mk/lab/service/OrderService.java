package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

public interface OrderService {
    void placeOrder(String pizzaType,String pizzaSize ,String clientName, String address);
    public void placeOrder(Order order);
}
