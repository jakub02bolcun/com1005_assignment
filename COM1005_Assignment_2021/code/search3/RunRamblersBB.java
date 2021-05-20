
public class RunRamblersBB {

	public static void main(String[] arg) {
		TerrainMap map1 = new TerrainMap("code/search3/diablo.pgm");
		Coords goalCoords = new Coords(0, 0);
		Coords initCoords = new Coords(43, 54);
		
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0);
		
		float res_bb = searcher.runSearchE(initState, "branchAndBound");
		System.out.println(res_bb);
		
		
	}
}
