package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="pizzas")
public class Pizza {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "pizzas", fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    @Column(name = "veggie")
    boolean veggie;

    public String getDescription() {
        return description;
    }

    public Pizza(String name, String description , List<Ingredient> ingredients , boolean veggie) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    @Override
    public String toString(){
        return "Name: "+ this.name;
    }
}
