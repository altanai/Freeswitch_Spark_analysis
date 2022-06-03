import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogContextMapper extends Mapper<LongWritable, Text , Text, IntWritable> {

//    public static final IntWritable one = new IntWritable(1);
    public void map(LongWritable key , Text  value , Context context)
        throws IOException, InterruptedException{

        String line = value.toString();


//        LOG context
        if(line.contains("NOTICE")){
            context.write(new Text("NOTICE"), new IntWritable(1) );
        }

        if(line.contains("WARNING")){
            context.write(new Text("WARNING"), new IntWritable(2) );
        }

        if(line.contains("ERROR")){
            context.write(new Text("ERROR"), new IntWritable(3) );
        }

// Output of Mapper
//NOTICE	1
//NOTICE	1
//NOTICE	1
//NOTICE	1
//NOTICE	1
//WARNING	2
//WARNING	2
//WARNING	2
//WARNING	2
//WARNING	2
//WARNING	2
//WARNING	2


    }
}
