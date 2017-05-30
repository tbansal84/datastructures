package thoughtworks.problems.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import thoughtworks.problems.utils.PropertiesUtil;

/**
 * The class represents the path from one station to another
 * @author tbansal
 *
 */
public class Path {

	private List<Station> path = new ArrayList<>();
	private List<Integer> distances = new ArrayList<>();

	public void addStation(Station station, int distance) {
		this.distances.add(distance);
		this.path.add(station);
	}

	/**
	 * Return series of stations in path
	 * 
	 * @return
	 */
	public List<Station> getPath() {
		return path;
	}

	/**
	 * Set the series of stations on path
	 * 
	 * @param path
	 */
	public void setPath(List<Station> path) {
		this.path = path;
	}

	/**
	 * Get the distances for between stations on path
	 * 
	 * @return
	 */
	public List<Integer> getDistances() {
		return distances;
	}

	/**
	 * Set the distances for between stations on path
	 * 
	 * @param distances
	 */
	public void setDistances(List<Integer> distances) {
		this.distances = distances;
	}

	/** Create copy of path
	 */
	public Path clone() {
		Path p = new Path();
		List<Integer> distances = new ArrayList<>();
		List<Station> path = new ArrayList<>();
		distances.addAll(this.distances);
		path.addAll(this.path);
		p.setDistances(distances);
		p.setPath(path);
		return p;
	}

	/**
	 * Remove the last station from path
	 */
	public void removeLastStation() {
		removeLastElement(path);
		removeLastElement(distances);
	}

	private Object removeLastElement(List ls) {
		return ls.remove(ls.size() - 1);

	}

	public void printPath_test(String feed) {
		System.out.print(feed + ": ");
		for (Station s : this.getPath()) {

			System.out.print(s.getLabel() + "->");
		}

		System.out.println();
	}


	/**
	 * Returns distance of path
	 * @return
	 */
	public int distance() {
		int i = 0;
		for (int distance : distances) {
			i += distance;
		}
		return i;
	}

	/**
	 * Return no of stations on path
	 * @return
	 */
	public int noOfStations() {
		return Math.max(0, this.path.size() - 1);
	}


	/**
	 * Return name of last station on path
	 * @return
	 */
	public String getLastStationName() {
		return path.get(path.size() - 1).getLabel();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int i = 1;
		for (Station s : this.path) {
			builder.append(s);
			if (i < this.path.size()) {
				builder.append(PropertiesUtil.getProperty("path.separator"));
			}
			i++;
		}
		return super.toString();
	}

}
