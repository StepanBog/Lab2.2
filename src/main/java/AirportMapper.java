import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;

import java.io.IOException;


public class AirportMapper extends Mapper<LongWritable, Text, AirportKey, Text> {
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }
        AirportParser airoportParser = new AirportParser(value.toString());

        context.write(new AirportKey(Integer.toString(airoportParser.getDayOFWeek()), 0), new Text(Integer.toString(airoportParser.getCancelled())));
    }
}