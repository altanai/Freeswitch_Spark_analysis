import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FreeswitchCountReducer  extends Reducer<Text, Text, Text, IntWritable> {

    public void reduce(Text key, Iterable<Text> values, Reducer.Context context)
            throws IOException, InterruptedException {

        int count = 0;

        for (Text value : values) {
            count++; //for each item in the list, increment the count
        }

        context.write(key, new IntWritable(count));
    }
}
