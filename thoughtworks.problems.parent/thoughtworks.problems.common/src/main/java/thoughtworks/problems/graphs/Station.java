package thoughtworks.problems.graphs;

import java.util.ArrayList;

import thoughtworks.problems.utils.HeapElement;

/**
 * This class models a vertex in a graph. For ease of the reader, a label for
 * this vertex is required. Note that the Graph object only accepts one Vertex
 * per label, so uniqueness of labels is important. This vertex's neighborhood
 * is described by the Edges incident to it.
 * 
 * @author Michael Levet
 * @date June 09, 2015
 */
public class Station implements HeapElement<Station> {

	private ArrayList<Edge> neighbours;
	private String label;
	private Integer distance;

	/**
	 * 
	 * @param label
	 *            The unique label associated with this Vertex
	 */
	public Station(String label) {
		this.label = label;
		this.neighbours = new ArrayList<Edge>();
	}

	public Station(Station v, long maxValue) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method adds an Edge to the incidence neighborhood of this graph iff
	 * the edge is not already present.
	 * 
	 * @param edge
	 *            The edge to add
	 */
	public void addNeighbor(Edge edge) {
		if (this.neighbours.contains(edge)) {
			return;
		}

		this.neighbours.add(edge);
	}

	/**
	 * 
	 * @param other
	 *            The edge for which to search
	 * @return true iff other is contained in this.neighborhood
	 */
	public boolean containsNeighbor(Edge other) {
		return this.neighbours.contains(other);
	}

	/**
	 * 
	 * @param index
	 *            The index of the Edge to retrieve
	 * @return Edge The Edge at the specified index in this.neighborhood
	 */
	public Edge getNeighbor(int index) {
		return this.neighbours.get(index);
	}

	/**
	 * 
	 * @param index
	 *            The index of the edge to remove from this.neighborhood
	 * @return Edge The removed Edge
	 */
	Edge removeNeighbor(int index) {
		return this.neighbours.remove(index);
	}

	/**
	 * 
	 * @param e
	 *            The Edge to remove from this.neighborhood
	 */
	public void removeNeighbor(Edge e) {
		this.neighbours.remove(e);
	}

	/**
	 * 
	 * @return int The number of neighbors of this Vertex
	 */
	public int getNeighborCount() {
		return this.neighbours.size();
	}

	/**
	 * 
	 * @return String The label of this Vertex
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * 
	 * @return String A String representation of this Vertex
	 */
	public String toString() {
		return "Vertex " + label;
	}

	/**
	 * 
	 * @return The hash code of this Vertex's label
	 */
	public int hashCode() {
		return this.label.hashCode();
	}

	/**
	 * 
	 * @param other
	 *            The object to compare
	 * @return true iff other instanceof Vertex and the two Vertex objects have
	 *         the same label
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Station)) {
			return false;
		}

		Station v = (Station) other;
		return this.label.equals(v.label);
	}

	/**
	 * 
	 * @return ArrayList<Edge> A copy of this.neighborhood. Modifying the
	 *         returned ArrayList will not affect the neighborhood of this
	 *         Vertex
	 */
	public ArrayList<Edge> getNeighbors() {
		return new ArrayList<Edge>(this.neighbours);
	}

	public int compareTo(Station o) {
		return this.distance.compareTo(o.getDistance());
	}

	public void decrease(Integer i) {
		this.distance = i;

	}

	public ArrayList<Edge> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Edge> neighbours) {
		this.neighbours = neighbours;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
