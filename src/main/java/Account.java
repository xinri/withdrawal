import exceptions.WithrawalNegativeValueException;


/**
 * Created by hlay on 09/07/18.
 */
public class Account
{
  private String name;
  private double balance;


  public Account(String name, double value) {
    this.name = name;
    this.balance = value;
  }

  public void withdrawal(double value) throws WithrawalNegativeValueException {

    if (value < 0) throw new WithrawalNegativeValueException();

    this.balance -= value;
  }

  public double getBalance()
  {
    return balance;
  }
}
