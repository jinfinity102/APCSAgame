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
    while (true) { // round
      while (player.getStat("energy") > 0) { // player turn
        printGUI(); // prints out text based stuff
        char action = Main.input.nextLine().toLowerCase().charAt(0);
        int hpDecrease;
        switch(action) {
          case 'n': // normal attack
            hpDecrease = (player.getStat("atk") + player.crit() * player.getStat("cd%") * player.getStat("atk"));
            enemy.updateHp(hpDecrease);
            player.updateStat("energy", -1);
            System.out.println("Player attacked for " + hpDecrease);
            break;

          case 's': // special attack
            if (player.getStat("energy") < 2) {
              System.out.println("Not enough energy");
              continue;
            }
            hpDecrease = (int) ((player.getStat("lvl") + 1) * 0.5) + player.getStat("atk") * player.getStat("cd&") * 2;
            enemy.updateHp(hpDecrease);
            player.updateStat("energy", -2);
            break;

          case 'u': // ultimate attack
            if (player.getStat("energy") < 3) {
              System.out.println("Not enough energy");
              continue;
            }

          case 'b': {// buff
            System.out.println("Which buff would you like to apply?");
            char buff = Main.input.nextLine().toLowerCase().charAt(0);
            switch (buff) {
              case 'd': // def
                player.updateStat("def", 20);
                break;
              case 'a': // atk
                player.updateStat("atk", 20);
                break;
              case 'h': // heal
                player.updateHp(-10);
                break;
              case 's': // speed
                player.updateStat("speed", 20);
                break;
              case 'e': // evasion
                player.updateStat("evade", 20);
                break;
              default:
                System.out.println("Not a possible buff.");
                continue;


            }
            player.updateStat("energy", -1);
            System.out.println("Buff applied!");
            break;
          }
          case 'd': {// debuff
            System.out.println("Which debuff would you like to apply?");
            char debuff = Main.input.nextLine().toLowerCase().charAt(0);
            if (debuff == 'w') enemy.updateStat("weak", 1);
            else if (debuff == 'v') enemy.updateStat("vul", 1);
            else {
              System.out.println("Not a possible debuff.");
              continue;
            }
            break;
          }
          case 'i': // item
            // display inventory and allow them to choose an item within the inventory
            // fais quand j'ai les temps
            break;

          case 'e': // end turn
            player.updateStat("energy", -10); // just setting it negative so I dont have to worry about it

          default:
            System.out.println("Not a possible action.");
            continue;

        } // end of switch actions
        if (!player.alive || !enemy.alive) break; // death
      } // end of player turn

      enemy.turn(); // each enemy has a hardcoded atk pattern
      if (!player.alive || !enemy.alive) break;

    } // end round

    // reset energy and weak and defends

    player.reset();
    enemy.reset();

  } // end method

  public void printGUI() {
    System.out.println("name" + player.getName() + "\t\t\t\t Energy: " + player.getStat("energy"));
    System.out.println("\n [insert ascii art here] \n");
  }

}
