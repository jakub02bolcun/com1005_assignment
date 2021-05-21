import java.util.Random;

public class RunRamblersBB {

	public static void main(String[] arg) {
		
		// assign random cooridnates to start and end points
		Random rand = new Random();
		int goalx = rand.nextInt(252);
		int goaly = rand.nextInt(249);
		int initx = rand.nextInt(252);
		int inity = rand.nextInt(249);		
		
		// create new map object
		TerrainMap map1 = new TerrainMap("code/search3/diablo.pgm");
		
		// set coordinates
		Coords goalCoords = new Coords(goaly, goalx);
		Coords initCoords = new Coords(inity, initx);
		
		// set goal and initial state
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0);
		
		// start search and display efficiency
		float res_bb = searcher.runSearchE(initState, "BranchAndBound");
		System.out.println(res_bb);
		
	}
}
