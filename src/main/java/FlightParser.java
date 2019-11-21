public class FlightParser {
    private String AirPortID;
    private int DayOFWEEK ;
    private static int ID = 11;
    private static int DOW = 4;
    private static String STR_SPLIT = ",";


    public FlightParser(String str) {
        String[] words = str.split(STR_SPLIT);
        AirPortID = words[ID];
            DayOFWEEK = Integer.parseInt((words[DOW].replace("\"","")));
    }

    public String getAirPortID() {
        return AirPortID;
    }

    public int getDayOFWeek() {
        return DayOFWEEK;
    }
}