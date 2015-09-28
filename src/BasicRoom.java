import java.util.List;

public class BasicRoom implements IRoom {

	List<IPassage> passages;
	
	BasicRoom(List<IPassage> passages) {
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
		return null;
	}
	
}
