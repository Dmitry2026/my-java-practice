import java. util.ArrayList;
import java.util.Scanner;
class TimeLong{
    int h;
    int m;
    public TimeLong(int hors, int minutes){
        this.h=hors;
        this.m=minutes;
    }
    public boolean checkMirror(){
        return h==m;
    }
}
class Maim{
    public static void main( String[]args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<TimeLong>list=new ArrayList<>();
        while (true){
            System.out.println("Введите часы( или 99 для выхода:)");
            int hors=scanner.nextInt();
            if(hors==99) {
                break;
            }
                System.out.println("ВВедите минуты:");
            int minutes =scanner.nextInt();
            TimeLong log=new TimeLong(hors,minutes);
            list.add(log);
            if(log.checkMirror() ){
                System.out.println("Синхронизация зафиксирована в объекте\n");

            }else {
                System.out.println("Обычный заход сохранен\n");
            }
        }
        System.out.println("\n  Сессия завершена . Проверяем базу данных...");
        if (list.isEmpty()){
            System.out.println("База пуста. Вы ничего не ввели.");
        }else {
            System.out.println("Всего заходов в списке "+ list.size());
            System.out.println("Индексы проверены. Код готов к депою");
        }
    }
}
