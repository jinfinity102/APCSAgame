package relicstuff;

import entityclasses.Entity;

public class Armor extends Item {

  public Armor(Entity entity) {
    super(entity);
  }

  public void specialArmor(String name, int def, int speed, int evade, int atk) {
    super.name = name;
    super.holder.updateStat("def", def);
    super.holder.updateStat("speed", speed);
    super.holder.updateStat("atk", atk);
    super.holder.updateStat("evade", evade);
  }


}
