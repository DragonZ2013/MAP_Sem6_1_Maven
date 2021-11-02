import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException, ParseException {
        List<Log> logList = LogParser.parseLogFile("logs.json");
        LogStatistics logStatistics = new LogStatistics(logList);
        logStatistics.showAll();
        System.out.println();
        logStatistics.showAfterSeverity();
        System.out.println();
        logStatistics.showLastTen();
    }
}
