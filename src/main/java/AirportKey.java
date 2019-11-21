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
        this.AirportID = new Text();
        this.num = new IntWritable();
    }

    public AirportKey(String value, int num) {
        this.AirportID = new Text(value);
        this.num = new IntWritable(num);
    }

    public int compareTo(AirportKey airoportKey) {
        int res  = AirportID.compareTo(airoportKey.AirportID;
        if (res == 0) {
            return this.num.compareTo(airoportKey.num);
        }
        return res;
    }


    public void write(DataOutput dataOutput) throws IOException {
        AirportID.write(dataOutput);
        num.write(dataOutput);
    }


    public void readFields(DataInput dataInput) throws IOException {
        AirportID.readFields(dataInput);
        num.readFields(dataInput);
    }

    public Text getAirportID() {
        return AirportID;
    }
}
