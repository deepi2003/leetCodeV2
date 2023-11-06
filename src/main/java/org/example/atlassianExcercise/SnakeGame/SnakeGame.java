package org.example.atlassianExcercise.SnakeGame;

import java.util.LinkedList;

public class SnakeGame {

    class Game{
        Board board;
        Snake snake;
        STATUS gameStatus;

        public Game(Board board,Snake snake){
            this.board = board;
            this.snake = snake;
            gameStatus = STATUS.NOT_STARTED;
        }
        public  void start() {

        }
        public void moveSnake() {

        }
    }

    class Board {
        LinkedList<Cell> cells;
        public  Board(LinkedList cells){
            this.cells = cells;
        }
    }

    class Snake{
        Cell headPos;
        Cell tailPos;
        int length;
        LinkedList<Cell> body;

        public Snake(Cell head){
            this.headPos = head;
            this.tailPos =  head;
            body.add(head);
        }
        public void eatFood(Cell cell){

        }
    }
     abstract class Cell {
        int row;
         int col;

     }

     class FoodCell extends Cell {

     }

     class EmptyCell extends  Cell {

     }

     enum STATUS {
          NOT_STARTED,
         RUNNING,
         FINISHED

     }

}
