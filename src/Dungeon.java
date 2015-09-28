
public class Dungeon {

	private IRoom currentRoom = null;
	private Player player = null;
	
	public Dungeon(IRoom firstRoom){
		this.currentRoom = firstRoom;
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public boolean isFinished(){
		return false;
	}
	public boolean isWon(){
		return false;
	}
	public boolean isLost(){
		return false;
	}
	
	public String interpretCommand(Command cmd){

		
		String resultString;
		
		switch (cmd.getName()){

		case "describe":
			resultString = this.currentRoom.describe(cmd);
			break;
	
		case "hit":
			resultString = this.currentRoom.hit(cmd);
			break;

		case "take":
			resultString = this.currentRoom.take(cmd);
			break;

		case "push":
			resultString = this.currentRoom.push(cmd);
			break;

		case "use":
			resultString = this.player.use(cmd);
			break;
			
		case "try": 
			resultString = this.currentRooom.trySomething(cmd);
			break;

		case "inventory":
			resultString = this.player.listInventory(cmd);
			break;
		
		case "go":
			Room.GoResult goResult = this.currentRoom.go(cmd);
			if (goResult.hasSucceeded()){
				this.currentRoom = goResult.getRoom();
			}
			resultString = goResult.getString();
			break;
			
		default:
			resultString =  cmd.getErrorMessage()
		}
		
		return resultString;
	}
	
	
}
