import exceptions.WithrawalNegativeValueException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by hlay on 09/07/18.
 */
public class AccountTest
{
  @Test
  public void nominalCase() throws WithrawalNegativeValueException {

    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(10);

    // then
    assertThat(account.getBalance(), is(90.0d));
  }

  @Test
  public void minimalWithdrawal() throws WithrawalNegativeValueException {

    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(0);

    // then
    assertThat(account.getBalance(), is(100.0d));
  }

  @Test(expected = WithrawalNegativeValueException.class)
  public void withdrawalNegativeValue() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(-500);
  }

  @Test(expected = WithrawalNegativeValueException.class)
  public void withdrawalNegativeValueLimit() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(-100.00001);
  }


  /**
   * As not further explanation is given, we keep the fact that we can have a negative amount.
   * TODO : check if we need to throw an exception or to add a limit in the account
   *
   * @throws WithrawalNegativeValueException
   */
  @Test
  public void withdrawalWithNotEnoughBalance() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(101d);

    // then
    assertThat(account.getBalance(), is(-1.0d));
  }


  /**
   * Well know problem of precision in double.
   * in our case : 0.3d - 0.2d = 0.19999999d with double precision problem which we don't want to have
   *
   * @throws WithrawalNegativeValueException
   */
  @Test
  public void withdrawalWithDoubleProblem() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 0.3d);

    // when
    account.withdrawal(0.2d);

    // then
    assertThat(account.getBalance(), is(0.1d));
  }


  /**
   * 370809.77 - 879.35 - 3366790.80 will return 3139.6200000000536 if using the double problem precision
   * @throws WithrawalNegativeValueException
   */
  @Test
  public void doingMultipleWithdrawal() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 370809.77);

    // when
    account.withdrawal(879.35d);
    account.withdrawal(366790.80d);

    // then
    assertThat(account.getBalance(), is(3139.62d));
  }


  @Test
  public void multipleAccountWithMultipleWithdrawal() throws WithrawalNegativeValueException
  {
    // given
    Account account1 = new Account("Jean-Pierre", 1000);
    Account account2 = new Account(null, 1000);

    // when
    account1.withdrawal(100.20);
    account1.withdrawal(150.10);
    account1.withdrawal(200.001);


    account2.withdrawal(1.01);
    account2.withdrawal(5.001);
    account2.withdrawal(1000.0001);

    // then
    assertThat(account1.getBalance(), is(549.699d));
    assertThat(account2.getBalance(), is(-6.0111d));
  }
}
