import java.util.List;

public class BasicRoom implements IRoom {

	protected List<IPassage> passages;
	protected Player player = null;
	
	public BasicRoom(List<IPassage> passages) {
		this.passages = passages;
	}

	@Override
	public void setPlayer(Player player){
		this.player = player;
	}
	
	//Peut-être rajouter un addPassage à la room pour pouvoir faire apparaître des passages masqués
	
	@Override
	public boolean isExit(){
		return false;
	}
	
	@Override
	public String take(Command cmd) {
		return null;
	}
	
	@Override
	public String hit(Command cmd) {
		return null;
	}
	
	@Override
	public String describe(Command cmd) {
		
		if(cmd.getParam(1) == null){
			String describePassages = "";
			for (IPassage p : passages) {
				describePassages += p.getName() + " and ";
			}
			return "you see " + describePassages + "nothing else.";

		}
		return IRoom.ErrorMessage;
	}
	
	@Override
	public String push(Command cmd) {
		return null;
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
			
			for (Key key: this.player.getInventory().getKeys()){
				key.use(passage);
				if (passage.isLocked() == false){
					return "Congratulation ! You have unlock the passage with the key '"
							+ key.getName() + "' !";
				}
			}
			return "It looks like you don't have the good key...";
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
						return new GoResult(this, p.describe());
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
