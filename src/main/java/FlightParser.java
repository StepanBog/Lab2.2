
public class FlightParser {
    private static int DAYOFWEEK = 4;
    private String AirPortID;
    private long cancelled = 0;
    private String DW = "";
    private static int FLIGHT = 10;
    private static int CANCELLED = 19;
    private static String STR_SPLIT = ",";


    public FlightParser(String str) {
        String[] words = str.split(STR_SPLIT);
        AirPortID = words[FLIGHT];
        DW = words[DAYOFWEEK];
        if (!words[CANCELLED].isEmpty()) {
            cancelled = (long)Double.parseDouble((words[CANCELLED].replace("\"","")));
        }
    }

    public String getFlightID() {
        return AirPortID;
    }

    public long getCancelled() {
        return cancelled;
    }
    public String getDW(){
        return DW;
    }
}