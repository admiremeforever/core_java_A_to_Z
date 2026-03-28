package oopsconcept.diamondproblem;
/*
public class DiamondProblemDemo extends N,O{
    public static void main(String[] args) {
        DiamondProblemDemo diamondProblemDemo = new DiamondProblemDemo();
        //here compiler gets confused which show to call whether of N or of O
        diamondProblemDemo.show();
    }
}*/

class M {
    void show() {
        System.out.println("Show of M");
    }
}

class N extends M {
    void show() {
        System.out.println("Show of N");
    }
}

class O extends M {
    void show() {
        System.out.println("Show of O");
    }
}

