package thoughtworks.ds.graphs.traversals;

import thoughtworks.ds.graphs.Path;
import thoughtworks.ds.graphs.Station;
import thoughtworks.railroad.entity.CityMap;

public interface ShortestRoute {


	Path findRoute(CityMap graph, Station source, Station destination);

}