package relicstuff;

import entityclasses.Entity;

public class Item {
  protected String name;
  protected Entity holder;
  public Item(Entity entity) { // entities can be in chests, inventories and drops
    holder = entity;
    name = null;
  }
  public String getName() {
    return name;
  }
}
