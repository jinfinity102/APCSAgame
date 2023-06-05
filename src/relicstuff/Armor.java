package relicstuff;

import entityclasses.Entity;

public class Armor extends Item {

  public Armor(Entity entity) {
    super(entity);
  }
  public void headPiece() {
    super.name = "helmet";
    super.holder.updateStat("def", 40);
    super.holder.updateStat("speed", -10);
    super.holder.updateStat("evade", -5);
  }

  public void specialArmor(String name, int def, int speed, int evade, int atk) {
    super.name = name;
    super.holder.updateStat("def", def);
    super.holder.updateStat("speed", speed);
    super.holder.updateStat("atk", atk);
    super.holder.updateStat("evade", evade);
  }

}
