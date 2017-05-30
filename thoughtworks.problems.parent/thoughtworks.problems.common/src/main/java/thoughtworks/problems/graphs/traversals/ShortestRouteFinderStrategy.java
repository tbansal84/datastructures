package thoughtworks.problems.graphs.traversals;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;

/**
 * Shortest route finder strategy contract
 * 
 * @author tbansal
 *
 */
public interface ShortestRouteFinderStrategy {

	/**
	 * Implement this method using any shortest route finder algorithm
	 * 
	 * @param graph
	 * @param source
	 * @param destination
	 * @return
	 */
	Path findRoute(CityMap graph, Station source, Station destination);

}