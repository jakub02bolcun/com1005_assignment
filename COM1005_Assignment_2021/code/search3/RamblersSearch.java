
public class RamblersSearch extends Search {

	private TerrainMap map; // the map that we will be searching
    private int[][] goal; // the goal pixel
    
    public TerrainMap getMap() {
    	return map;
    }
    
    public int[][] getGoal() {
        return goal;
    }
    
    public RamblersSearch(TerrainMap m, int[][] g) {
        map = m;
        goal = g;    
    }    
	
}
