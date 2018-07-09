/**
 * Created by hlay on 09/07/18.
 */
public class WithrawalNegativeValueException extends Exception
{
  @Override
  public String toString()
  {
    return "Retrait avec une valeur negative interdite";
  }
}
