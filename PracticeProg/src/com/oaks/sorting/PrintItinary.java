package com.oaks.sorting;

import java.util.HashMap;
import java.util.Map;

public class PrintItinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> ticketMap = new HashMap<String, String>();
		ticketMap.put("Chennai", "Bangalore");
		ticketMap.put("Bombay", "Delhi");
		ticketMap.put("Goa", "Chennai");
		ticketMap.put("Delhi", "Goa");
		new PrintItinary().printItinary(ticketMap);

	}
	private void printItinary(Map<String, String> dataSet)
	{
		String startingPoint = null;
		Map<String,String> reverserDataSet = new HashMap<String, String>();
		for(Map.Entry<String, String> entry:dataSet.entrySet())
		{
			reverserDataSet.put(entry.getValue(), entry.getKey());
		}
		for(Map.Entry<String, String> entry:dataSet.entrySet())
		{
			if(!reverserDataSet.containsKey(entry.getKey()))
			{
				startingPoint = entry.getKey();
				break;
			}
		}
		if(startingPoint==null)
		{
			System.out.println("Invalid Entry");
			return;
		}
		String to = dataSet.get(startingPoint);
		while(to!=null)
		{
			System.out.print(startingPoint +  "->" + to + ", ");
			startingPoint =to;
			to = dataSet.get(startingPoint);
		}
	}

}
