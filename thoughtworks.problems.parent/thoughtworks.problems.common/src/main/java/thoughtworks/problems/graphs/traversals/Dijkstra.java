package thoughtworks.problems.graphs.traversals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Edge;
import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.utils.BinaryMinHeap;

public class Dijkstra {

	public Map<Station, Integer> shortestPath(CityMap graph, Station sourceStation, Map<Station, Integer> distance,
			Map<Station, Station> parent) {
		getTowns(graph.vertices(), sourceStation);

		BinaryMinHeap<Station> minHeap = new BinaryMinHeap<>(graph.vertices());

		minHeap.decrease(sourceStation.getLabel(), 0);

		distance.put(sourceStation, 0);

		parent.put(sourceStation, sourceStation);

		while (!minHeap.isEmpty()) {
			Station current = minHeap.extract();
			distance.put(current, current.getDistance());

			if (current.equals(sourceStation) && !current.equals(parent.get(sourceStation))) {
				 break;
			}

			for (Edge edge : current.getNeighbors()) {

				Station neighbour = edge.getTwo();
				int newDistance = distance.get(current) + edge.getWeight();
				System.out.println(neighbour.getLabel());
				if (minHeap.getWeight(neighbour.getLabel()) > newDistance||neighbour.equals(parent.get(neighbour))) {
					minHeap.decrease(neighbour.getLabel(), newDistance);
					parent.put(neighbour, current);
				}
			}
		}
		return distance;
	}

	private void getTowns(Collection<Station> vertices, Station sourceStation) {
		for (Station v : vertices) {
			v.setDistance(Integer.MAX_VALUE);
			if (v.equals(sourceStation)) {

			}
		}
	}

}
