package oopsconcept;

public class RunTimePolymorphismExample {
    public static void main(String[] args) {
       Animal animal1 = new Animal();
       Animal animal2 = new Dog();

       /*now at run time it will be decided which makeSound will be called it is called
        runtime/Dynamic Polymorphism*/
       animal1.makeSound();
       animal2.makeSound();
    }
}


class Dog extends Animal{

    @Override
    public void makeSound(){
        System.out.println("Dog is Barking ..");
    }
}
class Animal {
    public void makeSound(){
        System.out.println("This is a generic sound  ..");
    }
}