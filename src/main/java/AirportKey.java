import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {
    private Text DayOFWeek;
    private IntWritable num;

    public AirportKey() {
        this.DayOFWeek = new Text();
        this.num = new IntWritable();
    }

    public AirportKey(String value, int num) {
        this.DayOFWeek = new Text(value);
        this.num = new IntWritable(num);
    }

    @Override
    public int compareTo(AirportKey airoportKey) {
        int res  = DayOFWeek.compareTo(airoportKey.DayOFWeek);
        if (res == 0) {
            return this.num.compareTo(airoportKey.num);
        }
        return res;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        DayOFWeek.write(dataOutput);
        num.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        DayOFWeek.readFields(dataInput);
        num.readFields(dataInput);
    }

    public Text getAiroportName() {
        return DayOFWeek;
    }
}