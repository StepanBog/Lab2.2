import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer <AirportKey, Text,Text, Text> {
    public void reduce(AirportKey key, Iterable<Text> text, Context context) throws IOException, InterruptedException {
        Iterator<Text> it = text.iterator();
        String airportName = it.next().toString();
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int middleTime = 0;
        int count = 0;
        while (it.hasNext()) {
            String Time = it.next().toString();
            int time = Integer.parseInt(Time);
            maxTime = Math.max(time,maxTime);
            minTime = Math.min(time,minTime);
            count++;
            middleTime += time;
        }

        if (count > 0 )
            middleTime /= count;
        else
            return;
        context.write(new Text(airportName), new Text("Average time = " + middleTime + " Max time = " + maxTime + " Min time = " + minTime));

    }
}
