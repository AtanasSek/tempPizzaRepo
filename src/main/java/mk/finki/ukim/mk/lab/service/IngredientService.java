package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    public Ingredient createIngredient(String name, Float amount , boolean spicy, boolean veggie);
    public Ingredient updateIngredient(String oldName, String name,Float amount , boolean spicy, boolean veggie);
    public void deleteIngredient(String name);
    public Page<Ingredient> getAllIngredients();
    public Optional<Ingredient> getIngredient(String name);

}
