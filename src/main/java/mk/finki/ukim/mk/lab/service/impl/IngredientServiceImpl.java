package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidIngredientNameException;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final PizzaRepository pizzaRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public Ingredient createIngredient(String name,Float amount , boolean spicy, boolean veggie){
        Ingredient ingredient = new Ingredient(name, amount, spicy, veggie);
        return this.ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(String oldName, String name,Float amount , boolean spicy, boolean veggie){
        Ingredient ingredient = this.ingredientRepository.findById(oldName).orElseThrow(InvalidIngredientNameException::new);
        ingredient.setName(name);
        ingredient.setAmount(amount);
        ingredient.setSpicy(spicy);
        ingredient.setVeggie(veggie);
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(String name) {
        this.ingredientRepository.deleteById(name);
    }

    public Page<Ingredient> getAllIngredients(){
        Pageable page = PageRequest.of(0,5, Sort.by("name"));
        return this.ingredientRepository.findAll(page);
    }

    public Optional<Ingredient> getIngredient(String name){
        return this.ingredientRepository.findById(name);
    }

    public List<Ingredient> getIngredientBySpicy(){
        return this.ingredientRepository.findAllBySpicyIsTrue();
    }

    // Nepoznata notacija za baranje дополнително Ќе ги врати сите пици што ја содржат состојката со id на: GET /ingredients/{id}/pizzas
//    public List<Pizza> getPizzasWithIngredient(String name){
//        return this.pizzaRepository.findByAll;
//    }
}
