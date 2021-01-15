package _07_abstract_interface.thuc_hanh.animals_interface_edible.animal;

import _07_abstract_interface.thuc_hanh.animals_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: Meomeo";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
