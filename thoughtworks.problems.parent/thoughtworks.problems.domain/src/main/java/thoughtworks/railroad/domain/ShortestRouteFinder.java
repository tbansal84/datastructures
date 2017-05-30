package thoughtworks.railroad.domain;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;

/**
 * The contract for a shortest route finder. The strategy to be used to find the
 * shortest route can be injected by the caller using DI framework/constructor.
 * 
 * @author tbansal
 *
 */
public interface ShortestRouteFinder {

	/**
	 * FInd shortest route in given map from source to destination
	 * 
	 * @param map
	 * @param source
	 * @param destination
	 * @return
	 */
	Path findRoute(CityMap map, Station source, Station destination);

}