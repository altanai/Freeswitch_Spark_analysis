# Log Analysis 

## FS Log 

     hadoop fs -put  FS_logs  /fslogs

## WebLog 

    hadoop fs -mkdir  /loudacre
    hadoop fs -put weblogs  /loudacre/   

See some of the files 

    hadoop  fs  -cat  /loudacre/weblogs/2014-03-15.log    

check 

    (base) C:\Users\abisht>hdfs dfs -ls /loudacre
    Found 1 items
    drwxr-xr-x   - abisht supergroup          0 2022-05-05 23:20 /loudacre/weblogs
    
    (base) C:\Users\abisht>hdfs dfs -ls /loudacre/weblogs
    Found 182 items
    -rw-r--r--   1 abisht supergroup     521343 2022-05-05 23:20 /loudacre/weblogs/2013-09-15.log
    -rw-r--r--   1 abisht supergroup     484079 2022-05-05 23:20 /loudacre/weblogs/2013-09-16.log
    -rw-r--r--   1 abisht supergroup     527399 2022-05-05 23:20 /loudacre/weblogs/2013-09-17.log
    ......




## Change the java JDK form terminal from anaconda 


    set JAVA_HOME=C:\Users\abisht\.jdks\corretto-11.0.15
    set Path=%JAVA_HOME%\bin;%Path%

Before 

    (base) C:\Users\abisht>java -version
    java version "1.8.0_25"
    Java(TM) SE Runtime Environment (build 1.8.0_25-b18)
    Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)

After 

    (base) C:\Users\abisht>java -version
    openjdk version "11.0.15" 2022-04-19 LTS
    OpenJDK Runtime Environment Corretto-11.0.15.9.1 (build 11.0.15+9-LTS)
    OpenJDK 64-Bit Server VM Corretto-11.0.15.9.1 (build 11.0.15+9-LTS, mixed mode)


## Debugging and Help 

**Issue1** NAme node shutting down with error as- node is not formatted 

    2022-05-05 20:20:16,128 ERROR namenode.NameNode: Failed to start namenode.java.io.IOException: NameNode is not formatted.
        at org.apache.hadoop.hdfs.server.namenode.FSImage.recoverTransitionRead(FSImage.java:252)

**Solution** Well lets format it then 

     hadoop namenode -format

**Issue 2** Mismatch of cluster ID in data node and name node 

    2022-05-05 20:23:10,539 WARN common.Storage: Failed to add storage directory [DISK]file:/C:/USers/abisht/big-data/data/dfs/data
    java.io.IOException: Incompatible clusterIDs in C:\Users\abisht\big-data\data\dfs\data: namenode clusterID = CID-30c92416-784c-40d2-9bcd-c2cac0a03c49; datanode clusterID = CID-2e525202-6309-48b4-8ec1-5e0f9154be27

**Solution** Format name node and also format the data node while we are at it

    hadoop namenode -format
    hdfs datanode -format


**Issue 5** RDD collect throws IPPub data rate exceeded error

    IOPub data rate exceeded.
    The notebook server will temporarily stop sending output
    to the client in order to avoid crashing it.
    To change this limit, set the config variable
    `--NotebookApp.iopub_data_rate_limit`.
    
    Current values:
    NotebookApp.iopub_data_rate_limit=1000000.0 (bytes/sec)
    NotebookApp.rate_limit_window=3.0 (secs)


**Solution**



Ref : 
- https://stackoverflow.com/questions/61530874/docker-how-do-i-add-myself-to-the-docker-users-group-on-windows-10-home
- https://icij.gitbook.io/datashare/faq-errors/you-are-not-allowed-to-use-docker-you-must-be-in-the-docker-users-group-.-what-should-i-do
