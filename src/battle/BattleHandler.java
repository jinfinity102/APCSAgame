package battle;


import main.Main;
import entityclasses.Entity;


public class BattleHandler {

  Entity player, enemy;
  public BattleHandler(Entity player, Entity enemy) {
    this.player = player;
    this.enemy = enemy;
  }
  public void enterBattle() {
    while (true) {
      printGUI();
      Main.input.nextLine();
    }
  }
  public void printGUI() {

  }
  private void playerAttack() {

  }

}
