import java.util.Random;

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
		int initHeight = map1.getTmap()[inity][initx];
		int goalHeight = map1.getTmap()[goaly][goalx];
		int remEstCost = goalHeight - initHeight;
		System.out.println(remEstCost);
		
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0, remEstCost);		
		
		// show strings
		//String res_bb = searcher.runSearch(initState, "AStar");
		// only efficiency
		float res_bb = searcher.runSearchE(initState, "AStar");
		System.out.println(res_bb);
		
	}

}
