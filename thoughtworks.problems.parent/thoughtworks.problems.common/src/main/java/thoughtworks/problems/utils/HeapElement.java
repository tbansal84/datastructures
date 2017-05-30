package thoughtworks.problems.utils;

/**
 * Element to be used in BinaryMinHeap
 * @author tbansal
 *
 * @param <T>
 */
public interface HeapElement<T> extends Comparable<T> {
	
	
	/**
	 * Decrease the distance to given integer
	 * @param i
	 */
	void decrease(Integer distance);
	
	/**
	 * Return the name for given station
	 * @return
	 */
	String getLabel();
	
	/**
	 * Return the distance for given element in heap
	 * @return
	 */
	Integer getDistance();

}
