public class FlightParser {
    private String AirPortID;
    private int cancelled ;
    private static int ID = 14;
    private static int CANCELLED = 18;
    private static String STR_SPLIT = ",";


    public FlightParser(String str) {
        String[] words = str.split(STR_SPLIT);
        AirPortID = words[ID];
            cancelled = Integer.parseInt((words[CANCELLED].replace("\"","")));
    }

    public String getAirPortID() {
        return AirPortID;
    }

    public int getDayOFWeek() {
        return cancelled;
    }
}