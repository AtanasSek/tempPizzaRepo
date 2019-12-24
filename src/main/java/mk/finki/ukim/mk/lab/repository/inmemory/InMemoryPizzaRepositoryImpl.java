package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPizzaRepositoryImpl {

    private List<Pizza> pizzaList;
    private List<Ingredient> ingredientList;

    public InMemoryPizzaRepositoryImpl() {
        this.pizzaList = new ArrayList<>(10);
        this.ingredientList = new ArrayList<>(6);

        this.ingredientList.add(new Ingredient("Mozzarella" , 20f , false , false));
        this.ingredientList.add(new Ingredient("Tomato Sauce" , 10f , false , false));
        this.ingredientList.add(new Ingredient("Barbeque Sauce" , 10f , false , false));
        this.ingredientList.add(new Ingredient("Cheddar" , 20f , false , false));
        this.ingredientList.add(new Ingredient("Chili Peppers" , 5f , true , true));
        this.ingredientList.add(new Ingredient("Onions" , 15f , false , true));
        this.pizzaList.add(new Pizza("Margherita" , "(tomato sauce, mozzarella)" , ingredientList , true));
        this.pizzaList.add(new Pizza("Carbonara" , "(fresh cream, mozzarella, bacon)" , ingredientList , true));
        this.pizzaList.add(new Pizza("Vegetariana" , "(tomato sauce, mushrooms)" , ingredientList , true));
        this.pizzaList.add(new Pizza("Calzone" , "(Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)" , ingredientList , true));
        this.pizzaList.add(new Pizza("Cheddar" , "(cheddar, tomato sauce)", ingredientList , true));
        this.pizzaList.add(new Pizza("Capricciosa" , "(tomato sauce, cheese, ham)", ingredientList , true));
        this.pizzaList.add(new Pizza("Burger Classic" , "(barbecue sauce, beef, mozzarella, onions)", ingredientList , true));
        this.pizzaList.add(new Pizza("Burger Barbecue" , "(ham, chicken meat, onions)", ingredientList , true));
        this.pizzaList.add(new Pizza("Pepperoni" , "(tomato sauce, mozzarella, sausage)", ingredientList , true));
        this.pizzaList.add(new Pizza("Quattro Formaggi" , "(Taleggio, Mascarpone, Gorgonzola, Parmesan)", ingredientList , true));

    }

    public List<Pizza> getAllPizzas() {
        return pizzaList;
    }



}
