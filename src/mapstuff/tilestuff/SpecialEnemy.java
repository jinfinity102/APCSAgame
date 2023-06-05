package mapstuff.tilestuff;

import battle.BattleHandler;
import entityclasses.Entity;
import mapstuff.Tile;

public class SpecialEnemy extends Tile {

  Entity enemy;

  public SpecialEnemy(int north, int south, int east, int west, Entity enemy) {
    super(north, south, east, west);
    this.enemy = enemy;

  }

  @Override
  public void enter(Entity player) {
    BattleHandler newBattle = new BattleHandler(player, enemy);
    newBattle.enterBattle();

  }
}
