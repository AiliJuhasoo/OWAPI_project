package a_theory.question6.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chocolate")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping
    public List<Cake> getCakes(@RequestParam(value = "name", required = false) String name) {
        return cakeService.findAll(name);
    }

    @GetMapping("{id}")
    public Cake getCake(@PathVariable Long id) {
        return cakeService.findById(id);
    }

    @PostMapping
    public Cake saveCake(@RequestBody Cake cake) {
        return cakeService.save(cake);
    }

    @PutMapping("{id}")
    public Cake updateCake(@RequestBody Cake cake, @PathVariable Long id) {
        return cakeService.update(cake, id);
    }

    @DeleteMapping("{id}")
    public void updateCake(@PathVariable Long id) {
        cakeService.delete(id);
    }

    @GetMapping
    public List<Cake> getCakesByIngredientName(@RequestParam(value = "ingredient-name", required = false) String ingredientName) {
        return cakeService.findAllByIngredientName(ingredientName);
    }

    @GetMapping
    public List<Cake> getCakesByToppingName(@RequestParam(value = "topping-name", required = false) String toppingName) {
        return cakeService.findAllByToppingName(toppingName);
    }
}
