package oopsconcept.relationships;

import java.util.List;

public class Aggregation {

}

class Player{
    String name;
    Player(String name){
        this.name=name;
    }
}

class Team{
    List<Player> player;
    String teamName;
    Team(List<Player> playerList,String teamName){
        this.teamName=teamName;
        this.player=playerList;
    }
}

/*
Players can exist independently and they are not fully managed my Team so this is a weak relation ship so
this is Aggregation Has-A relationship*/
