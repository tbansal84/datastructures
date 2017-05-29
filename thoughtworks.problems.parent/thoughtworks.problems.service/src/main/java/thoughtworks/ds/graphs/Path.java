package thoughtworks.ds.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Path {

	private List<Station> path = new ArrayList<>();
	private List<Integer> distances = new ArrayList<>();

	public void addStation(Station station, int distance) {
		this.distances.add(distance);
		this.path.add(station);
	}

	public void removePreviousStation(int weight) {

	}

	public List<Station> getPath() {
		return path;
	}

	public void setPath(List<Station> path) {
		this.path = path;
	}

	public List<Integer> getDistances() {
		return distances;
	}

	public void setDistances(List<Integer> distances) {
		this.distances = distances;
	}

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

	public void removeLastElement() {
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

	public int noOfStations() {
		return this.path.size();
	}

	public int distance() {
		int i = 0;
		for (int distance : distances) {
			i += distance;
		}
		return i;
	}
	
	public int length(){
		return Math.max(0,this.path.size()-1);
	}

	public void decrease() {
		removeLastElement(this.distances);
	}

	public String tail() {
		return path.get(path.size() - 1).getLabel();
	}

}
