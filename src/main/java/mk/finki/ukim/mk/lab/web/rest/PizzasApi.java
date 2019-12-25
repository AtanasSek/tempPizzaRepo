package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.data.domain.Page;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/pizzas",produces = MimeTypeUtils.APPLICATION_JSON_VALUE) // , method = RequestMethod.GET
public class PizzasApi {

    private final PizzaService pizzaService;

    public PizzasApi(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public void createPizza(String name ,String description ,List<Ingredient> ingredients ,boolean veggie){
        pizzaService.createPizza(name, description , ingredients , veggie);
    }

    @PatchMapping("/{id}")
    public void updatePizza(@PathVariable("id") String oldname ,String name ,String description ,List<Ingredient> ingredients ,boolean veggie){
        pizzaService.updatePizza(oldname, name , description , ingredients, veggie);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable("id") String name){
        pizzaService.deletePizza(name);
    }

    @GetMapping("/{id}")
    public Optional<Pizza> getPizza(@PathVariable("id") String name){
       return pizzaService.getPizza(name);
    }

    @GetMapping
//    public Page<Pizza> getAllPizzas(){
//        return pizzaService.getAllPizzas();
//    }
    public List<Pizza> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }


}
