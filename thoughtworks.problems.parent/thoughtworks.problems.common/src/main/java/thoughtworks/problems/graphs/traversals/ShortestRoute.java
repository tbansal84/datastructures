package thoughtworks.problems.graphs.traversals;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Path;
import thoughtworks.problems.graphs.Station;

public interface ShortestRoute {


	Path findRoute(CityMap graph, Station source, Station destination);

}