import java.util.Arrays;
import java.util.List;

/**
 * A basic room that contains a list of passages.
 */
public class BasicRoom implements IRoom {

	protected List<IPassage> passages;
	protected Player player = null;
	protected String name;
	
	/**
	 * Create a BasicRoom with a list of passages and a name
	 * @param passages the list of passage
	 * @param name the name of the room (can be null)
	 */
	public BasicRoom(List<IPassage> passages, String name) {
		this.passages = passages;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setPlayer(Player player){
		this.player = player;
	}
	
	@Override
	public boolean isExit(){
		return false;
	}
	
	@Override
	public String take(Command cmd) {
		return "That did not work";
	}
	
	@Override
	public String hit(Command cmd) {
		return "Wait for the next level";
	}
	
	@Override
	public String describe(Command cmd) {
		
		String result = "";
		
		if(cmd.getParam(1) == null){
			result = this.describeAll();
		}
		else if (cmd.paramIsIn(1, Arrays.asList("passage", "passages"))){
			result = this.describePassages();
		}
		else if (cmd.paramIsIn(1, Arrays.asList("item", "items"))){
			result = this.describeItems();
		}
		return result;
	}

	/**
	 * Protected method that describe the items in the room.
	 * This method is used by BasicRoom.describe and might be override by
	 * child-classes.
	 * @return the string that describes the items
	 */
	protected String describeItems() {
		return "There is no item in this room";
	}

	/**
	 * Protected method that describe the passages of the room.
	 * This method is used by BasicRoom.describe and might be override by
	 * child-classes.
	 * @return the string that describes the passages
	 */
	protected String describePassages() {
		if (passages.size() == 0){
			return "there is no passage";
		}
		else {
			String describePassages = "You see some passages:\n";
			for (IPassage p : passages) {
				describePassages += "\t- " + p.getName() + ": " + p.describe() + "\n";
			}
			describePassages += "No more pasage";
			return describePassages;
		}
	}

	/**
	 * Describes passages, then items.
	 * @return the description string
	 */
	protected String describeAll() {
		return this.describePassages() + "\n" + this.describeItems();
	}
	
	@Override
	public String push(Command cmd) {
		return "";
	}
	
	@Override
	public String trySomething(Command cmd) {
		if (cmd.count() <= 1){
			return "Try what ?";
		}
		String what = cmd.getParam(1);
		if (what.equals("keys") || what.equals("key")){
			if (cmd.count() <= 2){
				return "Try keys on which passage ?";
			}
			IPassage passage = this.getPassageByName(cmd.getParam(2));
			if (passage == null){
				return "I don't know this passage";
			}
			else if (passage.isLocked() == false){
				return "This passage isn't locked";
			}
			
			String result = "";
			for (Key key: this.player.getInventory().getKeys()){
				result += "trying " + key.getName() + "...\n";
				key.use(passage);
				if (passage.isLocked() == false){
					return result + "Congratulation ! You have unlock the passage with the key '"
							+ key.getName() + "' !";
				}
			}
			return result + "It looks like you don't have the good key...";
		}
		else {
			return "Try what ?";
		}
	}
	
	@Override
	public GoResult go(Command cmd) {
		if (cmd.getParam(1) != null) {
			for (IPassage p : passages) {
				if (cmd.getParam(1).equals(p.getName())) {
					if (p.isLocked()) {
						return new GoResult(this, "Impossible, the passage is locked");
					}
					else {
						IRoom otherRoom = p.getOtherSideRoom(this);
						if(otherRoom != null) {
							return new GoResult(otherRoom,
								"You arrive in a new room . " + 
							otherRoom.describe(new Command("describe")));	
						}
					}
				}
			}
		}
		return new GoResult(null, "Go where ? I don't know that place.");
	}
	
	/**
	 * Get a passage by its name
	 * @param name
	 * @return the passage or null if it doesn't exist
	 */
	protected IPassage getPassageByName(String name){
		for (IPassage passage : this.passages){
			if (passage.getName().equals(name)){
				return passage;
			}
		}
		return null;
	}
}
