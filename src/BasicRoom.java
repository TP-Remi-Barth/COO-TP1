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
		
		if (cmd.getParam(1) != null) {
			
			for (IPassage p : passages) {
				
				if (cmd.getParam(1).equals(p.getName())) {
					
					IRoom otherRoom = p.getOtherSideRoom(this);
					
					if(otherRoom != null) {
						return new GoResult(otherRoom,
							otherRoom.describe(new Command("describe")));			
					}
					
				}
			
			}
			
		}
		
		return new GoResult(null, "invalid syntax");
	}
}
