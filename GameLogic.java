package runnerk;

import java.util.*;

public class GameLogic {

    private Vector platforms;
    private Vector traps;
    private Vector enemies;
    private Vector jEnemies;
    private MainHero mainHero;
    private GCounter counter;
    private BackTexture backTexture;

    public void createCounter(){
        // TODO
    }

    public void createMainHero(int heigth, int weigth){
        // TODO
    }

    public void createPlatform(int heigth, int weigth){
        // TODO
    }

    public void createEnemy(int heigth, int weigth){
        // TODO
    }

    public void createJEnemy(int heigth, int weigth){
        // TODO
    }

    public void createTrap(int heigth, int weigth){
        // TODO
    }

    public void setBackTexture(int heigth, int weigth){
        // TODO
    }

    public boolean checkHeroDeath(int position, int line){
        // TODO
        return true;
    }

    public boolean checkEnemyKill(int position, int line){
        // TODO
        return true;
    }

    public boolean checkJEnemyKill(int position, int line){
        // TODO
        return true;
    }

    public void onX(){
        mainHero.jump();
    }

    public void onZ(){
        mainHero.attack();
    }

   public void refreshCounter(){
        //TODO
   }

   public GameLogic(){
      backTexture = new BackTexture(1280, 720);
      mainHero = new MainHero();
      counter = new GCounter();
   }

   public void gameIsRunning(){

   }
}