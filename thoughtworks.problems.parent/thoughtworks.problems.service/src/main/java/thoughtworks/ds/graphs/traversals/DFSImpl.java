package thoughtworks.ds.graphs.traversals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import thoughtworks.ds.graphs.Edge;
import thoughtworks.ds.graphs.Path;
import thoughtworks.ds.graphs.Station;
import thoughtworks.railroad.entity.CityMap;

public class DFSImpl implements DFS {

	public int countPaths(Station source, SearchCondition cond) {
		int total = 0;

		for (Edge neighbour : source.getNeighbours()) {
			Path path = new Path();
			path.addStation(source, 0);
			path.addStation(neighbour.getTwo(), neighbour.getWeight());
			total += findAllPaths(neighbour.getTwo(), cond, path);
		}

		return total;
	}

	private int findAllPaths(Station source, SearchCondition cond, Path path) {
		int total = 0;

		if (cond.add(path)) {
			total++;
			path.printPath_test("");
		}

		for (Edge neighbour : source.getNeighbours()) {

			path.addStation(neighbour.getTwo(), neighbour.getWeight());

			if (cond.stop(path)) {
				path.removeLastElement();
				continue; // go to next neighbour
			} else {
				total += findAllPaths(neighbour.getTwo(), cond, path);
			}

			path.removeLastElement();
		}
		return total;
	}

}
