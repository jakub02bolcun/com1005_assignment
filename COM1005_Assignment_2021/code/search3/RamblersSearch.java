
public class RamblersSearch extends Search {

	private TerrainMap map; // the map that we will be searching
   // private int[][] goal; 
    private Coords goal; // the goal coordinate
    
    public TerrainMap getMap() {
    	return map;
    }
    
    public Coords getGoal() {
        return goal;
    }
    
    public RamblersSearch(TerrainMap m, Coords g) {
        map = m;
        goal = g;    
    }    
	
}
