
package vimond.task1.model;

import java.util.List;

import org.apache.commons.lang.math.IntRange;


public  class Interval  {
	
	List<IntRange> include_interval;
	List<IntRange> exclude_interval;
	
	
	public List<IntRange> getInclude_interval() {
		return include_interval;
	}


	public void setInclude_interval(List<IntRange> include_interval) {
		this.include_interval = include_interval;
	}


	public List<IntRange> getExclude_interval() {
		return exclude_interval;
	}


	public void setExclude_interval(List<IntRange> exclude_interval) {
		this.exclude_interval = exclude_interval;
	}


	
	

}
