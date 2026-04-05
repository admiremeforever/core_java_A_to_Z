package methodconstructorsect;

public class SuperKeywordDemo {

    public static void main(String[] args) {
        Child chile =new Child(34);
    }
}

class Parent{
    Parent(int x){
        System.out.println("I am Parent with parame");
    }


}

class Child extends Parent{

    Child(int x) {
        super(x);
        System.out.println("I am child");


    }
}
//super keyword is used to invoke parent class constructor from child class and
//if parent is parametrized constructor then child must implement it

//How flot numbers are stored in memory and how to rund off upto n decimal places