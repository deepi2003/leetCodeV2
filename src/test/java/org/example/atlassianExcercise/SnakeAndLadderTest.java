package org.example.atlassianExcercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderTest {

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

    @Test
    void test() {
        game.start();

    }

}