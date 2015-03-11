package vimond.task1.controller;

import java.io.Console;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.IntRange;

import vimond.task1.model.Interval;
import vimond.task1.model.Range;



public class ServletController extends HttpServlet  {


	private static final long serialVersionUID = 1L;

	public  ServletController() {
		// TODO Auto-generated constructor stub
	}
	
	 public void init() throws ServletException
	  {
		
	  }


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter( );
		List<IntRange> out_interval_list = new ArrayList<IntRange>(); 
		Interval interval = new Interval();
		
		// Get the input inclusive interval and add it in a list   
		interval = setAndGetInclusiveInterval(req,resp,interval);
		
		// Get the input exclude interval and add it in a list  
		interval = setAndGetExcludeInterval(req, resp,interval);
		
		//rearrange the intervals by removing exclude intervals
		calculateInterval(interval.getInclude_interval(), interval.getExclude_interval(), out_interval_list);
		
		//Prints the output
		out.println("<br><b><i>Output Interval...........</i></b><br>");
		printInterval(resp, out_interval_list);
	}
	
	

	public Interval setAndGetInclusiveInterval(HttpServletRequest req, HttpServletResponse resp,
			Interval interval) throws IOException,ServletException
	{
		PrintWriter out = resp.getWriter( ); 
		List<Range> rangeList = new ArrayList<Range>();
		String[] inInterval = (req.getParameter("inclusiveInterval").toString()).split(",");
		for(int i=0;i<inInterval.length;i++)
		{
			Range range = new Range();
			range.setStart(new Integer(inInterval[i].split("-")[0].toString()).intValue());
			range.setEnd(new Integer(inInterval[i].split("-")[1].toString()).intValue());
			rangeList.add(range);
		}
		
		sortRangeList(rangeList);
		interval.setInclude_interval(rangeList);
		out.println("<br><i>Include Interval...........</i><br>");
		printInterval(resp, interval.getInclude_interval());
	    return interval;
	}
	
	public Interval setAndGetExcludeInterval(HttpServletRequest req, HttpServletResponse resp,
			Interval interval) throws IOException,ServletException
	{
		PrintWriter out = resp.getWriter( ); 
		List<Range> rangeList = new ArrayList<Range>();
		if(!req.getParameter("exclusiveInterval").toString().isEmpty())
		{
			String[] inInterval = (req.getParameter("exclusiveInterval").toString()).split(",");
			for(int i=0;i<inInterval.length;i++)
			{
				Range range = new Range();
				range.setStart(new Integer(inInterval[i].split("-")[0].toString()).intValue());
				range.setEnd(new Integer(inInterval[i].split("-")[1].toString()).intValue());
				rangeList.add(range);
			}
		
			sortRangeList(rangeList);
			interval.setExclude_interval(rangeList);
			out.println("<br><i>Exclude Interval...........</i><br>");
			printInterval(resp, interval.getExclude_interval());
			return interval;
		}
		else
			return interval;
	}
	
	public List<IntRange> calculateInterval(List<IntRange> inclu_interval_list,List<IntRange> exclu_interval_list,List<IntRange> out_interval_list){
		
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
		    }
	       return out_interval_list; 
		
	}
	
	public void sortRangeList(List<Range> rangeList)
	{
		Collections.sort(rangeList); 
	}
	
	public void printInterval(HttpServletResponse response, List<IntRange> out_interval_list) throws IOException {
		
		PrintWriter out = response.getWriter( ); 
		for(int i=0;i<out_interval_list.size();i++)
        {
			
        	out.println(out_interval_list.get(i).toString());
        	out.println();
        }
        
	}
	
	
}
