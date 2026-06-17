import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println(" Введите часы:");
            int hours = scanner.nextInt();
            System.out.println("Введите минуты:");
            int minutes = scanner.nextInt();
            if (hours == minutes) {
                System.out.println("Синхронизация время зеркальное");
            } else {
                System.out.println("Обычное время");
            }
        }
    }
}
