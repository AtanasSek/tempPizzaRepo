package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/pizzas",produces = MimeTypeUtils.APPLICATION_JSON_VALUE) // , method = RequestMethod.GET
public class PizzasApi {

    private final PizzaService pizzaService;

    public PizzasApi(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public void createPizza(@RequestParam String name ,@RequestParam String description ,@RequestParam List<Ingredient> ingredients ,@RequestParam boolean veggie){
        pizzaService.createPizza(name, description , ingredients , veggie);
    }

    @PatchMapping("{/id}")
    public void updatePizza(@PathVariable("/id") String oldname ,@RequestParam String name ,@RequestParam String description ,@RequestParam List<Ingredient> ingredients ,@RequestParam boolean veggie){
        pizzaService.updatePizza(oldname, name , description , ingredients, veggie);
    }

    @DeleteMapping("{/id}")
    public void deletePizza(@PathVariable("/id") String name){
        pizzaService.deletePizza(name);
    }

    @GetMapping("{/id}")
    public void getPizza(@PathVariable("/id") String name){
        pizzaService.getPizza(name);
    }

    @GetMapping
    public void getAllPizzas(){
        pizzaService.getAllPizzas();
    }
}
