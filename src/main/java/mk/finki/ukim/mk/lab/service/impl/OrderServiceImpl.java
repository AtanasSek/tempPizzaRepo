package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.inmemory.InMemoryOrderRepositoryImpl;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final InMemoryOrderRepositoryImpl inMemoryOrderRepositoryImpl;

    public OrderServiceImpl(InMemoryOrderRepositoryImpl inMemoryOrderRepositoryImpl) {
        this.inMemoryOrderRepositoryImpl = inMemoryOrderRepositoryImpl;
    }

    public void placeOrder(String pizzaType,String pizzaSize, String clientName, String address){
        inMemoryOrderRepositoryImpl.setOrder(pizzaType,pizzaSize,clientName,address);
    }
    public void placeOrder(Order order){
        inMemoryOrderRepositoryImpl.setOrder(order.getPizzaType(),order.getPizzaSize(),order.getClientName(),order.getClientAddress());
    }

}
