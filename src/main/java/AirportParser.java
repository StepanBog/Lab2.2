public class AirportParser {
    private String DayOFWeek;
    private int cancelled ;
    private static int DOW = 4;
    private static int CANCELLED = 19;
    private static String STR_SPLIT = ",";


    public AirportParser(String str) {
        String[] words = str.split(STR_SPLIT);
        DayOFWeek = words[DOW];
        cancelled = Integer.parseInt((words[CANCELLED].replace("\"","")));
    }

    public String getDayOFWeek() {
        return DayOFWeek;
    }

    public int getCancelled() {
        return cancelled;
    }
}