package thoughtworks.railroad.service;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;
import thoughtworks.railroad.common.exceptions.TrainRouteServiceException;
import thoughtworks.railroad.domain.StationHopper;

public class TrainRouteService {

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

	public static Path findShortestRoute(String source, String destination, CityMap map) {
		Path path = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			path = stationHopper.findShortestRoute(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return path;
	}

	public static Integer findShortestDistance(String source, String destination, CityMap map) {
		Integer distance = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			distance = stationHopper.findShortestDistance(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return distance;
	}

	public static Integer findRoutesWithAbsTowns(String source, String destination, Integer noOfStops, CityMap map) {
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithAbsNoOfTowns(source, destination, noOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	public static Integer findRoutesWithTowns(String source, String destination, Integer maxNoOfStops, CityMap map) {
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithTowns(source, destination, maxNoOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	public static Integer findRoutesWithMaxDistance(String source, String destination, Integer distance, CityMap map) {
		Integer paths = null;
		try {
			StationHopper stationHopper = new StationHopper(map);
			paths = stationHopper.findRoutesWithMaxDistance(source, destination, distance);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	public static Integer findDistance(CityMap map, String... source) {
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
