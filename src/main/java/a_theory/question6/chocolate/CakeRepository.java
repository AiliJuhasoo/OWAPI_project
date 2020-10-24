package a_theory.question6.chocolate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

    List<Cake> findAllByNameLike(String name);
    List<Cake> findAllByIngredientName(String ingredientName);
    List<Cake> findAllByToppingName(String toppingName);
}
