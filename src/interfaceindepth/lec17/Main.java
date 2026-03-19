package interfaceindepth.lec17;

public class Main {
    public static void main(String[] args) {
        //see below example of how interface helps achieve polymorphism

        //below is specifically example of runtime polymorphism;

        Bird henBird = new Hen();

        Bird eagleBird = new Eagle();

        henBird.fly();
        eagleBird.fly();
    }
}
