package thoughtworks.problems.entity;

import java.util.*;

import thoughtworks.problems.graphs.StationLink;
import thoughtworks.problems.graphs.Station;

/**
 * The class represents the statio map of the city
 * 
 * @author tbansal
 *
 */
public class CityMap {

	private HashMap<String, Station> stations;
	private HashMap<Integer, StationLink> links;

	public CityMap() {
		this.stations = new HashMap<String, Station>();
		this.links = new HashMap<Integer, StationLink>();
	}

	public CityMap(ArrayList<Station> vertices) {
		this.stations = new HashMap<String, Station>();
		this.links = new HashMap<Integer, StationLink>();

		for (Station v : vertices) {
			this.stations.put(v.getLabel(), v);
		}

	}

	/**
	 * 
	 * Add link between two stations
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public boolean addLink(Station one, Station two) {
		return addLink(one, two, 1);
	}

	/**
	 * 
	 * Add link between two stations with given length
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public boolean addLink(Station one, Station two, int lebgth) {
		if (one.equals(two)) {
			return false;
		}

		// ensures the Link is not in the Map already
		StationLink e = new StationLink(one, two, lebgth);
		if (links.containsKey(e.hashCode())) {
			return false;
		}

		// and that the Link isn't already mapped ot one of the stations
		else if (one.containsNeighbour(e) || two.containsNeighbour(e)) {
			return false;
		}

		links.put(e.hashCode(), e);
		one.addNeighbour(e);
		return true;
	}

	/**
	 * 
	 * Does the map contain this link between two staitions already
	 * 
	 * @param e
	 * @return
	 */
	public boolean containsLink(StationLink e) {
		if (e.getOne() == null || e.getTwo() == null) {
			return false;
		}

		return this.links.containsKey(e.hashCode());
	}

	/**
	 * Remove the link from the map
	 * 
	 * @param e
	 * @return
	 */
	public StationLink removeLink(StationLink e) {
		e.getOne().removeNeighbor(e);
		e.getTwo().removeNeighbor(e);
		return this.links.remove(e.hashCode());
	}

	/**
	 * 
	 * Does the map contains this station
	 * 
	 * @param vertex
	 * @return
	 */
	public boolean containsStation(Station vertex) {
		return this.stations.get(vertex.getLabel()) != null;
	}

	/**
	 * Does the map contain all stations
	 * 
	 * @param vertexLabel
	 * @return
	 */
	public boolean containsAllStations(String[] vertexLabel) {
		return this.stationNames().containsAll(Arrays.asList(vertexLabel));
	}

	/**
	 * 
	 * Return the stations by its name
	 * 
	 * @param label
	 * @return
	 */
	public Station getStationfromName(String label) {
		return stations.get(label);
	}

	/**
	 * 
	 * add a station
	 * 
	 * @param station
	 * @param overwriteExisting
	 * @return
	 */
	public boolean addStation(Station station, boolean overwriteExisting) {
		Station current = this.stations.get(station.getLabel());
		if (current != null) {
			if (!overwriteExisting) {
				return false;
			}

			while (current.getNeighborCount() > 0) {
				this.removeLink(current.getNeighbour(0));
			}
		}

		stations.put(station.getLabel(), station);
		return true;
	}

	/**
	 * Remove the station with given name
	 * 
	 * @param name
	 * @return
	 */
	public Station removeStation(String name) {
		Station v = stations.remove(name);

		while (v.getNeighborCount() > 0) {
			this.removeLink(v.getNeighbour((0)));
		}

		return v;
	}

	/**
	 * Return name of all stations in city
	 * 
	 * @return
	 */
	public Set<String> stationNames() {
		return this.stations.keySet();
	}

	/**
	 * Return all stations in city
	 * 
	 * @return
	 */
	public Collection<Station> getStations() {
		return this.stations.values();
	}

	/**
	 * Return all links in map
	 * 
	 * @return
	 */
	public Set<StationLink> getLinks() {
		return new HashSet<StationLink>(this.links.values());
	}

	/**
	 * Return link between teo stations
	 * 
	 * @return
	 */
	public StationLink getLink(Station source, Station destination) {

		return this.links.get((source.getLabel() + destination.getLabel()).hashCode());

	}

}
