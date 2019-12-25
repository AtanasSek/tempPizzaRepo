package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
//    String[] listPizzas();
    List<Pizza> listPizzas();
    Pizza createPizza(String name , String description , List<Ingredient> ingredients , boolean veggie);
    Pizza updatePizza(String oldname , String name , String description , List<Ingredient> ingredients , boolean veggie);
    void deletePizza(String name);
    //Page<Pizza> getAllPizzas();
    List<Pizza> getAllPizzas();
    Optional<Pizza> getPizza(String name);
    //public Ingredient createIngredient(String name, Float amount , boolean spicy, boolean veggie);
    //    public Ingredient updateIngredient(String oldName, String name,Float amount , boolean spicy, boolean veggie);
    //    public void deleteIngredient(String name);
    //    public Page<Ingredient> getAllIngredients();
    //    public Optional<Ingredient> getIngredient(String name);
}
