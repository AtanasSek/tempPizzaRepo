package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryOrderRepositoryImpl {

    private List<Order> orderList;


    public void setOrder(String pizzaType, String pizzaSize , String clientName, String address){
        Order order = new Order(pizzaType , pizzaSize , clientName , address);
        orderList.add(order);
    }

}
