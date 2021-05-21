import java.util.Random;
import java.lang.Math;

public class RunRamblersAstar {
	
	public static void main(String[] arg) {
		
		
		Random rand = new Random();
		int goalx = rand.nextInt(252);
		int goaly = rand.nextInt(249);
		int initx = rand.nextInt(252);
		int inity = rand.nextInt(249);

		
		TerrainMap map1 = new TerrainMap("code/search3/diablo.pgm");
		Coords goalCoords = new Coords(goaly, goalx);
		Coords initCoords = new Coords(inity, initx);
		
		/*
		// A* HEIGHT 
		int initHeight = map1.getTmap()[inity][initx];
		int goalHeight = map1.getTmap()[goaly][goalx];
		int remEstCost = goalHeight - initHeight;
		*/
		
		// A* Euclidean distance
		int xdiff;
		int ydiff;
		// difference in x
		if (initx > goalx) {
			xdiff = initx - goalx;
		} else if (initx < goalx) {
			xdiff = goalx - initx;
		} else {
			xdiff = 0;
		}
		// difference in y
		if (inity > goaly) {
			ydiff = inity - goaly;
		} else if (inity < goaly) {
			ydiff = goaly - inity;
		} else {
			ydiff = 0;
		}
		// math operators to square root and round down
		double pythagoras = (xdiff * xdiff) + (ydiff * ydiff);
		pythagoras = Math.sqrt(pythagoras);
		pythagoras = Math.floor(pythagoras);
		int remEstCost = (int) pythagoras;
		// END OF A* Euclidean distance
		
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0, remEstCost);
		
		// show strings
		// String res_bb = searcher.runSearch(initState, "AStar");
		// only efficiency
		float res_bb = searcher.runSearchE(initState, "AStar");
		System.out.println(res_bb);
		
	}

}
