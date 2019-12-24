package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidIngredientNameException;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.repository.inmemory.InMemoryPizzaRepositoryImpl;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final InMemoryPizzaRepositoryImpl inMemoryPizzaRepositoryImpl;
    private final IngredientRepository ingredientRepository;
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(InMemoryPizzaRepositoryImpl inMemoryPizzaRepositoryImpl, PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.inMemoryPizzaRepositoryImpl = inMemoryPizzaRepositoryImpl;
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Pizza createPizza(String name , String description , List<Ingredient> ingredients , boolean veggie){
        Pizza pizza = new Pizza(name, description, ingredients , veggie);
        return this.pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(String oldName, String name,String description , List<Ingredient> ingredients, boolean veggie){
        Pizza pizza = this.pizzaRepository.findById(oldName).orElseThrow(InvalidIngredientNameException::new);
        pizza.setName(name);
        pizza.setDescription(description);
        pizza.setIngredients(ingredients);
        pizza.setVeggie(veggie);
        return this.pizzaRepository.save(pizza);
    }

    public void deletePizza(String name) {
        this.pizzaRepository.deleteById(name);
    }

    public Page<Pizza> getAllPizzas(){
        Pageable page = PageRequest.of(0,5, Sort.by("name"));
        return this.pizzaRepository.findAll(page);
    }

    public Optional<Pizza> getPizza(String name){
        return this.pizzaRepository.findById(name);
    }

    @Override
    public List<Pizza> listPizzas(){
        return inMemoryPizzaRepositoryImpl.getAllPizzas();
    }
}
