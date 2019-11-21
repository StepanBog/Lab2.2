public class AirportParser {
    private int DayOFWeek;
    private int cancelled ;
    private static int DOW = 4;
    private static int CANCELLED = 19;
    private static String STR_SPLIT = ",";


    public AirportParser(String str) {
        String[] words = str.split(STR_SPLIT);
        DayOFWeek = Integer.parseInt(words[DOW].replace("\"",""));
        cancelled = Integer.parseInt((words[CANCELLED].replace("\"","")));
    }

    public int getDayOFWeek() {
        return DayOFWeek;
    }

    public int getCancelled() {
        return cancelled;
    }
}