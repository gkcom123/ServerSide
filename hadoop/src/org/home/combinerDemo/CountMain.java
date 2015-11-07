package org.home.combinerDemo;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CountMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException, 
	ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		      Configuration conf = new Configuration();
		      Job job = Job.getInstance(conf, "word count");
				
		      job.setJarByClass(CountMain.class);
		      job.setMapperClass(WordMapper.class);
		      job.setCombinerClass(ItemSumReducer.class);
		      job.setReducerClass(ItemSumReducer.class);
				
		      job.setOutputKeyClass(Text.class);
		      job.setOutputValueClass(IntWritable.class);
				
		      FileInputFormat.addInputPath(job, new Path(args[0]));
		      FileOutputFormat.setOutputPath(job, new Path(args[1]));
				
		      System.exit(job.waitForCompletion(true) ? 0 : 1);
		   }
	

}
