import java.util.List;

public class BasicRoom implements IRoom {

	List<IPassage> passages;
	
	public BasicRoom(List<IPassage> passages) {
		this.passages = passages;
	}

	public String take(Command cmd) {
		return null;
	}
	
	public String hit(Command cmd) {
		return null;
	}
	
	public String describe(Command cmd) {
		
		if(cmd.getParam(1)==null){
			
		String describePassages = "";
		for (IPassage p : passages) {
			describePassages += p.getName() + " and ";
		}
		return "you see " + describePassages + 
				"nothing else. You really thought there was infinite things in there ?";
	
		}
		return IRoom.ErrorMessage;
	}
	
	public String push(Command cmd) {
		return null;
	}
	
	public String trySomething(Command cmd) {
		return null;
	}
	
	public GoResult go(Command cmd) {
		
		if (cmd.getParam(1) != null) {
			
			for (IPassage p : passages) {
				
				if (cmd.getParam(1) == p.getName()) {
					
					IRoom otherRoom = p.getOtherSideRoom(this);
					
					if(otherRoom != null) {
						return new GoResult(otherRoom, otherRoom.describe(new Command("describe")));			
					}
					
				}
			
			}
			
		}
		
		return null;
	}
}