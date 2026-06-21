import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class Wallet{
    private final List<Transaction>history=new ArrayList<>();
    public void addTransaction(Transaction transaction){
        this.history.add(transaction);
    }
    public List<Transaction>getHistory(){
        return history;
    }
      public BigDecimal getTotalSum(){
        BigDecimal total=BigDecimal.ZERO;
        for(Transaction t: history){
            total=total.add(t.getAmount());

        }
        return total;
    }
}





