package classinJava;


class ENumMain{
    public static void main(String[] args) {
        for(EnumSample sample: EnumSample.values()){
            System.out.println(sample.ordinal());
        }
    }
}
public enum EnumSample {
    //By default, each of the constant gets assigned a number called Ordinal Number
    SUNDAY,
    MONDAY,
    TUESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    //Enum with custom Value
}

enum EnumSampleCustomValue {
    //Enum with custom Value

    SUNDAY(101,"1st day of week"),
    MONDAY(102,"2nd day of week"),
    TUESDAY(103,"3rd day of week"),
    THURSDAY(104,"4th day of week"),
    FRIDAY(10123,"5tt day of week"),
    SATURDAY(10781,"6th day of week");

  private int val;
  private String comment;
    EnumSampleCustomValue(int val, String comment) {
        this.comment=comment;
        this.val=val;
    }
}
