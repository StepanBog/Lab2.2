import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {
    private Text airoportName;
    private IntWritable num;

    public AirportKey() {
        this.airoportName = new Text();
        this.num = new IntWritable();
    }

    public AirportKey(String value, int num) {
        this.airoportName = new Text(value);
        this.num = new IntWritable(num);
    }

    @Override
    public int compareTo(AirportKey airoportKey) {
        int res  = airoportName.compareTo(airoportKey.airoportName);
        if (res == 0) {
            return this.num.compareTo(airoportKey.num);
        }
        return res;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        airoportName.write(dataOutput);
        num.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airoportName.readFields(dataInput);
        num.readFields(dataInput);
    }

    public Text getAiroportName() {
        return airoportName;
    }
}