package classinJava;

import org.w3c.dom.ls.LSOutput;

public class MultiBondClass {
    public static void main(String[] args) {
        Print<String> printClassString = new Print<>("Ram is a good boy..");

        Print<Integer> printClassInteger = new Print<>(100);

        String s = printClassString.print();
        Integer i = printClassInteger.print();

        System.out.println(s  + " ******* " +i);

        PrintUsingObject printUsingObjectString = new PrintUsingObject("Ram is a good boy in object");

        PrintUsingObject printUsingObjectInteger = new PrintUsingObject(100);
        String sObject = (String) printUsingObjectString.print();
        Integer iObject = (Integer) printUsingObjectInteger.print();









    }

}

class Print<T> {
    private T value;

    Print(T value) {
        this.value = value;
    }

    public T print() {
       return value;
    }
}

//above this could be achieved using object type field but it needs typecasting

class PrintUsingObject {
    private Object value;

    PrintUsingObject(Object value) {
        this.value = value;
    }

    public Object print() {
        return value;
    }
}
//Similarly we have Bounded and multibond classes example
//class Print<T extends Number>   --is bounded generics
// Only number and its child classes can be passed as parameters

//MultiBond
//<T extends SuperClass & interface1 & interface2 > -> this & symbol is very important