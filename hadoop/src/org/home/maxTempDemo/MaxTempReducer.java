package org.home.maxTempDemo;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	/* (non-Javadoc)
	 * @see org.apache.hadoop.mapreduce.Reducer#reduce(java.lang.Object, java.lang.Iterable, org.apache.hadoop.mapreduce.Reducer.Context)
	 */
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 int maxValue = Integer.MIN_VALUE;
		 
         for (IntWritable value : values) {
        	 System.out.println("Key->"+key+",value-"+value);
           maxValue = Math.max(maxValue, value.get());
         }
         context.write(key, new IntWritable(maxValue));
	}

}
