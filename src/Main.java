import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz :)");
        System.out.println("Satır Ve Sütun Sayısını Giriniz.");

        System.out.print("Satır Sayısı : ");
        int a = scanner.nextInt();

        System.out.print("Sütun Sayısı : ");
        int b = scanner.nextInt();

        System.out.println("Oyun Başlıyor. İyi Eğlenceler!");

        MineSweeper mine = new MineSweeper(a,b);

        mine.run();
    }
}
