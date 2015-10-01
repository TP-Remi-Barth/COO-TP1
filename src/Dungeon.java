/**
 * The dungeon class
 */
public class Dungeon {

	private IRoom currentRoom = null;
	private Player player = null;
	
	/**
	 * Create a dungeon
	 * @param firstRoom the entrance of the dungeon
	 */
	public Dungeon(IRoom firstRoom){
		this.currentRoom = firstRoom;
	}
	
	/**
	 * Set the player
	 * @param player
	 */
	public void setPlayer(Player player){
		this.player = player;
	}
	
	/**
	 * @return true if the dungeon is over
	 */
	public boolean isFinished(){
		return this.isWon() || this.isLost();
	}
	
	/**
	 * @return true if the player has won
	 */
	public boolean isWon(){
		return this.player.isAlive() &&
			this.currentRoom != null && this.currentRoom.isExit();
	}
	
	/**
	 * @return true if the player has lost
	 */
	public boolean isLost(){
		return this.player.isDead();
	}
	
	/**
	 * Interpret a command
	 * @param cmd the command to interpret
	 * @return a string that describes what happened
	 */
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
