package org.home.q1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.log4j.Logger;

public class TotQtPrdMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	private static final Logger logger = Logger.getLogger(TotQtPrdMapper.class);	
	@Override
	public void map(LongWritable arg0, Text value,
			OutputCollector<Text, IntWritable> outputWriter, Reporter arg3)
			throws IOException {
		logger.info("Mapper Started ");
		logger.info("Map method argument:"+arg0);
		String line = value.toString();
		logger.info("Input String is "+line);
		String[] values= line.split(",");
		logger.info("product and quantity are "+values[0] +":"+values[2]);
		int quantity =0;
		if(null != values[2] && values[2].length() >0)//possible file is corrupt, 
			quantity=Integer.parseInt(values[2]);
		outputWriter.collect(new Text(values[0]), new IntWritable(quantity));
		logger.info("Mapper job done");
	}
}
