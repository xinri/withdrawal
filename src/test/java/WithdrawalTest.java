import exceptions.WithrawalNegativeValueException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by hlay on 09/07/18.
 */
public class WithdrawalTest
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

  @Test(expected = WithrawalNegativeValueException.class)
  public void withdrawalNegativeValue() throws WithrawalNegativeValueException
  {
    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(-500);
  }

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
}
