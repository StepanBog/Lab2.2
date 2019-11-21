import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;

import java.io.IOException;


public class AirportMapper extends Mapper<LongWritable, Text, AirportKey, Text> {
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get()  == 0) {
            return;
        }
        FlightParser flightParser = new FlightParser(value.toString());

        long cancelledCount = flightParser.getCancelled();
            context.write(new AirportKey(flightParser.getDW(), 0), new Text(flightParser.getAirPortID()));
    }
}