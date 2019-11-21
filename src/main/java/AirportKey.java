import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {

    private IntWritable num;
    private Text AirportID;

    public AirportKey() {
        this.Day_Of_Week = new Text();
        this.num = new IntWritable();
    }

    public AirportKey(String value, int num) {
        this.Day_Of_Week = new Text(value);
        this.num = new IntWritable(num);
    }

    public int compareTo(AirportKey airoportKey) {
        int res  = Day_Of_Week.compareTo(airoportKey.Day_Of_Week);
        if (res == 0) {
            return this.num.compareTo(airoportKey.num);
        }
        return res;
    }
 

    public void write(DataOutput dataOutput) throws IOException {
        Day_Of_Week.write(dataOutput);
        num.write(dataOutput);
    }


    public void readFields(DataInput dataInput) throws IOException {
        Day_Of_Week.readFields(dataInput);
        num.readFields(dataInput);
    }

    public Text getAirportID() {
        return AirportID;
    }
}
