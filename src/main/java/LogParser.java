import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogParser {

    public static List<Log> parseLogFile(String path) throws IOException, ParseException {
        Reader reader = new BufferedReader(new FileReader(path));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parser = objectMapper.readTree(reader);
        List<Log> logList = new ArrayList<>();
        for (JsonNode iterator:parser){
            String timestamp = iterator.path("timestamp").asText();
            Date timestampdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timestamp);
            String text = iterator.path("message").path("text").asText();
            String file = iterator.path("message").path("file").asText();
            String severity = iterator.path("severity").asText();
            Severity severity1 = Severity.valueOf(severity);
            List<String> visibility = new ArrayList<>();
            for(JsonNode s : iterator.path("visibility")){
                visibility.add(s.asText());
            }
            Log log = new Log(timestampdate,visibility ,severity1,new Message(text,file));
            logList.add(log);
        }
        return logList;

    }
}
