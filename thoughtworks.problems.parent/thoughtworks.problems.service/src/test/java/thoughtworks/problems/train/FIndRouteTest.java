package thoughtworks.problems.train;

import org.junit.Assert;
import org.junit.Test;

import thoughtworks.problems.utils.GraphFactory;
import thoughtworks.railroad.common.exceptions.RouteNotFoundException;
import thoughtworks.railroad.common.exceptions.StationNotFoundException;
import thoughtworks.railroad.domain.StationHopper;

public class FIndRouteTest {
	@Test
	public void testCase1() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findDistance(new String[] { "A", "B", "C" });
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 9);

	}

	@Test
	public void testCase2() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findDistance(new String[] { "A", "D" });
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 5);

	}

	@Test
	public void testCase3() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findDistance(new String[] { "A", "D", "C" });
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 13);

	}

	@Test
	public void testCase4() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findDistance(new String[] { "A", "E", "B", "C", "D" });
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 22);

	}

	@Test(expected = RouteNotFoundException.class)
	public void testCase5() throws StationNotFoundException, RouteNotFoundException {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		a = hopper.findDistance(new String[] { "A", "E", "D" });

	}

	@Test
	public void testCase6() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findRoutesWithTowns("C", "C", 3);
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 2);

	}

	@Test
	public void testCase7() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findRoutesWithAbsNoOfTowns("A", "C", 4);
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 3);

	}

	@Test
	public void testCase8() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findShortestDistance("A", "C");
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 9);

	}

	@Test
	public void testCase9() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findShortestDistance("B", "B");
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 9);

	}

	@Test
	public void testCase10() {
		StationHopper hopper = new StationHopper(GraphFactory.createTestGraph());
		int a = 0;
		try {
			a = hopper.findRoutesWithMaxDistance("C", "C", 30);
		} catch (StationNotFoundException | RouteNotFoundException e) {
		}
		Assert.assertEquals(a, 7);

	}

}
