import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class QuarterPartitioner<K2, V2> extends Partitioner<Text, Text> implements Configurable {

    private Configuration configuration;

    @Override
    public void setConf(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConf() {
        return configuration;
    }

    @Override
    public int getPartition(Text key, Text value, int numReduceTasks) {
        if(Integer.parseInt(String.valueOf(value))<=15) return 1;
        else if ( Integer.parseInt(String.valueOf(value))<=30) return 2;
        else if ( Integer.parseInt(String.valueOf(value))<=30) return 2;
        else return 4;
    }
}
