import java.util.ArrayList;

public class RamblersState extends SearchState {

	// coordinate for current state
	private Coords coordinate;
	
	// constructor for BB
	public RamblersState(Coords coordinates, int lc) {
		coordinate = coordinates;
		localCost = lc;
	}
	
	// constructor for A*
	public RamblersState(Coords coordinates, int lc, int rc) {
		coordinate = coordinates;
		localCost = lc;
		estRemCost = rc;		
	}
	
	
	// accessor
	public Coords getCoordinate() {
		return coordinate;
	}
	
	@Override // goal predicate
	public boolean goalPredicate(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
		Coords target = msearcher.getGoal();
		int x1 = coordinate.getx();
		int x2 = target.getx();
		int y1 = coordinate.gety();
		int y2 = target.gety();
		return ((x1 == x2) && (y1 == y2));
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
		int remainingCost = estRemCost;
		
		// East successor
		if (!(currentx+1 == maxX)) {
			Coords successor = new Coords(currenty, currentx+1);
			// BranchAndBound
			//successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx+1]));
			// A*
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx+1], remainingCost));
		}
		
		// West successor
		if (!(currentx-1 == -1)) {
			Coords successor = new Coords(currenty, currentx-1);
			// BranchAndBound
			//successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx-1]));
			// A*
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty][currentx-1], remainingCost));
		}
		
		// North successor
		if (!(currenty+1 == maxY)) {
			Coords successor = new Coords(currenty+1, currentx);
			// BranchAndBound
			//successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty+1][currentx]));
			// A*
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty+1][currentx], remainingCost));
		}
		
		// South successor
		if (!(currenty-1 == -1)) {
			Coords successor = new Coords(currenty-1, currentx);
			// BranchAndBound
			//successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty-1][currentx]));
			// A*
			successors.add((SearchState) new RamblersState(successor, map.getTmap()[currenty-1][currentx], remainingCost));
		}
		
		return successors;
	}

	@Override // return true if same statess
	public boolean sameState(SearchState s2) {
		RamblersState rs2 = (RamblersState) s2;
		//return (coordinate == rs2.getCoordinate());
		int x1 = coordinate.getx();
		int x2 = rs2.getCoordinate().getx();
		int y1 = coordinate.gety();
		int y2 = rs2.getCoordinate().gety();
		return ((x1 == x2) && (y1 == y2));
	}
	
	// toString
	public String toString() {
        return ("Coordinates: (" + coordinate.getx() + ", " + coordinate.gety() + ")");
    }

}
