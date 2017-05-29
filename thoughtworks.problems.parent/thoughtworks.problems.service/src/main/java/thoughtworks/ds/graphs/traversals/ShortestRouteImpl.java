package thoughtworks.ds.graphs.traversals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import thoughtworks.ds.graphs.Path;
import thoughtworks.ds.graphs.Station;
import thoughtworks.railroad.entity.CityMap;

public class ShortestRouteImpl implements ShortestRoute {

	@Override
	public Path findRoute(CityMap graph, Station source, Station destination) {
		Map<Station, Integer> distance = new HashMap<>();
		Map<Station, Station> parent = new HashMap<>();
		Dijkstra search = new Dijkstra();
		search.shortestPath(graph, source, distance, parent);
		return findRoute(parent, distance, source, destination);
	}

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

}
