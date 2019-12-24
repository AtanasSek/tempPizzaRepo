package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/ingredients",produces = MimeTypeUtils.APPLICATION_JSON_VALUE) // , method = RequestMethod.GET
public class IngredientsApi{

    private final IngredientService ingredientService;

    public IngredientsApi(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public void createIngredient(@RequestParam String name,@RequestParam Float amount,@RequestParam boolean spicy,@RequestParam boolean veggie){
        ingredientService.createIngredient(name, amount , spicy, veggie);
    }

    @PatchMapping("{/id}")
    public void updateIngredient(@PathVariable("/id") String oldname ,@RequestParam String name,@RequestParam Float amount ,@RequestParam boolean spicy ,@RequestParam boolean veggie){
        ingredientService.updateIngredient(oldname, name , amount , spicy, veggie);
    }

    @DeleteMapping("{/id}")
    public void deleteIngredient(@PathVariable("/id") String name){
        ingredientService.deleteIngredient(name);
    }

    @GetMapping("{/id}")
    public void getIngredient(@PathVariable("/id") String name){
        ingredientService.getIngredient(name);
    }

//    @PostMapping
//    public IngredientService


//TO DO
}
