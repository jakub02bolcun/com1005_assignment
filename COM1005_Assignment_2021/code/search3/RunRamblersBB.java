
public class RunRamblersBB {

	public static void main(String[] arg) {
		TerrainMap map1 = new TerrainMap("code/search3/tmc.pgm");
		Coords goalCoords = new Coords(8, 5);
		Coords initCoords = new Coords(0, 7);
		
		RamblersSearch searcher = new RamblersSearch(map1, goalCoords);
		SearchState initState = (SearchState) new RamblersState(initCoords, 0);
		
		String res_bb = searcher.runSearch(initState, "branchAndBound");
		//System.out.println(res_bb);
		
	}
}
