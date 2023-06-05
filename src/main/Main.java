package main;

import entityclasses.Entity;
import entityclasses.classes.*;

import mapstuff.GameMap;

import java.util.Scanner;

public class Main {
  /*
  public static void clearScreen() { // very cool ansi escape sequence which clears screen for me

    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  */
  public static Scanner input = new Scanner(System.in);
  public static Entity getPlayer(String className, String name) {
    Entity player;
    switch (className) {
      case "assassin":
        player = new Assassin(name);
        return player;
      case "bard":
        player = new Bard(name);
        return player;
      default:
        throw new IllegalArgumentException("Illegal class");
    }
  }

  public static void main(String[] args) { // in retrospect, this seems a lot like pokemon LOL

    //clearScreen();

    System.out.println("eaj"); // long introductory backstory stuff
    System.out.println("Enter your name adventurer:");

    String name = input.nextLine();
    //clearScreen();

    System.out.println("Let's view the adventurer classes you can be!");
    // chooses a class

    String role = input.nextLine().toLowerCase();

    Entity player = getPlayer(role, name);


    GameMap gameMap = new GameMap(player);



    // more story
    // will be spawned with certain attributes and a certain inventory
    // spawns in UI and GameMap
    // they move to where they want to go
    // if they move to a square marked 3 in GameMap, then we'll roll the dice to see if they fight or not
    // unless the field is an interactable spot, which I'll have methods in GameMap for those interactions
    //
    while (true) {
      char direction = input.nextLine().toLowerCase().charAt(0);
      gameMap.updateMap(direction);



      break;
    }







    input.close();
  }
}