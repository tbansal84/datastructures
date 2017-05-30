package thoughtworks.problems.graphs.traversals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.StationLink;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;

/**
 * The class implements the Route finder strategy
 * 
 * @author tbansal
 *
 */
public class DFSRouteFinderStartegyImpl implements RouteFinderStartegy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * thoughtworks.problems.graphs.traversals.RouteFinderStartegy#countPaths(
	 * thoughtworks.problems.graphs.Station,
	 * thoughtworks.problems.graphs.traversals.SearchCondition)
	 */
	public int countPaths(Station source, SearchCondition cond) {
		int total = 0;

		for (StationLink neighbour : source.getNeighbours()) {
			Path path = new Path();
			path.addStation(source, 0);
			path.addStation(neighbour.getTwo(), neighbour.getLinkLength());
			total += findAllPaths(neighbour.getTwo(), cond, path);
		}

		return total;
	}

	/**
	 * 
	 * The method returns the number of paths pn the map. It is hybird version
	 * of Graph BFS
	 * 
	 * @param source
	 * @param cond-conditions
	 *            to search and filter the stations on map
	 * @param path
	 * @return
	 */
	private int findAllPaths(Station source, SearchCondition cond, Path path) {
		int total = 0;

		if (cond.add(path)) {
			total++;
			path.printPath_test("");
		}

		for (StationLink neighbour : source.getNeighbours()) {

			path.addStation(neighbour.getTwo(), neighbour.getLinkLength());

			if (cond.stop(path)) {
				path.removeLastStation();
				continue; // go to next neighbour
			} else {
				total += findAllPaths(neighbour.getTwo(), cond, path);
			}

			path.removeLastStation();
		}
		return total;
	}

}
