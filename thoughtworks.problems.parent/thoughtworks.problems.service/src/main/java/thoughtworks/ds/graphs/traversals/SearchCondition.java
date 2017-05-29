package thoughtworks.ds.graphs.traversals;

import thoughtworks.ds.graphs.Path;

public interface SearchCondition {
	
	 boolean stop(Path path);
	 
	 boolean add(Path path);

}
