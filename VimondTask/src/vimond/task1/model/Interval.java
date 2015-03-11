
package vimond.task1.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.IntRange;


public  class Interval  {
	
	List<IntRange> include_interval;
	List<IntRange> exclude_interval;
	
	
	public List<IntRange> getInclude_interval() {
		return include_interval;
	}

	public Interval()
	{
		include_interval = new ArrayList<IntRange>();
		exclude_interval = new ArrayList<IntRange>();
	}

	public void setInclude_interval(List<Range> rangeList) {
	for(int i=0;i<rangeList.size(); i++)
		include_interval.add(new IntRange(rangeList.get(i).getStart(), rangeList.get(i).getEnd()));
	
	}



	public List<IntRange> getExclude_interval() {
		return exclude_interval;
	}


	public void setExclude_interval(List<Range> rangeList) {
		
		for(int i=0;i<rangeList.size(); i++ )
			exclude_interval.add(new IntRange(rangeList.get(i).getStart(), rangeList.get(i).getEnd()));
		
	}

	

	
	

}
