import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor (final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    public List<BankTransaction> findTransactionGreaterThanEqual(final double amount){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getAmount() >= amount){
                result.add(bankTransaction);
            }
        }

        return result;
    }

    public List<BankTransaction> findAllTransactionsInMonthOf(final Month month){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month){
                result.add(bankTransaction);
            }
        }

        return result;


    }

    public List<BankTransaction> findAllTransactionsInYearOf(int year){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getYear() == year){
                result.add(bankTransaction);
            }
        }
        return result;

    }

    public double totalExpensesForYear(int year){
        double total = 0d;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getAmount() < 0 && bankTransaction.getDate().getYear() == year){
                total += bankTransaction.getAmount();
            }
        }

        return total;

    }
    public double totalPaymentsForYear(int year){
        double total = 0d;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getAmount() > 0 && bankTransaction.getDate().getYear() == year){
                total += bankTransaction.getAmount();
            }
        }

        return total;

    }
    public double totalExpensesForMonth(Month month){
        double total = 0d;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getAmount() < 0 && bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }

        return total;

    }
    public double totalPaymentsForMonth(Month month){
        double total = 0d;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getAmount() > 0 && bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }

        return total;

    }

    public List<BankTransaction> listExpensesForMonth(Month month){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() < 0 && bankTransaction.getDate().getMonth() == month){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> listExpensesForYear(int year){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() < 0 && bankTransaction.getDate().getYear() == year){
                result.add(bankTransaction);
            }

        }

        return result;

    }

    public List<BankTransaction> listPaymentsForMonth(Month month){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() > 0 && bankTransaction.getDate().getMonth() == month){
                result.add(bankTransaction);
            }

        }

        return result;

    }

    public List<BankTransaction> listPaymentsForYear(int year){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() > 0 && bankTransaction.getDate().getYear() == year){
                result.add(bankTransaction);
            }

        }

        return result;

    }



    public List<BankTransaction> findTransactionLessThanEqual(final double amount){
        List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getAmount() >= amount){
                result.add(bankTransaction);
            }
        }

        return result;

    }

    public double calculateTotalAmount(){
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }



    public double calculateTotalInMonth(final Month month){
        double total = 0;

        for(final BankTransaction bankTransaction:bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalInYear(int year){
        double total = 0;

        for(final BankTransaction bankTransaction:bankTransactions){
            if(bankTransaction.getDate().getYear() == year){
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }




    public double calculateTotalForCategory(final String category){
        double total = 0;

        for(final BankTransaction bankTransaction:bankTransactions){
            if(bankTransaction.getDescription().equals(category)){
                total+=bankTransaction.getAmount();
            }
        }
        return total;
    }

    public List<BankTransaction> listTransactionsForCategory(final String category){
        List<BankTransaction> result = new ArrayList<>();

        for(final BankTransaction bankTransaction:bankTransactions){
            if(bankTransaction.getDescription().equals(category)){
                result.add(bankTransaction);
            }
        }
        return result;
    }



}
