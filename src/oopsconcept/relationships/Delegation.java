package oopsconcept.relationships;

public class Delegation {
}

class Printer{
    public void print(String s){
        System.out.println(s);
    }
}

class Desktop{
    //below code would be delegation+Composition
 /*  Printer printer = new Printer();
    public void givePrintout(String s){
        printer.print(s);
    }*/
  //below code would be Delegation + Association
    Printer printer;
    Desktop(Printer printer){
        this.printer=printer;
    }

    public void givePrintout(String s) {
        printer.print(s);
    }

}