
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
		return this.isWon() || this.isLost();
	}
	public boolean isWon(){
		return this.player.isAlive() &&
			this.currentRoom != null && this.currentRoom.isExit();
	}
	public boolean isLost(){
		return this.player.isDead();
	}
	
	public String interpretCommand(Command cmd){
		
		String resultString;
		
		this.currentRoom.setPlayer(this.player);
		
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
			resultString = this.currentRoom.trySomething(cmd);
			break;

		case "inventory":
			resultString = this.player.getInventory().list(cmd);
			break;
		
		case "go":
			IRoom.GoResult goResult = this.currentRoom.go(cmd);
			if (goResult.hasSucceeded()){
				this.currentRoom = goResult.getRoom();
			}
			resultString = goResult.getString();
			break;
		
		case "":
			resultString = "You are not really talkative...";
			break;
		
		default:
			resultString =  "Invalid command " + cmd.getName(); 
		}
		
		return resultString;
	}
	
	
}
