import java.util.Random;

public class RunRamblersBB {

	public static void main(String[] arg) {
		
		Random rand = new Random();
		int goalx = rand.nextInt(252);
		int goaly = rand.nextInt(249);
		int initx = rand.nextInt(252);
		int inity = rand.nextInt(249);
		
		TerrainMap map1 = new TerrainMap("code/search3/diablo.pgm");
		Coords goalCoords = new Coords(goaly, goalx);
		Coords initCoords = new Coords(inity, initx);
		
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0);
		
		float res_bb = searcher.runSearchE(initState, "BranchAndBound");
		System.out.println(res_bb);
		
	}
}
