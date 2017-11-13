
public class SortsCVS {

	private String name;
	private int index;
	private long duration;
	
	public SortsCVS(String name, int index, long duration) {
		this.name = name;
		this.index = index;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
}
