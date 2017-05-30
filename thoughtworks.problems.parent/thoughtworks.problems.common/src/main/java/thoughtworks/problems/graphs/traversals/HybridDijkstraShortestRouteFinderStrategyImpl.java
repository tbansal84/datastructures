package thoughtworks.problems.graphs.traversals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.StationLink;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.utils.BinaryMinHeap;

/**
 * The class implements the shortest searching strategy using hybrid version of
 * Dijkstra algorithm. The variance from normal dijkstra is that it searches
 * path originating from one origin to same origin through other stations
 * 
 * @author tbansal
 *
 */
public class HybridDijkstraShortestRouteFinderStrategyImpl implements ShortestRouteFinderStrategy {

	/* (non-Javadoc)
	 * @see thoughtworks.problems.graphs.traversals.ShortestRouteFinderStrategy#findRoute(thoughtworks.problems.entity.CityMap, thoughtworks.problems.graphs.Station, thoughtworks.problems.graphs.Station)
	 */
	@Override
	public Path findRoute(CityMap graph, Station source, Station destination) {
		Map<Station, Integer> distance = new HashMap<>();
		Map<Station, Station> parent = new HashMap<>();
		shortestPath(graph, source, distance, parent);
		return findRoute(parent, distance, source, destination);
	}

	/**
	 * 
	 * Find the route from bactacking the paren station
	 * 
	 * @param parent
	 * @param distance
	 * @param source
	 * @param destination
	 * @return
	 */
	private Path findRoute(Map<Station, Station> parent, Map<Station, Integer> distance, Station source,
			Station destination) {
		Path path = new Path();
		Station prev = destination;
		path.addStation(prev, distance.get(prev));
		while (!prev.equals(source)) {
			prev = parent.get(prev);
			path.addStation(prev, distance.get(prev));
		}
		path.setDistances(Arrays.asList(new Integer[] { distance.get(destination) }));
		return path;
	}

	/**
	 * 
	 * This method is the hybrid implementation of Dijkstra algorithm to search
	 * circular paths.
	 * 
	 * @param graph
	 * @param sourceStation
	 * @param distance
	 * @param parent
	 * @return
	 */
	private Map<Station, Integer> shortestPath(CityMap graph, Station sourceStation, Map<Station, Integer> distance,
			Map<Station, Station> parent) {
		getTowns(graph.getStations(), sourceStation);

		BinaryMinHeap<Station> minHeap = new BinaryMinHeap<>(graph.getStations());

		minHeap.decrease(sourceStation.getLabel(), 0);

		distance.put(sourceStation, 0);

		parent.put(sourceStation, sourceStation);

		while (!minHeap.isEmpty()) {
			Station current = minHeap.extract();
			distance.put(current, current.getDistance());

			if (current.equals(sourceStation) && !current.equals(parent.get(sourceStation))) {
				break;
			}

			for (StationLink edge : current.getNeighbours()) {

				Station neighbour = edge.getTwo();
				int newDistance = distance.get(current) + edge.getLinkLength();
				System.out.println(neighbour.getLabel());
				if (minHeap.getWeight(neighbour.getLabel()) > newDistance || neighbour.equals(parent.get(neighbour))) {
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
