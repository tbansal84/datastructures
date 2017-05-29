package thoughtworks.problems.utils;

public interface HeapElement<T> extends Comparable<T> {
	
	
	void decrease(Integer i);
	
	String getLabel();
	
	Integer getDistance();

}
