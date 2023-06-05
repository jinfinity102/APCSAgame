package mapstuff;

public class Tile {
  private static final int[] d1x = { -1, 0, 0, 1}; // (dx, dy) coordinates
  private static final int[] d1y = {  0, 1,-1, 0}; // of squares adjacent to it

  private int north, south, east, west; // tile borders

  public Tile(int north, int south, int east, int west) {
    this.north = north;
    this.south = south;
    this.east = east;
    this.west = west;



  }

  public int getBorder(char direction) {
    switch (direction) {
      case 'n':
        return north;
      case 's':
        return south;
      case 'e':
        return east;
      case 'w':
        return west;
      default:
        throw new IllegalArgumentException("Wrong way");
    }
  }

  public void enter() {

  }
}
