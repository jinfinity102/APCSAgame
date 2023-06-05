package entityclasses.classes;

import entityclasses.Entity;

public class Bard extends Entity {
  public Bard(String name) { // I'll balance this all later
    super(name, false);
    super.updateStat("def", 50); // out of 1000
    super.updateStat("atk", 15); // out of 1000
    super.updateStat("hp", 75); // out of ~100
    super.updateStat("energy", 2); // attacks done per turn
    super.updateStat("speed", 10); // out of 100
    super.updateStat("evade", 15); // out of 100%
    super.updateStat("spts", 3); // out of 1000
    super.updateStat("cr%", 50); // out of 100%
    super.updateStat("cd%", 30); // undefined
    super.updateStat("coins", 99); // priced accordingly

  }
}
