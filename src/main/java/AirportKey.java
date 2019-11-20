import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {
    private Text Day_Of_Week;
    private IntWritable AirPortID;

    public AirportKey() {
        this.Day_Of_Week = new Text();
        this.AirPortID = new IntWritable();
    }

    public AirportKey(String value, int num) {
        this.Day_Of_Week = new Text(value);
        this.AirPortID = new IntWritable(num);
    }

    public int compareTo(AirportKey airoportKey) {
        int res  = Day_Of_Week.compareTo(airoportKey.Day_Of_Week);
        if (res == 0) {
            return this.AirPortID.compareTo(airoportKey.AirPortID);
        }
        return res;
    }


    public void write(DataOutput dataOutput) throws IOException {
        Day_Of_Week.write(dataOutput);
        AirPortID.write(dataOutput);
    }


    public void readFields(DataInput dataInput) throws IOException {
        Day_Of_Week.readFields(dataInput);
        AirPortID.readFields(dataInput);
    }

    public Text getDay_Of_Week() {
        return Day_Of_Week;
    }
    public IntWritable getAirPortID(){
        return AirPortID;
    }
}
