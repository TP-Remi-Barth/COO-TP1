
public class Game {
	
	private Dungeon[] dungeons;
	private int currentDungeonIndex;
	private Player player;
		
	private boolean stop;
	
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
			
			String cmd = this.fetchUserCommand();
			dungeon.interpretCommand(cmd);
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

	private String fetchUserCommand() {
		return null;
	}
}
