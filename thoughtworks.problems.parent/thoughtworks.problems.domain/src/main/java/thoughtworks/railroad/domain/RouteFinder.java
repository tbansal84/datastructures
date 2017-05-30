package thoughtworks.railroad.domain;

import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.graphs.traversals.SearchCondition;

/**
 * The contract to find the paths based on given condition
 * 
 * @author tbansal
 *
 */
public interface RouteFinder {

	/**
	 * Method return the no of routes from given source satisfying the given
	 * condition.
	 * 
	 * @param source
	 * @param cond
	 * @return
	 */
	public int countPaths(Station source, SearchCondition cond);

}
