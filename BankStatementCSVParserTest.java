import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParserTest {

    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    private final BankStatementUserInputHandler bankStatementUserInputHandler = new BankStatementUserInputHandler();
    private BankStatementProcessor bankStatementProcessor;

    private final List<BankTransaction> dummyBankTransactions = new ArrayList<>();



    @Test
    public void shouldParseOneCorrectLine(){
        final String line = "30-01-2017, -50,Tesco";


        final BankTransaction result = bankStatementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(),result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.02);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void paymentForMonthShouldNotReturnGreaterThanZeroIfNoPayment(){
        bankStatementProcessor = new BankStatementProcessor(dummyBankTransactions);
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2014,04,13),-900,"Surgery"));
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2014,04,24),-40,"Grocery"));
        final double resultZero = bankStatementProcessor.totalPaymentsForMonth(Month.APRIL);
        Assert.assertEquals(0,resultZero,0);
    }

    @Test
    public void expenseForMonthShouldReturnLessThanZero(){
        bankStatementProcessor = new BankStatementProcessor(dummyBankTransactions);
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2011,9,18),-80,"Dentist"));
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2012,9,13),-800,"Prada Clothes"));

        final double result = bankStatementProcessor.totalExpensesForMonth(Month.SEPTEMBER);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void shouldReturnEmptyListIfTransactionRequestedNotPresent(){
        bankStatementProcessor = new BankStatementProcessor(dummyBankTransactions);
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2011,9,18),-80,"Dentist"));
        dummyBankTransactions.add(new BankTransaction(LocalDate.of(2012,9,13),-800,"Prada Clothes"));

        List<BankTransaction> bankTransactionsForApril = bankStatementProcessor.listExpensesForMonth(Month.APRIL);
        List<BankTransaction> bankTransactionsFor2012 = bankStatementProcessor.findAllTransactionsInYearOf(2018);
        Assert.assertTrue(bankTransactionsForApril.isEmpty());
        Assert.assertTrue(bankTransactionsFor2012.isEmpty());
    }




}
