package mk.finki.ukim.mk.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="ingredients")
@Data
public class Ingredient {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private Float amount;
    @Column(name = "spicy")
    private boolean spicy;
    @Column(name = "veggie")
    private boolean veggie;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Pizza> pizzas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    public Ingredient(String name, Float amount, boolean spicy, boolean veggie) {
        this.name = name;
        this.amount = amount;
        this.spicy = spicy;
        this.veggie = veggie;
    }
}
