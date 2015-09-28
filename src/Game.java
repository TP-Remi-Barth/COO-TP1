
public class Game {
	
	private Dungeon[] dungeons;
	private Player player = null;

	private int currentDungeonIndex = 0;
	private boolean stop = false;
	
	public Game(Dungeon[] dungeons, Player player){
		this.dungeons = dungeons;
		this.player = player;
	}
	
	public Dungeon getCurrentDungeon(){
		return this.dungeons[this.currentDungeonIndex];
	}
	
	public void run(){
	
		this.currentDungeonIndex = 0;
		this.stop = false;
		
		while (this.currentDungeonIndex < dungeons.length && !this.stop){
			
			if (this.runCurrentDungeon() == false){
				this.stop = true;
			}
			else {
				this.currentDungeonIndex += 1;
				// TODO: ask if the player want to continue
			}
		}
	}

	private boolean runCurrentDungeon() {
		Dungeon dungeon = this.getCurrentDungeon();
		
		dungeon.setPlayer(this.player);
		
		while (!dungeon.isFinished()){
			
			Command cmd = this.fetchUserCommand();
			String outputString = dungeon.interpretCommand(cmd);
			this.showOutputStringToUser(outputString);
			
		}
		
		if (dungeon.isWon()){
			// TODO: write something
			return true;
		}
		else {
			// TODO: write something
			return false;
		}
		
	}

	private void showOutputStringToUser(String outputString) {
	}

	private Command fetchUserCommand() {
		return null;
	}
}
