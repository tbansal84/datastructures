package thoughtworks.problems.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Custom implementation of a BInary Min heap with additional operations viz.
 * decrease
 * 
 * @author tbansal
 *
 * @param <T>
 */
public class BinaryMinHeap<T extends HeapElement<T>> {

	private PriorityQueue<T> nodes = new PriorityQueue<>();
	private Map<String, T> vetices = new HashMap<>();

	public BinaryMinHeap(Collection<T> vertices) {
		super();
		nodes.addAll(vertices);
		for (T v : vertices) {
			vetices.put(v.getLabel(), v);
		}

	}

	/**
	 * Decrease the value for given vertex in heap
	 * 
	 * @param vertex
	 * @param value
	 */
	public synchronized void decrease(String vertex, Integer value) {
		T element = vetices.get(vertex);
		element.decrease(value);
		this.nodes.remove(element);
		this.nodes.add(element);

	}

	/**
	 * 
	 * Return true if vertext exists in heap
	 * 
	 * @param v
	 * @return
	 */
	public synchronized boolean contains(String v) {
		return vetices.containsKey(v);
	}

	/**
	 * return the vertext from heap
	 * 
	 * @return
	 */
	public synchronized T extract() {

		T t = nodes.poll();
		return t;
	}

	/**
	 * true if heap is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	/**
	 * 
	 * Return the weight for given vertex
	 * 
	 * @param vertex
	 * @return
	 */
	public int getWeight(String vertex) {
		return vetices.get(vertex).getDistance();
	}

}
