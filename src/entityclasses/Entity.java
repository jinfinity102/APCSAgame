package entityclasses;

import relicstuff.Item;

import java.util.Objects;

public class Entity {
  private final String[] statName = {"def", "atk", "hp", "energy", "speed", "evade", "spts", "cr%", "cd%", "weak", "vul", "lvl", "lvlXP"}; // here to compare positions
  private final int[] stats =       {  0  ,   0  ,  0  ,    0    ,    0   ,   0    ,   0   ,   0  ,   0  ,   0   ,   0  ,   0  ,   0    }; // easier to store data and will be stored in the above order

  protected Item[] inventory = new Item[10]; // last 2 inventory slots are going to be used for monster drops if they are an enemy

  private String name = "";
  private boolean alive = true, enemy = false, crit = false;

  public Entity(String name, boolean enemy) {
    this.name = name;
    this.enemy = enemy;

  }

  public void updateHp(int hpDecrease) {
    stats[2] -= hpDecrease;
    if (stats[2] <= 0) alive = false;
  }

  public void updateStat(String statsName, int change) { // takes delta of an increase or decrease in values
    for (int i = 0; i < statName.length; i++) {
      if (Objects.equals(statsName, statName[i])) stats[i] += change;
    }
  }

  public boolean checkInventory(String itemName) {
    for (Item i : inventory) {
      if (Objects.equals(i.getName(), itemName)) return true;
    }
    return false;
  }

  public void updateInventory(Item itemName) {
    boolean invFree = true;
    for (Item i : inventory) {
      if (i == null) invFree = true;
      else invFree = false;
    }
    if (invFree) {
      for (int i = 0; i < inventory.length; i++) {
        if (inventory[i] != null) inventory[i] = itemName;
      }
    }
  }

  public Item[] getInventory() {
    return inventory;
  }

  public Item[] defeatedDrops() {
    Item[] drops = new Item[2];
    drops[0] = inventory[0];
    drops[1] = inventory[1];
    return drops;
  }

  public String getName() {
    return name;
  }

  public int[] getStats() {
    return stats;
  }

}
