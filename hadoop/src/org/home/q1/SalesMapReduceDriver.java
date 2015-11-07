/**
 * 
 */
package org.home.q1;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.log4j.Logger;

/**
 * @author gunjan.kumar
 *
 */
public class SalesMapReduceDriver {
	private static final Logger logger = Logger.getLogger(SalesMapReduceDriver.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("The drive class");
		JobConf jobConf=new JobConf(SalesMapReduceDriver.class);
		jobConf.setJobName("Product and sales");
		logger.info("Adding input/outpath");
		FileInputFormat.addInputPath(jobConf, new Path(args[0]));
		FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));
		logger.info("Setting mapper/Reducer");
		//Find total units(quantity) sold for each product
		jobConf.setMapperClass(TotQtPrdMapper.class);
		jobConf.setReducerClass(TotQtPrdReducer.class);
		//--------------------------------
		//Find total units(quantity) sold for each  store and product 
		logger.info("Setting key/value");
		jobConf.setOutputKeyClass(Text.class);
		jobConf.setOutputValueClass(IntWritable.class);
		
		
		try {
			JobClient.runJob(jobConf);
		}catch (IOException e) 
		{
			e.printStackTrace();
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		logger.info("We are good. If you are seeing this check at "+args[1]);

	}

}
