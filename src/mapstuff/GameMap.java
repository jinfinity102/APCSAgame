package mapstuff;

import entityclasses.Entity;

public class GameMap {
  private Tile[][] map1 = new Tile[20][20]; // has x and y for location and z stores information about
  private int[][] playerPOV = new int[5][5]; // numbers given to map will have specific meanings; has only tileInfo
  /* tileInfo key:
  0 == nothing, 1 == any obstacle, 2 == unsafe spot (70% chance to find a monster there),
  3 == special enemy, 5 == story, 6 == chest,
  7 == job or mini game ( minesweeper, puzzle, maze, memorization game, etc ),
  8 == rest site, 9 == shop

  // creating a class or method for each number

  // anything outsider the border is marked as 1 and is impassable
  // start location is marked with star only for visualization purposes; will be a zero initially


   */
  private Tile[][] currentMap; // was going to create multiple maps but was low on time kek
  private int x, y; // character coordinates
  private Entity player;


  public GameMap(Entity player) { // will convert to string here and be printed into something legible // generating map in main
    // I don't really want to create a random map since that's kinda annoying so im doing something like this,
    // but you only have a line of sight of 2 units around you
    this.player = player;
    /*
         1     2     3     4     5
      ╔═════╦═════╦═════╦═════╦═════╗
    1 ║     ║     ║     ║     ║     ║
      ╠═════╬═════╬═════╬═════╬═════╣
    2 ║     ║     ║     ║     ║     ║
      ╠═════╬═════╬═════╬═════╬═════╣
    3 ║     ║     ║     ║     ║     ║
      ╠═════╬═════╬═════╬═════╬═════╣
    4 ║     ║     ║     ║     ║     ║
      ╠═════╬═════╬═════╬═════╬═════╣
    5 ║     ║     ║     ║     ║     ║
      ╚═════╩═════╩═════╩═════╩═════╝
    
    */
    currentMap = map1;
  }


  public Tile[][] getMap() {
    return currentMap;
  }

  public void movePlayer(char direction) {
    switch (direction) {
      case 'n':
        y++;
        break;
      case 's':
        y--;
        break;
      case 'w':
        x--;
        break;
      case 'e':
        x++;
        break;
      default:
        return;
    }
  }


  public void updateMap(char direction) { // this character is the first letter of the direction, {n, s, e, w}
    Tile tile = currentMap[x][y];
    if (tile.getBorder(direction) == 0) {
      movePlayer(direction);
      tile.enter(player);
    }


  }



}