package thoughtworks.railroad.domain;

import java.util.ArrayList;
import java.util.List;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Edge;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.graphs.traversals.DFS;
import thoughtworks.problems.graphs.traversals.DFSImpl;
import thoughtworks.problems.graphs.traversals.SearchCondition;
import thoughtworks.problems.graphs.traversals.ShortestRoute;
import thoughtworks.problems.graphs.traversals.ShortestRouteImpl;
import thoughtworks.problems.utils.PropertiesUtil;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;

/**
 * 
 * Component to perform route operations
 * 
 * @author tbansal
 *
 */
public class StationHopper {

	private CityMap city;

	private static DFS dfs;

	private static ShortestRoute shortestRoute;

	static {

		dfs = new DFSImpl();
		shortestRoute = new ShortestRouteImpl();

	}

	public StationHopper(CityMap city) {
		this.city = city;

	}

	;

	/**
	 * This operation will return the
	 * 
	 * @param source
	 * @param destination
	 * @param cond
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public int findAllRoutes(String source, String destination, SearchCondition cond)
			throws StationNotFoundException, RouteNotFoundException {
		Station sourceStation = city.getVertex(source);
		Station destinationStation = city.getVertex(destination);

		if (sourceStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", source));
		}

		if (destinationStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", destination));
		}

		int allRoutes = dfs.countPaths(sourceStation, cond);
		if (allRoutes == 0) {
			throw new RouteNotFoundException(
					PropertiesUtil.getProperty("e.route", sourceStation.getLabel(), destinationStation.getLabel()));
		}
		return allRoutes;

	}

	public Path findShortestRoute(String source, String destination)
			throws StationNotFoundException, RouteNotFoundException {
		Station sourceStation = city.getVertex(source);
		Station destinationStation = city.getVertex(destination);
		if (sourceStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", source));
		}

		if (destinationStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", destination));
		}

		Path path = shortestRoute.findRoute(city, sourceStation, destinationStation);

		if (path == null) {
			throw new RouteNotFoundException(
					PropertiesUtil.getProperty("e.route", sourceStation.getLabel(), destinationStation.getLabel()));
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
		if (!city.containsAllVertex(source)) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station.all"));
		}
		List<Station> s = new ArrayList<>();
		int distance = 0;
		for (int i = 0; i < source.length - 1; i++) {
			Station sourceStation = city.getVertex(source[i]);
			Station nextStation = city.getVertex(source[i + 1]);
			Edge edge = null;
			if ((edge = city.getEdge(sourceStation, nextStation)) == null) {
				throw new RouteNotFoundException(
						PropertiesUtil.getProperty("e.route", sourceStation.getLabel(), nextStation.getLabel()));
			}
			distance += edge.getWeight();
		}
		return distance;
	}

}
