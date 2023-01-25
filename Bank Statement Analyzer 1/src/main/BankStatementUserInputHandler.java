import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BankStatementUserInputHandler {
    Scanner scan = new Scanner(System.in);
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    BankStatementProcessor bankStatementProcessor;


    public void startInteraction() throws IOException {
        System.out.println("Welcome to the Bank Statement Analyzing App\n");
        System.out.println("Enter the name of the csv file name you would like to analyze.");
        String input = "src/" + scan.nextLine() + ".csv";

        List<BankTransaction> bankTransactions = bankStatementAnalyzer.analyze(bankStatementParser, input);
        bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        System.out.println("Enter 1 to calculate total salary received");
        System.out.println("Enter 2 to list transactions for a particular month");
        System.out.println("Enter 3 to calculate transaction for a particular year");
        System.out.println("Enter 4 to calculate transaction for a particular category");
        System.out.println("Enter QUIT to exit");
        input  = scan.nextLine();
        while(!input.equalsIgnoreCase("QUIT")){
            processChoice(input);
            System.out.println("Enter 1 to calculate total salary received");
            System.out.println("Enter 2 to list transactions for a particular month");
            System.out.println("Enter 3 to calculate transaction for a particular year");
            System.out.println("Enter 4 to calculate transaction for a particular category");
            System.out.println("Enter QUIT to exit");
            input = scan.nextLine();

        }

    }

    private void processChoice(String choice){
        switch (choice){
            case "1":
                System.out.println("Total Salary Received: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
                break;
            case "2":
                System.out.println("Which month of transaction would you like to list?");
                String monthChosen = scan.nextLine();
                while(!monthChosen.equals("EXIT")){
                    List<BankTransaction> listInMonth = bankStatementProcessor.findAllTransactionsInMonthOf(Month.valueOf(monthChosen.toUpperCase()));
                    for(BankTransaction bankTransaction : listInMonth){
                        System.out.println(bankTransaction.toString());
                    }
                    System.out.println("\nTOTAL TRANSACTIONS FOR THE MONTH OF " + monthChosen + ": ");
                    System.out.println(bankStatementProcessor.calculateTotalInMonth(Month.valueOf(monthChosen.toUpperCase())));
                    System.out.println("\nTOTAL PAYMENT FOR THE MONTH OF " + monthChosen + ": " + bankStatementProcessor.totalPaymentsForMonth(Month.valueOf(monthChosen.toUpperCase())));
                    System.out.println(bankStatementProcessor.listPaymentsForMonth(Month.valueOf(monthChosen.toUpperCase())));
                    System.out.println("\nTOTAL EXPENSES FOR THE MONTH OF " + monthChosen + ": " + bankStatementProcessor.totalExpensesForMonth(Month.valueOf(monthChosen.toUpperCase())));
                    System.out.println(bankStatementProcessor.listExpensesForMonth(Month.valueOf(monthChosen.toUpperCase())));
                    System.out.println("Would you like to list transactions for a different month? Type Y or EXIT");
                    monthChosen = scan.nextLine();
                    if(monthChosen.equals("Y")){
                        System.out.println("Which month of transaction would you like to list?");
                        monthChosen = scan.nextLine();
                    }else{
                        monthChosen = "EXIT";
                    }
                }
                break;
            case "3":
                System.out.println("Which year of transactions would you like to list?");
                String yearChosen = scan.nextLine();
                while(!yearChosen.equalsIgnoreCase("EXIT")){
                    List<BankTransaction> listInYear = bankStatementProcessor.findAllTransactionsInYearOf(Integer.parseInt(yearChosen));
                    for(BankTransaction bankTransaction : listInYear){
                        System.out.println(bankTransaction.toString());
                    }
                    System.out.println("\nTOTAL TRANSACTIONS FOR THE YEAR OF " + yearChosen + ": ");
                    System.out.println(bankStatementProcessor.calculateTotalInYear(Integer.parseInt(yearChosen)));
                    System.out.println("\nTOTAL PAYMENT FOR THE YEAR OF " + yearChosen + ": " + bankStatementProcessor.totalExpensesForYear(Integer.parseInt(yearChosen)));
                    System.out.println(bankStatementProcessor.listPaymentsForYear(Integer.parseInt(yearChosen)));
                    System.out.println("\nTOTAL EXPENSES FOR THE YEAR OF " + yearChosen + ": " + bankStatementProcessor.totalPaymentsForYear(Integer.parseInt(yearChosen)));
                    System.out.println(bankStatementProcessor.listExpensesForYear(Integer.parseInt(yearChosen)));
                    System.out.println("Would you like to list transactions for a different year? Type Y or EXIT");
                    monthChosen = scan.nextLine();
                    if(monthChosen.equals("Y")){
                        System.out.println("Which year of transaction would you like to list?");
                        yearChosen = scan.nextLine();
                    }else{
                        yearChosen = "EXIT";
                    }
                }
                break;
            case "4":
                System.out.println("Which category would you like to calculate the total transaction for");
                String chosenCat = scan.nextLine();

                while(!chosenCat.equalsIgnoreCase("EXIT")){
                    List<BankTransaction> categoryList = bankStatementProcessor.listTransactionsForCategory(chosenCat);
                    for(BankTransaction bankTransaction : categoryList){
                        System.out.println(bankTransaction.toString());
                    }
                    System.out.println("Total for the category of " + chosenCat + ": " +  bankStatementProcessor.calculateTotalForCategory(chosenCat));
                    System.out.println("Would you like to list transactions for a different category? Type Y or EXIT");
                    chosenCat= scan.nextLine();
                    if(chosenCat.equals("Y")){
                        System.out.println("Which category of transaction would you like to list?");
                        chosenCat = scan.nextLine();
                    }else{
                        chosenCat = "EXIT";
                    }
                }
                break;
            default:
                System.out.println("Not a valid argument. Please choose from one of the following");
        }
    }


}
