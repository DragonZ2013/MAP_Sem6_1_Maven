import java.util.Date;
import java.util.List;

public class Log implements Comparable<Log>{
    private Date timeStamp;
    private List<String> visibility;
    private Severity severity;
    private Message message;

    public Log(Date timeStamp, List<String> visibility, Severity severity, Message message) {
        this.timeStamp = timeStamp;
        this.visibility = visibility;
        this.severity = severity;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getVisibility() {
        return visibility;
    }

    public void setVisibility(List<String> visibility) {
        this.visibility = visibility;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" +
                "timeStamp=" + timeStamp +
                ", visibility=" + visibility +
                ", severity=" + severity +
                ", message=" + message.toString() +
                '}';
    }

    @Override
    public int compareTo(Log o) {
        return severity.compareTo(o.getSeverity());
    }
}
