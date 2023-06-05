package entityclasses.enemies;

import entityclasses.Entity;
import relicstuff.Item;


public class Lavagulin extends Entity{
  private Item[] inventory;
  public Lavagulin(String name) {
    super(name, true);
    super.updateStat("def", 50); // out of 1000
    super.updateStat("atk", 20); // out of 1000
    super.updateStat("hp", 100); // out of 1000
    super.updateStat("energy", 0); // attacks done per turn
    super.updateStat("speed", 30); // out of 1000
    super.updateStat("spts", 0); // out of 1000
    super.updateStat("cr%", 0); // out of 1000
    super.updateStat("cd%", 0); // undefined
    super.updateStat("coins", (int)(Math.random() * 10) + 33); // priced accordingly
    this.inventory = super.getInventory();
    //super.updateInventory("coins");
  }
  public void attackPatterns(int turnNumber, Entity player) {
    if (turnNumber % 3 == 0) {
      player.updateStat("def", -1);
      player.updateStat("atk", -1);
    }
    else {
      player.updateHp(0);
    }
  }
  public void defeated() {// displays the loot and returns another inventory that contains the loot
    //

  }
}
