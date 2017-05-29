package thoughtworks.railroad.domain;

import java.util.ArrayList;
import java.util.List;

import thoughtworks.ds.graphs.Edge;
import thoughtworks.ds.graphs.Path;
import thoughtworks.ds.graphs.Station;
import thoughtworks.ds.graphs.traversals.DFS;
import thoughtworks.ds.graphs.traversals.DFSImpl;
import thoughtworks.ds.graphs.traversals.SearchCondition;
import thoughtworks.ds.graphs.traversals.ShortestRoute;
import thoughtworks.ds.graphs.traversals.ShortestRouteImpl;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;
import thoughtworks.railroad.entity.CityMap;

public class StationHopper {

	private CityMap map;

	private DFS dfs;

	private ShortestRoute shortestRoute;

	public StationHopper(CityMap town) {
		this.map = town;
		this.dfs = new DFSImpl();
		shortestRoute = new ShortestRouteImpl();
	}

	;

	public int findAllRoutes(String source, String destination, SearchCondition cond)
			throws StationNotFoundException, RouteNotFoundException {
		Station sourceStation = map.getVertex(source);
		Station destinationStation = map.getVertex(destination);

		if (sourceStation == null) {
			throw new StationNotFoundException(source);
		}

		if (destinationStation == null) {
			throw new StationNotFoundException(destination);
		}

		int allRoutes = dfs.countPaths(sourceStation, cond);
		if (allRoutes == 0) {
			throw new RouteNotFoundException(source, destination);
		}
		return allRoutes;

	}

	public Path findShortestRoute(String source, String destination)
			throws StationNotFoundException, RouteNotFoundException {
		Station sourceStation = map.getVertex(source);
		Station destinationStation = map.getVertex(destination);
		if (sourceStation == null) {
			throw new StationNotFoundException(source);
		}

		if (destinationStation == null) {
			throw new StationNotFoundException(destination);
		}

		Path path = shortestRoute.findRoute(map, sourceStation, destinationStation);

		if (path == null) {
			throw new RouteNotFoundException(source, destination);
		}
		return path;

	}

	public Integer findShortestDistance(String source, String destination)
			throws StationNotFoundException, RouteNotFoundException {
		return findShortestRoute(source, destination).distance();
	}

	public int findRoutesWithAbsNoOfTowns(String source, String destination, final Integer noOfStops)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.length() > noOfStops;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.tail()) && path.length() == noOfStops;
			}
		});
	}

	public int findRoutesWithTowns(String source, String destination, Integer maxNoOfStops)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.length() > maxNoOfStops;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.tail());
			}
		});
	}

	public int findRoutesWithMaxDistance(String source, String destination, Integer distance)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.distance() > distance;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.tail()) && path.distance() < distance;
			}
		});
	}

	public Integer findDistance(String[] source) throws StationNotFoundException, RouteNotFoundException {
		if (!map.containsAllVertex(source)) {
			throw new StationNotFoundException();
		}
		List<Station> s = new ArrayList<>();
		int distance = 0;
		for (int i = 0; i < source.length - 1; i++) {
			Station sourceStation = map.getVertex(source[i]);
			Station nextStation = map.getVertex(source[i + 1]);
			Edge edge = null;
			if ((edge = map.getEdge(sourceStation, nextStation)) == null) {
				throw new RouteNotFoundException();
			}
			distance += edge.getWeight();
		}
		return distance;
	}

}
