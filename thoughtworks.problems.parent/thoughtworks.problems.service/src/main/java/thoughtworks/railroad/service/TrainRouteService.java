package thoughtworks.railroad.service;

import org.apache.log4j.Logger;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;
import thoughtworks.railroad.common.exceptions.TrainRouteServiceException;
import thoughtworks.railroad.domain.StationHopper;

public class TrainRouteService {

	private static final Logger LOGGER = Logger.getLogger(TrainRouteService.class);

	private TrainRouteService() {
		super();
	}

	private static final TrainRouteService instance;

	static {
		try {
			instance = new TrainRouteService();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static TrainRouteService getInstance() {
		return instance;
	}

	/**
	 * The service method return the shortest route between source and
	 * destination on given map
	 * 
	 * @param source
	 * @param destination
	 * @param map
	 * @return
	 */
	public static Path findShortestRoute(String source, String destination, CityMap map) {
		LOGGER.debug(String.format("Method findShortestRoute start() with parameters %1s,%2s", source, destination));
		Path path = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			path = stationHopper.findShortestRoute(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		LOGGER.debug("Method findShortestRoute ends()");
		return path;
	}

	/**
	 * The service method return the length of shortest route between source and
	 * destination
	 * 
	 * @param source
	 * @param destination
	 * @param map
	 * @return
	 */
	public static Integer findShortestDistance(String source, String destination, CityMap map) {
		LOGGER.debug(String.format("Method findShortestDistance start() with parameters %1s,%2s", source, destination));
		Integer distance = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			distance = stationHopper.findShortestDistance(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return distance;
	}

	/**
	 * The method will return the no of routes between source and destication
	 * with exact no of stops
	 * 
	 * @param source
	 * @param destination
	 * @param noOfStops
	 * @param map
	 * @return
	 */
	public static Integer findRoutesWithAbsTowns(String source, String destination, Integer noOfStops, CityMap map) {
		LOGGER.debug(String.format("Method findRoutesWithAbsTowns start() with parameters %1s,%2s,%3s", source,
				destination, noOfStops));
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithAbsNoOfTowns(source, destination, noOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	/**
	 * The service method will return the no of routes between source and
	 * destination with lesser or equal no of given stops
	 * 
	 * @param source
	 * @param destination
	 * @param maxNoOfStops
	 * @param map
	 * @return
	 */
	public static Integer findRoutesWithTowns(String source, String destination, Integer maxNoOfStops, CityMap map) {
		LOGGER.debug(String.format("Method findRoutesWithTowns start() with parameters %1s,%2s,%3s", source,
				destination, maxNoOfStops));
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithTowns(source, destination, maxNoOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	/**
	 * The service method will return the no of routes between source and
	 * destination with length less<distance
	 * 
	 * @param source
	 * @param destination
	 * @param distance
	 * @param map
	 * @return
	 */
	public static Integer findRoutesWithMaxDistance(String source, String destination, Integer distance, CityMap map) {
		LOGGER.debug(String.format("Method findRoutesWithMaxDistance start() with parameters %1s,%2s,%3s", source,
				destination, distance));
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithMaxDistance(source, destination, distance);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	/**
	 * The service method will return the length of route covering the given
	 * station
	 * 
	 * @param map
	 * @param source
	 * @return
	 */
	public static Integer findDistance(CityMap map, String... source) {
		LOGGER.debug(String.format("Method findDistance start() with parameters %1s,%2s", source));
		Integer distance = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			distance = stationHopper.findDistance(source);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return distance;
	}

}
