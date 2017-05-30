package thoughtworks.problems.graphs;

import java.util.ArrayList;

import thoughtworks.problems.utils.HeapElement;

/**
 * 
 * The class represents a train station
 * 
 * @author tbansal
 *
 */
public class Station implements HeapElement<Station> {

	private ArrayList<StationLink> neighbours;
	private String label;
	private Integer distance;

	/**
	 * The constructor for Station class.
	 * 
	 * @param label
	 *            the label to be assigned to Station
	 */
	public Station(String label) {
		this.label = label;
		this.neighbours = new ArrayList<StationLink>();
	}

	/**
	 * Adds a neighbour to Station.
	 * 
	 * @param edge
	 */
	public void addNeighbour(StationLink edge) {
		if (this.neighbours.contains(edge)) {
			return;
		}
		this.neighbours.add(edge);
	}

	/**
	 * 
	 * Does the Neighbour already exist for the station.
	 * 
	 * @param other
	 * @return
	 */
	public boolean containsNeighbour(StationLink other) {
		return this.neighbours.contains(other);
	}

	/**
	 * 
	 * Retrieve neighbour by it's index
	 * 
	 * @param index
	 * @return
	 */
	public StationLink getNeighbour(int index) {
		return this.neighbours.get(index);
	}

	public void removeNeighbor(StationLink e) {
		this.neighbours.remove(e);
	}

	/**
	 * Get total counts for neighbour
	 * 
	 * @return
	 */
	public int getNeighborCount() {
		return this.neighbours.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thoughtworks.problems.utils.HeapElement#getLabel()
	 */
	public String getLabel() {
		return this.label;
	}

	/* (non-Javadoc)
	 * @see thoughtworks.problems.utils.HeapElement#decrease(java.lang.Integer)
	 */
	public void decrease(Integer i) {
		this.distance = i;

	}

	/**
	 * Return all neighbours for that station
	 * @return
	 */
	public ArrayList<StationLink> getNeighbours() {
		return new ArrayList<StationLink>(this.neighbours);
	}

	/* (non-Javadoc)
	 * @see thoughtworks.problems.utils.HeapElement#getDistance()
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * Set name for station
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		return "Vertex " + label;
	}

	public int hashCode() {
		return this.label.hashCode();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Station)) {
			return false;
		}

		Station v = (Station) other;
		return this.label.equals(v.label);
	}

	public int compareTo(Station o) {
		return this.distance.compareTo(o.getDistance());
	}

}
