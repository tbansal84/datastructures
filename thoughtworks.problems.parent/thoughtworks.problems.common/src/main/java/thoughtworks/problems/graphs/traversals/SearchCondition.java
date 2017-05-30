package thoughtworks.problems.graphs.traversals;

import thoughtworks.problems.graphs.Path;

/**
 * Condition for Path search in graph
 * 
 * @author tbansal
 *
 */
public interface SearchCondition {

	/**
	 * 
	 * Condition to termnate the search
	 * 
	 * @param path
	 * @return
	 */
	boolean stop(Path path);

	/**
	 * condition to add a path to results
	 * 
	 * @param path
	 * @return
	 */
	boolean add(Path path);

}
