package dkit.oop;
/**
 * Unit tests for BankAccount class and FinancialUtility static methods
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testNoArgConstructor() {
        BankAccount account = new BankAccount();
        double expected = 0.00;  // no-arg constructor should set balance to zero
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void testConstructor() {
        BankAccount account = new BankAccount(200.01);
        double expected = 200.01;
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void deposit() {
        BankAccount account = new BankAccount(100.00);
        account.deposit(22.22);
        double expected = 122.22;
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void withdrawal() {
        BankAccount account = new BankAccount(100.00);
        account.withdraw(9.99);
        double expected = 90.01;
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void withdrawalCausingOverdraft() {
        BankAccount account = new BankAccount(100.00);
        account.withdraw(200.00);
        double expected = (100.00 - 200.00) - BankAccount.OVERDRAFT_FEE;
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void testStaticPercentageOf() {
        double actual = FinancialUtility.percentOf(10,150);
        double expected = 15.00;
        assertEquals(expected, actual, 0.005);
    }

    //TODO
    // Add a test method to verify the addInterest method()
    // You will have to manually calculate the expected result
    // for comparison with the actual result.
}
