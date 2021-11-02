import java.util.*;

public class LogStatistics {

    private List<Log> logList;

    public LogStatistics(List<Log> logList) {
        this.logList = logList;
    }

    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public void showAll(){
        for(Log i: logList)
            System.out.println(i.toString());
    }

    public void showAfterSeverity(){
        Collections.sort(logList);
        showAll();
    }

    public void showLastTen(){
        Date currentDate = new Date();
        for(Log i: logList){
            if(currentDate.getTime()-i.getTimeStamp().getTime()<10*24*60*60*1000)
                System.out.println(i.toString());

        }
    }

    public void showMostFrequent(){
        List<Log> sortedLogList = new ArrayList<>();
        for(Log i : logList){
            if(i.getSeverity()==Severity.SEVERE){
                sortedLogList.add(i);
            }
        }
        Map<String,Integer> occurances = new HashMap<>();
        for(Log i: sortedLogList){
            String message = i.getMessage().getText();
            if(occurances.containsKey(message))
                occurances.put(message,occurances.get(message)+1);
            else
                occurances.put(message,1);
        }
    }
}
