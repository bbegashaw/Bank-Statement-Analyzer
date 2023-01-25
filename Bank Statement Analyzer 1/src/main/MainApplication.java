import java.io.IOException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {

        final BankStatementUserInputHandler bankStatementUserInputHandler = new BankStatementUserInputHandler();

        bankStatementUserInputHandler.startInteraction();

    }
}
