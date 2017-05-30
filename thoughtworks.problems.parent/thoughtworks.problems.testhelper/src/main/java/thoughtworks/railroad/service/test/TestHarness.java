package thoughtworks.railroad.service.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.utils.FileUtil;
import thoughtworks.problems.utils.CityMapFactory;
import thoughtworks.problems.utils.Pair;
import thoughtworks.railroad.service.TrainRouteService;

/**
 * Class to test the application using input graph file
 * 
 * @author tbansal
 *
 */
public class TestHarness {

	private static TrainRouteService service = TrainRouteService.getInstance();

	public static void main(String[] args) {

		if (args.length < 2) {
			throw new IllegalArgumentException("Please provide input files");
		}

		String testFile = args[0];
		String outputFile = args[1];
		List<Object> output = new ArrayList<>();

		Pair<List<String>, List<String>> data = null;
		CityMap map = null;
		try {
			data = FileUtil.getGraphMetaData(testFile);
			map = CityMapFactory.createMap(data.getLeft());
			List<String> tests = data.getRight();

			for (String test : tests) {
				try {
					String testData[] = test.split(",");

					TestCases key = TestCases.values()[Integer.parseInt(testData[0])];
					switch (key) {
					case FINDDISTANCE:
						String[] arguments = new String[testData.length - 1];
						System.arraycopy(testData, 1, arguments, 0, testData.length - 1);
						output.add(service.findDistance(map, arguments));
						break;
					case FINDSHORTESTROUTE:
						output.add(service.findShortestRoute(testData[1], testData[2], map));

						break;
					case FINDSHORTESTDISTANCE:
						output.add(service.findShortestDistance(testData[1], testData[2], map));

						break;
					case FINDNOOFROUTEWITHSTATIONS:
						output.add(service.findRoutesWithAbsTowns(testData[1], testData[2],
								Integer.parseInt(testData[3]), map));

						break;
					case FINDNOOFROUTEWITHMAXSTATIONS:
						output.add(service.findRoutesWithTowns(testData[1], testData[2], Integer.parseInt(testData[3]),
								map));

						break;
					case FINDNOOFROUTEWITHMAXDISTANCE:
						output.add(service.findRoutesWithMaxDistance(testData[1], testData[2],
								Integer.parseInt(testData[3]), map));

						break;

					default:
						break;
					}
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage());
					System.out.println("Please provide file in correct format");
				} catch (Exception e) {
					System.err.println(e.getMessage());
					System.out.println("Please provide file in correct format");
				}

			}
			FileUtil.writeOutput(output, outputFile);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// @formatter:off
	public enum TestCases {
		FINDDISTANCE("FINDDISTANCE"), 
		FINDSHORTESTROUTE("FINDSHORTESTROUTE"), 
		FINDSHORTESTDISTANCE("FINDSHORTESTDISTANCE"), 
		FINDNOOFROUTEWITHSTATIONS("FINDNOOFROUTEWITHSTATIONS"), 
		FINDNOOFROUTEWITHMAXSTATIONS("FINDNOOFROUTEWITHMAXSTATIONS"), 
		FINDNOOFROUTEWITHMAXDISTANCE("FINDNOOFROUTEWITHMAXDISTANCE");
		
		String name;

		private TestCases(String name) {
			this.name = name;
		}
		
		
	}
	
	// @formatter:on

}
