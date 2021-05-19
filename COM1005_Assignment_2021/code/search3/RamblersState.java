import java.util.ArrayList;

public class RamblersState extends SearchState {

	// coordinate for current state
	private Coords coordinate;
	
	// constructor
	public RamblersState(Coords stateCoordinate, int lc) {
		coordinate = stateCoordinate;
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
		
		
		return null;
	}

	@Override
	boolean sameState(SearchState n2) {
		// TODO Auto-generated method stub
		return false;
	}

}
