import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int a;
    int b;

    public MineSweeper(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void outArray(String[][] arr) {
        for (String[] row: arr ){
            for (String col: row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    void run() {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[][] game = new String[this.a][this.b];
        String[][] mine = new String[this.a][this.b];

        int mineNumber = (this.a * this.b) /4;
        int total;
        int tempMine = mineNumber;
        int notMine = 0;
        boolean gameOver = false;


        for(int i = 0; i < this.a; i++){
            for (int j = 0; j < this.b; j++){
                game[i][j] = "-";
                mine[i][j] = "-";
            }
        }

        while (mineNumber != 0) {
            int row = random.nextInt(this.a);
            int col = random.nextInt(this.b);

            if (!mine[row][col].equals("*")) {
                mine[row][col] = "*";
                mineNumber--;
            }
        }

        while (gameOver == false){
            outArray(game);

            System.out.println("========================");

            int mineNum = 0;



            System.out.print("Satır Sayısı : ");
            int row = scanner.nextInt();

            System.out.print("Sütun Sayısı : ");
            int col = scanner.nextInt();

            if (!(row <= this.a && col <= this.b)) {
                System.out.println("Geçersiz sayı girdiniz!!!");
            }else {

                if (mine[row][col].equals("*")){
                    gameOver = true;
                    System.out.println("Mayına Bastınız. Kaybettiniz!!!");
                }else {
                    int rowUp = Math.min((row + 1), this.a-1);
                    int rowDown = Math.max((row - 1), 0);
                    int colUp = Math.min((col + 1), this.b-1);
                    int colDown = Math.max((col - 1), 0);


                    for (int i = rowDown; i <= rowUp; i++){
                        for (int j = colDown; j <= colUp; j++){
                            if (mine[i][j].equals("*")){
                                mineNum++;
                            }
                        }
                    }

                    game[row][col] = String.valueOf(mineNum);
                    notMine++;

                    total = tempMine + notMine;

                    if (total == (this.a * this.b)){
                        System.out.println("Tebrikler Kazandınız! :)");
                        gameOver = true;
                    }

                }

            }

        }

    }

}
