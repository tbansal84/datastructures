package thoughtworks.problems.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BinaryMinHeap<T extends HeapElement<T>> {

	private PriorityQueue<T> nodes = new PriorityQueue<>();
	private Map<String, T> verticesMap = new HashMap<>();

	public BinaryMinHeap(Collection<T> vertices) {
		super();
		nodes.addAll(vertices);
		for (T v : vertices) {
			verticesMap.put(v.getLabel(), v);
		}

	}

	public synchronized void decrease(String vertex, Integer value) {
		T element = verticesMap.get(vertex);
		element.decrease(value);
		this.nodes.remove(element);
		this.nodes.add(element);

	}

	public synchronized boolean contains(String v) {
		return verticesMap.containsKey(v);
	}

	public synchronized T extract() {

		T t = nodes.poll();
//		if (t != null) {
//			verticesMap.remove(t.getLabel());
//		}
		return t;
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public int getWeight(String vertex) {
		return verticesMap.get(vertex).getDistance();
	}

}
