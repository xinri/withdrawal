import exceptions.WithrawalNegativeValueException;

import java.math.BigDecimal;


/**
 * Created by hlay on 09/07/18.
 */
public class Account
{
  private String name;
  private BigDecimal balance;


  public Account(String name, double balance) {
    this.name = name;
    this.balance = BigDecimal.valueOf(balance);
  }


  public void withdrawal(double value) throws WithrawalNegativeValueException {

    BigDecimal bgValue = BigDecimal.valueOf(value);

    if (bgValue.compareTo(BigDecimal.ZERO) < 0) throw new WithrawalNegativeValueException();

    balance = balance.subtract(bgValue);
  }


  public double getBalance()
  {
    return balance.doubleValue();
  }
}
