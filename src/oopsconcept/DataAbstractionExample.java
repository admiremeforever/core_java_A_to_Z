package oopsconcept;

public class DataAbstractionExample  implements car{
    @Override
    public void applyBrake() {
        System.out.println("Breakes applied ..");
    }

    @Override
    public void startEngine() {
        System.out.println("sn");
    }

    @Override
    public void stopEngine(){
        System.out.println("dcjdbf");
    }
}


interface car{
    void applyBrake();
    void startEngine();
    void stopEngine();
}