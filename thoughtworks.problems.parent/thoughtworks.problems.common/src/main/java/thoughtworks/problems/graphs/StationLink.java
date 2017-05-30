package thoughtworks.problems.graphs;

/**
 * The class represents the link between two stations
 * 
 * @author tbansal
 *
 */
public class StationLink implements Comparable<StationLink> {

	private Station one, two;
	private int linklength;

	/**
	 * 
	 * @param one
	 *            The first station on the link
	 * @param two
	 *            The second station on the link
	 */
	public StationLink(Station one, Station two) {
		this(one, two, 1);
	}

	/**
	 * 
	 * @param one
	 *            The first station on the link
	 * @param two
	 *            The second station on the link
	 * @param three The length of link
	 */
	public StationLink(Station one, Station two, int weight) {
		this.one = one;
		this.two = two;
		this.linklength = weight;
	}

	/**
	 * 
	 * @param current
	 * @return The neighbor of current station along this Link
	 */
	public Station getNeighbor(Station current) {
		if (!(current.equals(one) || current.equals(two))) {
			return null;
		}

		return (current.equals(one)) ? two : one;
	}

	/**
	 * 
	 * @return Owner Station 
	 */
	public Station getOne() {
		return this.one;
	}

	/**
	 * 
	 * @return Neighbouring Station
	 */
	public Station getTwo() {
		return this.two;
	}

	/**
	 * 
	 * @return length of link
	 */
	public int getLinkLength() {
		return this.linklength;
	}

	/**
	 * 
	 * @param weight
	 *            set new length of this link
	 */
	public void setLinkLength(int weight) {
		this.linklength = weight;
	}

	public int compareTo(StationLink other) {
		return this.linklength - other.linklength;
	}

	/**
	 * 
	 * @return String A String representation of this Link
	 */
	public String toString() {
		return "({" + one + ", " + two + "}, " + linklength + ")";
	}

	/**
	 * 
	 * @return int The hash code for this Link
	 */
	public int hashCode() {
		return (one.getLabel() + two.getLabel()).hashCode();
	}

	public boolean equals(Object other) {
		if (!(other instanceof StationLink)) {
			return false;
		}

		StationLink e = (StationLink) other;

		return e.one.equals(this.one) && e.two.equals(this.two);
	}
}
