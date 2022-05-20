import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallRecordMapper extends Mapper<Object, Text, Text, LongWritable> {
    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] parts = value.toString().split("[|]");

        //   0 FromPhoneNumber
        //   1 ToPhoneNumber
        //   2 CallStartTime
        //   3 CallEndTime
        //   4 STDFlag

        if (parts[4].equalsIgnoreCase("1")) { // 4 th index is for the STD flag
            Text phonenumer = new Text(parts[0]);
            long duration = (convertMiliseconds(parts[3]) - convertMiliseconds(parts[2])) / (1000 * 60);
            LongWritable durationMin = new LongWritable(duration);
            context.write(phonenumer, durationMin);
        }
    }

    private long convertMiliseconds(String timestamp) {
        Date date = null;
        try {
            date = DATE_FORMAT.parse(timestamp);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }


    }
}
