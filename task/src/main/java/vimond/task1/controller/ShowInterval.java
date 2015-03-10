package vimond.task1.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.IntRange;

import vimond.task1.model.Range;


public class ShowInterval 
{

    public static void main( String[] args )
    {
    	List<Range> rangeList = new ArrayList<Range>(); 
         
    	ServiceImpl imp = new ServiceImpl();
    	
    	rangeList.add(new Range(10,100));
    	rangeList.add(new Range(200,300));
    	rangeList.add(new Range(400,500));
    	
    	imp.sortRangeList(rangeList);
   
    	List<IntRange> inclu_interval_list = new ArrayList<IntRange>(); 
        
        imp.setIncludeIntervalList(rangeList, inclu_interval_list);
        
    
        List<IntRange> exclu_interval_list = new ArrayList<IntRange>(); 
        exclu_interval_list.add(new IntRange(95,205));
        exclu_interval_list.add(new IntRange(410,420));
        
        List<IntRange> out_interval_list = new ArrayList<IntRange>(); 
        if(inclu_interval_list.size() > 0)
        {
        	
        	if(exclu_interval_list.size() == 0)
        		out_interval_list.add(new IntRange(inclu_interval_list.get(0).getMinimumInteger(), inclu_interval_list.get(inclu_interval_list.size()-1).getMaximumInteger()));
        	
	        for(int i=0;i<inclu_interval_list.size();i++)
	        {
	        	for(int j=0;j<exclu_interval_list.size();j++)
	        	{
	        		
	        		if(inclu_interval_list.get(i).containsNumber(exclu_interval_list.get(j).getMinimumInteger()))
	        			out_interval_list.add(new IntRange(inclu_interval_list.get(i).getMinimumInteger(),exclu_interval_list.get(j).getMinimumInteger()-1));
	        		
	        		if(inclu_interval_list.get(i).containsNumber(exclu_interval_list.get(j).getMaximumInteger()))
	        			out_interval_list.add(new IntRange(exclu_interval_list.get(j).getMaximumInteger()+1 , inclu_interval_list.get(i).getMaximumInteger()));
	        	}
	        	
	        	
	        	
	        }
	        
	        for(int i=0;i<out_interval_list.size();i++)
	        {
	        	System.out.println(out_interval_list.get(i).toString());
	        }
	        
        }
        
    }
}
