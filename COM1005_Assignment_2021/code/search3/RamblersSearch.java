
public class RamblersSearch extends Search {

	private TerrainMap map; // the map that we will be searching
    private Coords goal; // the goal coordinate
    
    // getter method for map
    public TerrainMap getMap() {
    	return map;
    }
    
    // getter method for goal
    public Coords getGoal() {
        return goal;
    }
    
    // constructor
    public RamblersSearch(TerrainMap m, Coords g) {
        map = m;
        goal = g;    
    }    
	
}
