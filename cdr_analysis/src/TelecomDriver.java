import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.conf.Configuration;
//
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TelecomDriver {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: TelecomDriver <input> <output>");
            System.exit(2);
        }
        String inputPath = args[0];
        String outputPath = args[1];

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "telecom");
        job.setJarByClass(TelecomDriver.class);

        job.setMapperClass(CallRecordMapper.class);
        job.setCombinerClass(LongDistanceCallReducer.class);
        job.setReducerClass(LongDistanceCallReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}