import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {

    public AirportComparator() {

        super(AirportKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        AirportKey a1 = (AirportKey)a;
        AirportKey b1 = (AirportKey)b;
        return a1.getAirportID().compareTo(b1.getAirportID());
    }
}