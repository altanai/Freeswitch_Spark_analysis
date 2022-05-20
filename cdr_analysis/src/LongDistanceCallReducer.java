import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class LongDistanceCallReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        long mins_sum = 0;
        for (LongWritable val : values) {
            mins_sum += val.get();
        }
        if (mins_sum >= 60) {
            LongWritable result = new LongWritable(mins_sum);
            // emit(key, result)
            context.write(key, result);
        }
    }
}
