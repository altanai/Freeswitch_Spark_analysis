import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeswitchLogMapper extends Mapper<LongWritable, Text, Text, Text> {

    // Freeswitch log sample
// Callid date timestamp [context] message
// 358a53fe-a151-11ea-88d1-a9b259b5d941 2020-05-29 07:37:55.083745 [DEBUG] switch_core_media.c:5592 Audio Codec Compare [pcmu:0:8000:20:64000:1]/[opus:116:48000:20:0:1]

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] fields = value.toString().split(" ");

        if (fields.length > 3) {

            String callid = fields[0]; // Save the first field 0 which is the callid
//            if (!fields[1].equals("EXECUTE") && fields[2].indexOf(":")>0){
            String[] dtFields = fields[2].split(":"); // field 1 is date , field 2 is time. Split time :
            if (dtFields.length > 3) {
                String minute = dtFields[1]; // middle is the minute
                context.write(new Text(callid), new Text(minute));
            }
        }
    }
}
