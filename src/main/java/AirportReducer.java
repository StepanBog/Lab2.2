import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer <AirportKey, Text,Text, Text> {
    public void reduce(AirportKey key, Iterable<Text> text, Context context) throws IOException, InterruptedException {
        Iterator<Text> it = text.iterator();
        String airportName = it.next().toString();
        String Time = "";
        while (it.hasNext()) {
            Time += it.next().toString() + " ";

        }
        context.write(new Text(airportName), new Text(Time));

    }
}
