import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BankTransaction{
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction (final LocalDate date, final double amount, final String description){
        this.date = date;
        this.amount = amount;
        this.description = description;

    }

    public LocalDate getDate(){
        return date;
    }

    public double getAmount(){
        return amount;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "BankTransaction {" + "date=" + date + ", amount=" + amount + ", description=' "+description+'\''+'}';
    }

    public boolean equals(Object o){
        if(this == o)return true;
        if(o==null|| getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
    }

    public int hashCode(){
        return Objects.hash(date, amount, description);
    }

}
