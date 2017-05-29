package thoughtworks.problems.graphs.traversals;

import thoughtworks.problems.graphs.Path;

public interface SearchCondition {
	
	 boolean stop(Path path);
	 
	 boolean add(Path path);

}
