package thoughtworks.railroad.domain;

import thoughtworks.problems.graphs.Station;
import thoughtworks.problems.graphs.traversals.RouteFinderStartegy;
import thoughtworks.problems.graphs.traversals.SearchCondition;

/**
 * The route finder implementation.
 * 
 * @author tbansal
 *
 */
public class RouteFinderImpl implements RouteFinder {

	RouteFinderStartegy routeFinderStartegy;

	/**
	 * The strategy to find the route can be injedted by the caller.
	 * 
	 * @param routeFinderStartegy
	 */
	public RouteFinderImpl(RouteFinderStartegy routeFinderStartegy) {
		super();
		this.routeFinderStartegy = routeFinderStartegy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * thoughtworks.railroad.domain.RouteFinder#countPaths(thoughtworks.problems
	 * .graphs.Station, thoughtworks.problems.graphs.traversals.SearchCondition)
	 */
	@Override
	public int countPaths(Station source, SearchCondition cond) {
		return routeFinderStartegy.countPaths(source, cond);
	}

}
