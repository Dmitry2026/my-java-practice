import java.math.BigDecimal;
interface PaymentSystem{
    public void processTransfer(BigDecimal amount);
}
abstract class BaseAccount {
    private final String accountNumber;
    private BigDecimal balance;
    public BaseAccount(String accountNumber,BigDecimal initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
    }
    public String getAccountNumber(){return accountNumber;}
    public BigDecimal getBalance(){return balance;}
    protected void changeBalance(BigDecimal amount){
     this.balance=balance.add(amount);
    }
}
class DebitAccount extends BaseAccount implements PaymentSystem{
    public DebitAccount(String accountNumber,BigDecimal initialBalance){
        super(accountNumber,initialBalance);
    }
    @Override
    public void processTransfer(BigDecimal amount){
        if(getBalance().compareTo(amount)<0){
            throw new RuntimeException("Недостаточно средств на дебетовой карте.");
        }
        changeBalance(amount.negate());
        System.out.println("Списано с дебетового счета"+amount);
    }
}
class  CreditAccount extends BaseAccount implements PaymentSystem{
    public CreditAccount(String accountNumber, BigDecimal initialBalance){
        super(accountNumber,initialBalance);
    }
    @Override
public void processTransfer(BigDecimal amount){
        changeBalance(amount.negate());
        System.out.println(" Списано в кредит:"+amount+". Текущий баланс:"+getBalance());
    }
}
public class BankOopExercise {
public static void main(String[]args){
    PaymentSystem card1=new DebitAccount("DEBIT-228", new BigDecimal("50000.00"));
    PaymentSystem card2=new CreditAccount("CREDID-666", new BigDecimal("0.00"));
    card1.processTransfer(new BigDecimal("15000.0"));
    card2.processTransfer(new BigDecimal("750000"));

        }
    }
