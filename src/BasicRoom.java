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
	
	@Override
	public String push(Command cmd) {
		return null;
	}
	
	@Override
	public String trySomething(Command cmd) {
		return null;
	}
	
	@Override
	public GoResult go(Command cmd) {
		return null;
	}
}
