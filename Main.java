import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.RoundingMode;
class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner (System.in);
        DecimalFormat df =new DecimalFormat("#,##0.00)");
        Wallet wallet=new Wallet();
        System.out.println("<<<Т-Система : Логистика транзикций>>>");
        while(true){
            System.out.print("Категория(или 'exit):");
            String cat=scanner.nextLine();
            if ( cat.equalsIgnoreCase("exit"))break;
            System.out.print("Сумма:");
            String sum=scanner.nextLine().replace(',','.').trim();
            try{
                BigDecimal money= new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
                Transaction transaction= new Transaction(cat, money);
                wallet.addTransaction(transaction);
                System.out.println("Объект Transaction  успешно добавлен в память");


            }catch( NumberFormatException|ArithmeticException e){
                System.out.println("Ошибка парсинга суммы. Повторите попытку ");
            }
        }
        System.out.println("\n<<<Выгрузка транзикций из сети >>>");
        for (Transaction t: wallet.getHistory()){
            System.out.println("Транзикция >>> Категория : "+t.getCategory()+"|Сумма:"+df.format(t.getAmount()));

        }
        System.out.println("Итого обработаносуммы:"+df.format(wallet.getTotalSum()));
        scanner.close();
    
    }
}
