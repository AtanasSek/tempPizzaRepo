package mk.finki.ukim.mk.lab.repository.jpa;


import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JpaIngredientRepository extends JpaRepository<Ingredient,String> {
}
