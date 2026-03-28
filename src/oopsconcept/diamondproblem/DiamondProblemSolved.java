package oopsconcept.diamondproblem;

public class DiamondProblemSolved implements B,C{

    @Override
    public void show() {
        System.out.println("Show method implemented for DiamondProblemSolved");
    }
}

interface A {
void show();
}
interface B extends A{
    void show();

}

interface C extends A{

    @Override
    public void show() ;
}

