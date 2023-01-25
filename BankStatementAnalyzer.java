import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final BankStatementCSVParser BANK_STATEMENT_CSV_PARSER = new BankStatementCSVParser();


    public List<BankTransaction> analyze(final BankStatementParser bankStatementParser, String resources) throws IOException {
        final Path path = Paths.get(resources);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);


        return bankTransactions;
    }


}
