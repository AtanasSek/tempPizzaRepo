package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="ORDERS")
public class Order {
    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;

    @Id
    private Long orderId=0L;

    public String getPizzaType() {
        return pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Order(String pizzaType, String pizzaSize, String clientName, String clientAddress) {
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId++;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}
