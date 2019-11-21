public class AirportParser {
    private String airportID;
    private String airporName;
    private static int AIRPORPID = 0;
    private static int AIRPORTNAME = 1;
    private static String STRSPLIT = ",[\"]";


    public AirportParser(String str) {
        String[] words = str.split(STRSPLIT);
        airportID = words[AIRPORPID].replace("\"","");
        airporName = words[AIRPORTNAME].replace("\"","");
    }

    public String getAiroportID() {
        return airportID;
    }

    public String getAiroporName() {
        return airporName;
    }
}  