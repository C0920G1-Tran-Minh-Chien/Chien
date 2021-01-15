package _07_abstract_interface.thuc_hanh.animals_interface_edible.animal;
import _07_abstract_interface.thuc_hanh.animals_interface_edible.edible.Edible;
import _07_abstract_interface.thuc_hanh.animals_interface_edible.fruit.Apple;
import _07_abstract_interface.thuc_hanh.animals_interface_edible.fruit.Fruit;
import _07_abstract_interface.thuc_hanh.animals_interface_edible.fruit.Orange;

public class  TestSound {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        Edible animal1 = new Chicken();
//        Chicken check1 = (Chicken) animal1;

         ((Chicken) animal1).makeSound() ;

        System.out.println(((Chicken) animal1).makeSound());
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
//        System.out.println(animals[1] instanceof Animal);
//        System.out.println(animals[1] instanceof Chicken);
//        System.out.println(animals[1] instanceof Edible);

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
