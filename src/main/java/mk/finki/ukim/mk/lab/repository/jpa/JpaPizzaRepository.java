package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPizzaRepository extends JpaRepository<Pizza,String> {
}
