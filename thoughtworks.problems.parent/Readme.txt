How to run:

1. Junit Test:
Application has a junit test 

/thoughtworks.problems.service/src/test/java/thoughtworks/problems/train/FindRouteServiceTest.java

2. Run class Main thoughtworks.railroad.service.test.TestHarness with arguments:

1. graph file 
2. output file

example:
 
java thoughtworks.railroad.service.test.TestHarness /home/tbansal/java/repo/thoughtworks.problems.parent/GraphTest1 /home/tbansal/java/repo/thoughtworks.problems.parent/GraphTestResult

3. Run jar :

Run 
java -jar RouteFinder.jar /home/tbansal/java/repo/thoughtworks.problems.parent/GraphTest1 /home/tbansal/java/repo/thoughtworks.problems.parent/GraphTestResult

Logging configurations:

use houghtworks.problems.parent/thoughtworks.problems.common/src/main/resources/thoughtworks/configs/log4j.xml for logging configurations.

Technical Details:

1. Modified version fo Dijkstra has been used to find shortest path. It is a variance of Dijkstra which traverse paths starting and ending on same node.It can be replaced by Floyd-warshall if  caching can be used.
2. A version of DFS has been used to find the path satisfying a condition.

