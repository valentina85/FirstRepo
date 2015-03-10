package vimond.task1.model;

public class Range implements Comparable<Range> {
	
	int start;
	int end;
	
	public Range(){}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Range(int start,int end)
	{
		this.start = start;
		this.end = end;
	}

	public int compareTo(Range o) {
		// TODO Auto-generated method stub
		return start - o.start;
	}
	
	
	@Override
    public String toString() {
        return String.format("[%d,%d]", start, end);
    }

}
