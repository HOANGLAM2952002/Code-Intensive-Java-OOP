import com.sun.security.jgss.GSSUtil;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Random rand = new Random();
    int keyCount = 0;
    // toa do player
    int playerX = rand.nextInt(4);
    int playerY = rand.nextInt(4);

    // 2 con enemy in ra E
    int firstEnemyX = rand.nextInt(4);
    int firstEnemyY = rand.nextInt(4);


    int secondEnemyX = rand.nextInt(4);
    int secondEnemyY = rand.nextInt(4);

    // key
    int keyX = rand.nextInt(4);
    int keyY = rand.nextInt(4);

    //map size
    int mapWidth = 4;
    int mapHeight = 4;

    // Enemy move
    int move[] = {-1,0,1};
    int i = rand.nextInt(3);

    public Game() {
        this.playerX = playerX;
        this.playerY = playerY;

        this.firstEnemyX = firstEnemyX;
        this.firstEnemyY = firstEnemyY;
        this.secondEnemyX = secondEnemyX;
        this.secondEnemyY = secondEnemyY;

        this.mapHeight = 4;
        this.mapWidth = 4;

        this.overlap();
    }

    private void overlap() {
        // check player and first E
        while (playerX == firstEnemyX && playerY == firstEnemyY){
            int firstEnemyX = rand.nextInt(4);
            int firstEnemyY = rand.nextInt(4);
        }

        // check player and second E
        while (playerX == secondEnemyX && playerY == secondEnemyY){
            int secondEnemyX = rand.nextInt(4);
            int secondEnemyY = rand.nextInt(4);
        }

        // check first E and second E
        while (firstEnemyX == secondEnemyX && firstEnemyY == secondEnemyY){
            int secondEnemyX = rand.nextInt(4);
            int secondEnemyY = rand.nextInt(4);
        }

        // check K and second E
        while (keyX == secondEnemyX && keyY == secondEnemyY){
            int keyX = rand.nextInt(4);
            int keyY = rand.nextInt(4);
        }

        // check K and first E
        while (keyX == firstEnemyX && keyY == firstEnemyY){
            int keyX = rand.nextInt(4);
            int keyY = rand.nextInt(4);
        }

        // check K and player
        while (keyX == playerX && keyY == playerY){
            int keyX = rand.nextInt(4);
            int keyY = rand.nextInt(4);
        }
    }

    // xu ly logic
        public void run(){
        // nhan lenh va xu ly lenh
        // player nhap lenh
        Scanner sc = new Scanner(System.in);
        // alt + Enter -> import
        String input = sc.next();
//            System.out.println(input);

        // xet ra bien khong duoc
        if (this.playerX == 0){
            if (input.equals("up")){
                System.out.println("cannot make this move");
                this.playerX = 0;
            }
        }
        if (this.playerX == mapHeight-1){
            if (input.equals("down")){
                System.out.println("cannot make this move");
                this.playerX = mapHeight-1;
            }
        }
        if (this.playerY == 0){
            if (input.equals("left")){
                System.out.println("cannot make this move");
                this.playerY = 0;
            }
        }
        if (this.playerY == mapWidth-1){
            if (input.equals("right")){
                System.out.println("cannot make this move");
                this.playerY = mapWidth-1;
            }
        }

        // xet di chuyen map
        if (input.equals("up")) {
            if (this.playerX != 0){
                this.playerX--;
                this.enemyMove();
            }
        }
        if (input.equals("down")) {
            if (this.playerX != mapHeight-1){
                this.playerX++;
                this.enemyMove();
            }
        }
        if (input.equals("left")) {
            if (this.playerY != 0){
                this.playerY--;
                this.enemyMove();
            }
        }
        if (input.equals("right")) {
            if (this.playerY != mapWidth-1) {
                this.playerY++;
                this.enemyMove();
            }
        }

        this.enemyMove();



//             cach khac check bien:
//             if (playerX >= 3){
//                  playerX = 3;
//            }
        this.clamp();


    }

    private void clamp() {
        if (playerX >= 3){
            playerX = mapHeight - 1;
        }
        if (playerY >= 3){
            playerY = mapWidth - 1;
        }
        if (playerX <= 0){
            playerX = 0;
        }
        if (playerY <= 0){
            playerY = 0;
        }

    }


    // ham for in * * * *
    public void printMap() {
        // print Map
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == playerX && j == playerY) {
                    if (i == firstEnemyX && j == firstEnemyY){
                        System.out.print(" E ");
                    } else {
                        if (i == secondEnemyX && j == secondEnemyY){
                            System.out.print(" E ");
                        } else {
                            System.out.print(" P ");
                        }
                    }
                } else {
                    if (i == firstEnemyX && j == firstEnemyY) {
                        System.out.print(" E ");
                    } else {
                        if (i == secondEnemyX && j == secondEnemyY) {
                            System.out.print(" E ");
                        } else {
                            if (i == keyX && j == keyY) {
                                System.out.print(" K ");
                            } else {
                                System.out.print(" * ");
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void enemyMove(){
        // row 0
        if (firstEnemyX == 0){
            if (firstEnemyY == 0){
                firstEnemyY ++;
            }
            if (firstEnemyY == 2){
                firstEnemyX ++;
            }
            if (firstEnemyY == 3){
                firstEnemyX ++;
            }
        }
        // row 1
        if (firstEnemyX == 1){
            if (firstEnemyY == 1){
                firstEnemyY ++;
            }
            if (firstEnemyY == 2){
                firstEnemyX ++;
            }
            if (firstEnemyY == 3){
                firstEnemyX ++;
            }
        }

        // row 2
        if (firstEnemyX == 2){
            if (firstEnemyY == 1){
                firstEnemyY ++;
            }
            if (firstEnemyY == 2){
                firstEnemyX ++;
            }
            if (firstEnemyY == 3){
                firstEnemyX ++;
            }
        }

    }


    public void gameLoop(){
        while (true) {
            // print map
            this.printMap();
            this.run();
            if (playerX == keyX && playerY == keyY){
                this.printMap();
                System.out.println("Won");
                break;
                // System.exit(0);
            }
            if (playerX == firstEnemyX && playerY == firstEnemyY){
                this.printMap();
                System.out.println("Lose");
                break;
                // System.exit(0);
            }
        }
    }



}

