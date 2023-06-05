package relicstuff;

import entityclasses.Entity;

public class Weapon extends Item {
  public Weapon(Entity entity) {
    super(entity);
  }

  public void specialWeapon(String name, int cr, int speed, int evade, int atk) {
    super.name = name;
    super.holder.updateStat("cr%", cr);
    super.holder.updateStat("speed", speed);
    super.holder.updateStat("atk", atk);
    super.holder.updateStat("evade", evade);
  }

}
