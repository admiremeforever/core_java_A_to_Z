package classinJava.singelton;

public class EagerInitilizationSingletonDemo {
    public static void main(String[] args) {
        DBConnection dbConnection =  DBConnection.getConnection();
    }
}

class DBConnection{
    private static DBConnection connectionObj = new DBConnection();
    private DBConnection(){

    }
    public static DBConnection getConnection(){
        return connectionObj;
    }
}