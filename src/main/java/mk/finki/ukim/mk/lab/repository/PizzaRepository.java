package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,String> {
}
