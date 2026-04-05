package methodconstructorsect;

public class RoundOffUpto2Decimal {
    public static void main(String[] args) {
        double number = 6.789;

        number = Math.round(number*10.0)/(10.0);
        System.out.println(number);

    }
}
