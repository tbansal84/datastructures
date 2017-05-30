package thoughtworks.problems.utils;

/**
 * Utility class to return a pair of results fromone method
 * 
 * @author tbansal
 *
 * @param <L>
 * @param <R>
 */
public class Pair<L, R> {

	private L left;
	private R right;

	public Pair(L left, R right) {
		super();
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public R getRight() {
		return right;
	}

	public void setRight(R right) {
		this.right = right;
	}

}
