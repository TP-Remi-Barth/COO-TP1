
public class Dungeon {

	private IRoom currentRoom;
	
	public void setCurrentRoom(IRoom room){
		currentRoom = room;
	}
	
	public IRoom getCurrentRoom(){
		return currentRoom;
	}

	public void interpretCommand(){
	}
	
	public boolean dungeonIsFinished(){
		return false;
	}
	
	public boolean dungeonIsLost(){
		return false;
	}
	
	public boolean dungeonIsWon(){
		return false;
	}
}
