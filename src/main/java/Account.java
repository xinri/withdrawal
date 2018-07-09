import exceptions.WithrawalNegativeValueException;

import javax.annotation.Nullable;
import java.math.BigDecimal;


/**
 * Created by hlay on 09/07/18.
 */
public class Account
{
  private String name;
  private BigDecimal balance;


  public Account(@Nullable String name, double balance) {
    this.name = name;
    this.balance = BigDecimal.valueOf(balance);
  }


  /**
   * withraw the specific amount from the balance
   *
   * TODO : if the implementation need to know if the withdrawal is ok or not, add a return value.
   * It is better to add a return value if possible.
   *
   * @param amount the value to withdraw
   * @throws WithrawalNegativeValueException
   */
  public void withdrawal(double amount) throws WithrawalNegativeValueException {

    BigDecimal bgValue = BigDecimal.valueOf(amount);

    if (bgValue.compareTo(BigDecimal.ZERO) < 0) throw new WithrawalNegativeValueException();

    balance = balance.subtract(bgValue);
  }


  /**
   * return the balance of the account.
   *
   * @return the balance of the account
   */
  public double getBalance()
  {
    return balance.doubleValue();
  }
}
