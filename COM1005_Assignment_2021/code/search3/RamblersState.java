import java.util.ArrayList;

public class RamblersState extends SearchState {

	// coordinate for current state
	private Coords coordinate;
	
	// constructor
	public RamblersState(Coords coordinates, int lc) {
		coordinate = coordinates;
		localCost = lc;
	}
	
	// accessor
	public Coords getCoordinate() {
		return coordinate;
	}
	
	@Override // goal predicate
	public boolean goalPredicate(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
		Coords target = msearcher.getGoal();
		return (coordinate == target);
	}

	@Override // get successors
	public ArrayList<SearchState> getSuccessors(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
		TerrainMap map = msearcher.getMap();
		ArrayList<SearchState> successors = new ArrayList<SearchState>();
		
		Coords current = coordinate;
		int currentx = current.getx();
		int currenty = current.gety();
		int maxX = map.getWidth();
		int maxY = map.getDepth();
		
		// East successor
		if (!(currentx+1 == maxX)) {
			Coords successor = new Coords(currenty, currentx+1);
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx+1]));
		}
		
		// West successor
		if (!(currentx-1 == -1)) {
			Coords successor = new Coords(currenty, currentx-1);
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx-1]));
		}
		
		// North successor
		if (!(currenty+1 == maxY)) {
			Coords successor = new Coords(currenty+1, currentx);
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty+1][currentx]));
		}
		
		// South successor
		if (!(currenty-1 == -1)) {
			Coords successor = new Coords(currenty-1, currentx);
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty-1][currentx]));
		}		
		
		return successors;
	}

	@Override // return true if same states
	public boolean sameState(SearchState s2) {
		RamblersState rs2 = (RamblersState) s2;
		return (coordinate == rs2.getCoordinate());		
	}
	
	// toString
	public String toString() {
        return ("Coordinates: " + coordinate);
    }

}
