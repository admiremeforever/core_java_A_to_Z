package oopsconcept.relationships;

import java.util.ArrayList;
import java.util.List;

public class Composition {
}

class Room{
    int roomNumber;
    Room(int roomNumber){
        this.roomNumber=roomNumber;
    }
}
class Hotel{
    List<Room> roomList = new ArrayList<>();
    String hotelName;
    Hotel(String name,int numberOfRoom){
        this.hotelName=name;
        for(int i=0;i<numberOfRoom;i++)
            roomList.add(new Room(i));
    }


}

//here Room object is fully managed by hotel so it is a composition (Has-A relationship)