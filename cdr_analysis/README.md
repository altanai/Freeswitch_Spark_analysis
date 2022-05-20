# Call Data Record(CDR) Analytics

Hadoop MapReduce program to analyze Call data records.

Telecom company uses Call detail records for its subscribers to store their calls logs.
In this sample the records are in format

    FromPhoneNumber|ToPhoneNumber|CallStartTime|CallEndTime|STDFlag

example 

    9665128505|8983006310|2015-03-01 09:08:10|2015-03-01 10:12:15|1

If STD Flag is 1 that means it was as STD( long distance) Call.

Map Reduce to find out all phone numbers who are making more than 30 mins of STD calls.
By identifying such subscribers, telecom company wants to offer them STD (Long Distance) Pack which would 
efficient for them instead spending more money without that package.

## TBD

output is blank 
work in progress 
