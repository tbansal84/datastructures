package thoughtworks.railroad.service;

import java.util.List;

import thoughtworks.ds.graphs.Path;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;
import thoughtworks.railroad.common.exceptions.TrainRouteServiceException;
import thoughtworks.railroad.domain.StationHopper;

public class TrainRouteService {
	private StationHopper stationHopper;

	public Path findShortestRoute(String source, String destination) {
		Path path = null;
		try {
			path = stationHopper.findShortestRoute(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return path;
	}

	public Integer findShortestDistance(String source, String destination) {
		Integer distance = null;
		try {
			distance = stationHopper.findShortestDistance(source, destination);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return distance;
	}

	public Integer findRoutesWithAbsTowns(String source, String destination, Integer noOfStops) {
		Integer paths = null;
		try {
			paths = stationHopper.findRoutesWithAbsNoOfTowns(source, destination, noOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}

	public Integer findRoutesWithTowns(String source, String destination, Integer maxNoOfStops) {
		Integer paths = null;
		try {
			paths = stationHopper.findRoutesWithTowns(source, destination, maxNoOfStops);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}


	public Integer findRoutesWithMaxDistance(String source, String destination, Integer distance) {
		Integer paths = null;
		try {
			paths = stationHopper.findRoutesWithMaxDistance(source, destination, distance);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return paths;
	}
	
	public Integer findDistance(String... source) {
		Integer distance = null;
		try {
			distance = stationHopper.findDistance(source);
		} catch (StationNotFoundException | RouteNotFoundException e1) {
			new TrainRouteServiceException(String.format("Exception in TrainRouteService %1s", e1.getMessage()));
		}
		return distance;
	}

}
