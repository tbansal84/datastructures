package thoughtworks.railroad.domain;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.graphs.traversals.ShortestRouteFinderStrategy;

/**
 * Shortest route finder implementation.
 * 
 * @author tbansal
 *
 */
public class ShortestRouteFinderImpl implements ShortestRouteFinder {

	ShortestRouteFinderStrategy shortestRouteFinderStrategy;

	/**
	 * This strategy to be used by route finder can be injected by the client
	 * 
	 * @param shortestRouteFinderStrategy
	 */
	public ShortestRouteFinderImpl(ShortestRouteFinderStrategy shortestRouteFinderStrategy) {
		super();
		this.shortestRouteFinderStrategy = shortestRouteFinderStrategy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * thoughtworks.railroad.domain.ShortestRouteFinder#findRoute(thoughtworks.
	 * problems.entity.CityMap, thoughtworks.problems.graphs.Station,
	 * thoughtworks.problems.graphs.Station)
	 */
	@Override
	public Path findRoute(CityMap graph, Station source, Station destination) {
		return shortestRouteFinderStrategy.findRoute(graph, source, destination);
	}

}
