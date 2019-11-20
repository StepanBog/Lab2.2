import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {
    private Text Day_Of_Week;
    private int AirPortID;

    public AirportKey() {
        this.Day_Of_Week = new Text();
        this.AirPortID = 0;
    }

    public AirportKey(String value, int num) {
        this.Day_Of_Week = new Text(value);
        this.AirPortID = num;
    }



    public void write(DataOutput dataOutput) throws IOException {
        airoportName.write(dataOutput);
        num.write(dataOutput);
    }


    public void readFields(DataInput dataInput) throws IOException {
        airoportName.readFields(dataInput);
        num.readFields(dataInput);
    }

    public Text getAiroportName() {
        return airoportName;
    }

    public int compareTo(AirportKey airportKey) {
        return 0;
    }
}