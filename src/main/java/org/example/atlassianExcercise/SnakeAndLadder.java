package org.example.atlassianExcercise;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder {
    Dice dice = new Dice(6);
    Player p1 = new Player(1);
    Player p2 = new Player(2);
    Player p3 = new Player(3);
    Snake s1 = new Snake(22, 4);
    Snake s2 = new Snake(50, 14);
    Snake s3 = new Snake(92, 10);
    Ladder l1 = new Ladder(7, 25);
    Ladder l2 = new Ladder(16, 80);
    Ladder l3 = new Ladder(22, 50);
    Board board = new Board(10);
    Game game = new Game(board, dice);

    public void start() {
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        board.addEntity(s1);
        board.addEntity(s2);
        board.addEntity(s3);
        board.addEntity(l1);
        board.addEntity(l2);
        board.addEntity(l3);
        game.start();
        while(game.players.size()> 1){
            Player currPlayer = game.players.poll();
            movePlayer(currPlayer, dice.roll());
            if(currPlayer.getCurrPos() != board.getMaxPos()){
                game.players.offer(currPlayer);
            }
        }
    }

    public void movePlayer(Player player, int number) {
        int newPos = player.currPos + number;
        if(board.hasEntity(newPos)){
            player.currPos = board.getEntity(newPos).getEndPos();
        } else {
            player.currPos = newPos;
        }
    }
}

class Game{
    Board board;
    Dice dice;
    Queue<Player> players;
    GAME_STATUS gameStatus;
    public Game(Board board, Dice dice){
        this.board = board;
        this.dice = dice;
        gameStatus = GAME_STATUS.NOT_STARTED;
        players = new LinkedList<>();
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

    public void start(){
        gameStatus = GAME_STATUS.RUNNING;
    }
}

class Dice {
    int maxNumber;
    public Dice(int maxNumber){
        this.maxNumber = maxNumber;
    }
    int roll() {
        return (int)Math.round(Math.random()*maxNumber+1);
    }
}

class Player{
    int ID;
    int currPos;
    public  Player(int ID){
        this.ID = ID;
        this.currPos = 0;
    }
    public void move(int pos){
        this.currPos = pos;
    }
    public  int getCurrPos() {
        return  this.currPos;
    }
}

abstract class Entity{
    int startPos;
    int endPos;

    public Entity(int startPos, int endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }
    int getStartPos() {
        return startPos;
    }

    int getEndPos() {
        return endPos;
    }
}

class Snake extends Entity {

    public Snake(int startPos, int endPos) {
        super(startPos, endPos);
    }
}

class Ladder extends Entity {

    public Ladder(int startPos, int endPos) {
        super(startPos, endPos);
    }
}

class Board{
    int dimension;
    Map<Integer, Entity> entities;
    public  Board(int dimension) {
        this.dimension = dimension;
    }
    public void addEntity(Entity entity) {
        entities.put(entity.getStartPos(), entity);
    }
    public  int getMaxPos() {
        return dimension*dimension;
    }
    public boolean hasEntity(int pos){
        return entities.containsKey(pos);
    }
    public  Entity getEntity(int pos){
        return entities.get(pos);
    }
}

enum  GAME_STATUS{
    NOT_STARTED,
    RUNNING,
    OVER
}
