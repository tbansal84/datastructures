package thoughtworks.problems.graphs.traversals;

import thoughtworks.problems.graphs.Station;

/**
 * Route Finder strategy contract
 * 
 * @author tbansal
 *
 */
public interface RouteFinderStartegy {

	/**
	 * The method return the no of path in given map, satisfying the given
	 * conditions
	 * 
	 * @param source
	 * @param cond
	 * @return
	 */
	public int countPaths(Station source, SearchCondition cond);

}
