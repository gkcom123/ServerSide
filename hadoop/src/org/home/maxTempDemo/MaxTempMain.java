package org.home.maxTempDemo;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTempMain {

	public MaxTempMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		//output will be generated here
		//Users/administrator/Gunjan/EclipseWS/MaxTemprature/output87
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("Usage: MaxTemperature <input path> <output path>"); 
			System.exit(-1);
			} 
			Job job = Job.getInstance();
			job.setJarByClass(MaxTempMain.class);
			job.setJobName("Max temperature ");
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			job.setMapperClass(MaxTempMapper.class);
			job.setReducerClass(MaxTempReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}
