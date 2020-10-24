package a_theory.question6.chocolate;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cake {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String size;
    private String sweetness;
    @ElementCollection
    private List<String> ingredients;
    @ElementCollection
    private List<String> toppings;

    public Cake() {

    }

    public Cake(String name, String size, String sweetness, List<String> ingredients, List<String> toppings) {

        this.name = name;
        this.size = size;
        this.sweetness = sweetness;
        this.ingredients = ingredients;
        this.toppings = toppings;
    }


    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
