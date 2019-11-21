
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MultiFileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Lab2{
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        Configuration conf = new Configuration();
        job.setJarByClass(Lab2.class);
        job.setJobName("Lab2.2");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class,AirportMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class,FlightMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        Path outputPath = new Path(args[2]);

        job.setPartitionerClass(AirportPartitioner.class);
        job.setGroupingComparatorClass(AirportComparator.class);
        job.setReducerClass(AirportReducer.class);
        job.setMapOutputKeyClass(AirportKey.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        outputPath.getFileSystem(conf);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}