import java.math.BigDecimal;
public class Transaction{
    private final String category;
    private final BigDecimal amount;
    public  Transaction( String category, BigDecimal amount){
        this.category=category;
        if(amount.compareTo(BigDecimal.ZERO)>=0){
            this.amount=amount;

        }else {
            this.amount=BigDecimal.ZERO;
        }
    }
    public String getCategory(){
        return  category;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
