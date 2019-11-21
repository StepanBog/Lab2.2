import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;

import java.io.IOException;


public class FlightMapper extends Mapper<LongWritable, Text, AirportKey, Text> {
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get()  == 0) {
            return;
        }
        FlightParser flightParser = new FlightParser(value.toString());

        long delTime = flightParser.getDelayTime();

        if (delTime >  0) {
            context.write(new AirportKey(flightParser.getFlightID(), 1), new Text(flightParser.getAirPortID()));
        }
    }
}