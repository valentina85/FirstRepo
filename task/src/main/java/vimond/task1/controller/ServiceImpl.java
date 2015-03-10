package vimond.task1.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.math.IntRange;

import vimond.task1.model.Range;

public class ServiceImpl {
	
	
	
	public void sortRangeList(List<Range> rangeList)
	{
		Collections.sort(rangeList); 
	}
	
	public void setIncludeIntervalList(List<Range> rangeList, List<IntRange> includeIntervalList)
	{
		
		for(Range range : rangeList )
			includeIntervalList.add(new IntRange(range.getStart(), range.getEnd()));
		
	}

	public void setExcludeIntervalList(List<Range> rangeList, List<IntRange> excludeIntervalList)
	{
		
		for(Range range : rangeList )
			excludeIntervalList.add(new IntRange(range.getStart(), range.getEnd()));
		
	}
	


}
