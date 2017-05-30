package thoughtworks.railroad.domain;

import java.util.ArrayList;
import java.util.List;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.graphs.StationLink;
import thoughtworks.problems.graphs.traversals.DFSRouteFinderStartegyImpl;
import thoughtworks.problems.graphs.traversals.HybridDijkstraShortestRouteFinderStrategyImpl;
import thoughtworks.problems.graphs.traversals.SearchCondition;
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

	private static RouteFinder routeFinder;

	private static ShortestRouteFinder shortestRoute;

	static {
		// initialize route finder with DFS finder strategy
		routeFinder = new RouteFinderImpl(new DFSRouteFinderStartegyImpl());
		// init shortest route finder using Dijkstra algo startegy
		shortestRoute = new ShortestRouteFinderImpl(new HybridDijkstraShortestRouteFinderStrategyImpl());

	}

	public StationHopper(CityMap city) {
		this.city = city;

	}

	;

	/**
	 * This operation will return the no. of possible routes between source and
	 * destination satisfying the given condition
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
		Station sourceStation = city.getStationfromName(source);
		Station destinationStation = city.getStationfromName(destination);

		if (sourceStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", source));
		}

		if (destinationStation == null) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station", destination));
		}

		int allRoutes = routeFinder.countPaths(sourceStation, cond);
		if (allRoutes == 0) {
			throw new RouteNotFoundException(
					PropertiesUtil.getProperty("e.route", sourceStation.getLabel(), destinationStation.getLabel()));
		}
		return allRoutes;

	}

	/**
	 * The method will return the shortest route between source and destination
	 * 
	 * @param source
	 * @param destination
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public Path findShortestRoute(String source, String destination)
			throws StationNotFoundException, RouteNotFoundException {
		Station sourceStation = city.getStationfromName(source);
		Station destinationStation = city.getStationfromName(destination);
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

	/**
	 * The method will return the length of shortest route between source and
	 * destination
	 * 
	 * @param source
	 * @param destination
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public Integer findShortestDistance(String source, String destination)
			throws StationNotFoundException, RouteNotFoundException {
		return findShortestRoute(source, destination).distance();
	}

	/**
	 * The method will return the no of routes between source and destication
	 * with exact no of stops
	 * 
	 * @param source
	 * @param destination
	 * @param noOfStops
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public int findRoutesWithAbsNoOfTowns(String source, String destination, final Integer noOfStops)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.noOfStations() > noOfStops;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.getLastStationName()) && path.noOfStations() == noOfStops;
			}
		});
	}

	/**
	 * The method will return the no of routes between source and destination
	 * with lesser or equal no of given stops
	 * 
	 * @param source
	 * @param destination
	 * @param maxNoOfStops
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public int findRoutesWithTowns(String source, String destination, Integer maxNoOfStops)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.noOfStations() > maxNoOfStops;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.getLastStationName());
			}
		});
	}

	/**
	 * The method will return the no of routes between source and destination
	 * with length less<distance
	 * 
	 * @param source
	 * @param destination
	 * @param distance
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public int findRoutesWithMaxDistance(String source, String destination, Integer distance)
			throws StationNotFoundException, RouteNotFoundException {
		return findAllRoutes(source, destination, new SearchCondition() {

			@Override
			public boolean stop(Path path) {
				return path.distance() > distance;
			}

			@Override
			public boolean add(Path path) {
				return destination.equals(path.getLastStationName()) && path.distance() < distance;
			}
		});
	}

	/**
	 * The method will return the length of route covering the given station
	 * 
	 * @param source
	 * @return
	 * @throws StationNotFoundException
	 * @throws RouteNotFoundException
	 */
	public Integer findDistance(String[] source) throws StationNotFoundException, RouteNotFoundException {
		if (!city.containsAllStations(source)) {
			throw new StationNotFoundException(PropertiesUtil.getProperty("e.station.all"));
		}
		List<Station> s = new ArrayList<>();
		int distance = 0;
		for (int i = 0; i < source.length - 1; i++) {
			Station sourceStation = city.getStationfromName(source[i]);
			Station nextStation = city.getStationfromName(source[i + 1]);
			StationLink edge = null;
			if ((edge = city.getLink(sourceStation, nextStation)) == null) {
				throw new RouteNotFoundException(
						PropertiesUtil.getProperty("e.route", sourceStation.getLabel(), nextStation.getLabel()));
			}
			distance += edge.getLinkLength();
		}
		return distance;
	}

}
