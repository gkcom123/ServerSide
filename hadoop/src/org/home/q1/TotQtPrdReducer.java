/**
 * 
 */
package org.home.q1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.log4j.Logger;

/**
 * @author gunjan.kumar
 *
 */
public class TotQtPrdReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
	private static final Logger logger = Logger.getLogger(TotQtPrdReducer.class);

	@Override
	public void reduce(Text key, Iterator<IntWritable> valuesForcurrentKey,
			OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		logger.info("Inside reducer");
		int sumsales=0;
		logger.info("First arg in reduce method:"+key);
		logger.info("size of second  arg in reduce method:"+valuesForcurrentKey.toString());
		//iterate over each row
		while(valuesForcurrentKey.hasNext())
		{
			
			IntWritable keyNValue=valuesForcurrentKey.next();
			Integer quant=keyNValue.get();
			logger.info("Inside while loop, product:quantity ="+key+":"+quant);
			sumsales=sumsales+quant;
		}
		logger.info("Last statement before writting to output file. Values are product "+key+"   and its quantity is "+sumsales);
		output.collect(key, new IntWritable(sumsales));

	}

}
