import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class LogContextCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public final static IntWritable counter = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        Iterator<IntWritable> iter = values.iterator();
        int counts = 0;
        while (iter.hasNext()) {
            counts += iter.next().get();
        }
        counter.set(counts);
        context.write(key, counter);

//        Test to see intermediate results
//        for(IntWritable val:values){
//            String logctx= val.toString();
//            context.write(key, new IntWritable(Integer.parseInt(logctx)));
//        }
    }
}
