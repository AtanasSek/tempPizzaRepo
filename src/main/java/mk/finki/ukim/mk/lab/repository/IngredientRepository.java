package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient,String> {
    List<Ingredient> findAllBySpicyIsTrue();

}
