package entityclasses.classes;

import entityclasses.Entity;

public class Assassin extends Entity{
  public Assassin(String name) { // I'll balance this all later
    super(name, false);
    super.updateStat("def", 30); // out of 1000
    super.updateStat("atk", 40); // out of 1000
    super.updateStat("hp", 30); // out of ~100
    super.updateStat("energy", 1); // attacks done per turn
    super.updateStat("speed", 45); // out of ~100
    super.updateStat("evade", 50); // out of 100%
    super.updateStat("spts", 10); // out of 1000
    super.updateStat("cr%", 75); // out of 100%
    super.updateStat("cd%", 150); // undefined
    super.updateStat("coins", 99); // priced accordingly


  }

}
