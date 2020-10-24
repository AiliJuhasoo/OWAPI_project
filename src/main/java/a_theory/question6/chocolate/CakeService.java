package a_theory.question6.chocolate;

import a_theory.question6.chocolate.exception.CakeNotFoundException;
import a_theory.question6.chocolate.exception.InvalidCakeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public List<Cake> findAll(String name) {
        if (isNotBlank(name)) {
            return new ArrayList<Cake>(cakeRepository.findAllByNameLike("%" + name + "%"));
        }
        return new ArrayList<Cake>(cakeRepository.findAll());
    }

    public List<Cake> findAllByIngredientName(String ingredientName) {
        if (isNotBlank(ingredientName)) {
            // Retrieval logics skipped
            return new ArrayList<Cake>(cakeRepository.findAllByIngredientName(ingredientName));
        }
        return new ArrayList<Cake>(cakeRepository.findAll());
    }

    public List<Cake> findAllByToppingName(String toppingName) {
        if (isNotBlank(toppingName)) {
            // Retrieval logics skipped
            return new ArrayList<Cake>(cakeRepository.findAllByIngredientName(toppingName));
        }
        return new ArrayList<Cake>(cakeRepository.findAll());
    }

    public Cake findById(Long id) {
        return cakeRepository.findById(id)
                .orElseThrow(CakeNotFoundException::new);
    }

    public Cake save(Cake cake) {
        if (cake.getName() == null) throw new InvalidCakeException("Cake has no name!");
        if (cake.getSize() == null) throw new InvalidCakeException("Cake has no size!");
        if (cake.getSweetness() == null) throw new InvalidCakeException("Cake has no sweetness level!");
        if (cake.getId() != null) throw new InvalidCakeException("Id is already present");

        return cakeRepository.save(cake);
    }

    public Cake update(Cake cake, Long id) {
        if (cake.getName() == null) throw new InvalidCakeException("Cake has no name!");
        if (cake.getSize() == null) throw new InvalidCakeException("Cake has no size!");
        if (cake.getSweetness() == null) throw new InvalidCakeException("Cake has no sweetness level!");

        Cake dbCake = findById(id);
        dbCake.setName(cake.getName());

        return cakeRepository.save(dbCake);
    }

    public void delete(Long id) {
        Cake dbCake = findById(id);
        cakeRepository.delete(dbCake);
    }
}
