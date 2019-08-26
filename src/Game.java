import java.util.Random;
import java.util.Scanner;

public class Game {
    // toa do player
    int playerX = 2;
    int playerY = 2;

    // 2 con enemy in ra E
    int firstEnemyX = 2;
    int firstEnemyY = 0;


    int secondEnemyX = 1;
    int secondEnemyY = 1;

    // key
    int keyX = 0;
    int keyY = 2;

    //map size
    int mapWidth = 4;
    int mapHeight = 4;

    public Game() {
        this.playerX = 2;
        this.playerY = 2;

        this.firstEnemyX = 2;
        this.firstEnemyY = 0;
        this.secondEnemyX = 1;
        this.secondEnemyY = 1;

        this.mapHeight = 4;
        this.mapWidth = 4;

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
            }
        }
        if (input.equals("down")) {
            if (this.playerX != mapHeight-1){
                this.playerX++;
            }
        }
        if (input.equals("left")) {
            if (this.playerY != 0){
                this.playerY--;
            }
        }
        if (input.equals("right")) {
            if (this.playerY != mapWidth-1) {
                this.playerY++;
            }
        }



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
                    System.out.print(" P ");
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

    public void gameLoop(){
        while (true) {
            // print map
            this.printMap();
            this.run();
            if (playerX == keyX && playerY == keyY){
                System.out.println("You won!");
                // break;
                System.exit(0);
            }
        }

    }
}