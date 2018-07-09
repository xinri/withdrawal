import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by hlay on 09/07/18.
 */
public class WithdrawalTest
{
  @Test
  public void nominalCase() {

    // given
    Account account = new Account("Jean-Pierre", 100d);

    // when
    account.withdrawal(10);

    // then
    assertThat(account.getBalance(), is(90.0d));
  }

}
