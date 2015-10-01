import java.util.Arrays;
import java.util.Scanner;

/**
 * The core class. It contains multiple chained dungeons.
 * This class manage player, the game loop, the user inputs and outputs, etc.
 */
public class Game {
	
	private Dungeon[] dungeons;
	private Player player = null;

	private int currentDungeonIndex = 0;
	private boolean stop = false;
	
	private Scanner scanner;
	
	/**
	 * Create a game
	 * @param dungeons the chain of dungeon
	 * @param player the player
	 */
	public Game(Dungeon[] dungeons, Player player){
		this.dungeons = dungeons;
		this.player = player;
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * @return the current dungeon which the player is in.
	 */
	public Dungeon getCurrentDungeon(){
		return this.dungeons[this.currentDungeonIndex];
	}
	
	/**
	 * run the main loop
	 */
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
		
		if (this.stop){
			this.showOutputStringToUser("Game Over");
		}
		else {
			this.showOutputStringToUser("End of Game. You win !");
		}
	}

	/**
	 * One dungeon loop
	 * @return true if the dungeon has been successfully crossed
	 */
	private boolean runCurrentDungeon() {
		Dungeon dungeon = this.getCurrentDungeon();
		
		dungeon.setPlayer(this.player);
		this.showOutputStringToUser(
				dungeon.interpretCommand(new Command("describe")));

		while (!dungeon.isFinished()){
			
			Command cmd = this.fetchUserCommand();
			String outputString = dungeon.interpretCommand(cmd);
			this.showOutputStringToUser(outputString);
			
		}
		
		if (dungeon.isWon()){
			this.showOutputStringToUser("You have succesfully cross the dungeon!");
			return true;
		}
		else {
			this.showOutputStringToUser("Sorry, you're dead...");
			return false;
		}
		
	}

	/**
	 * Show a string to the user (for the moment on stdout), add a new line.
	 * @param outputString the string to show
	 */
	private void showOutputStringToUser(String outputString) {
		System.out.println(outputString);
	}

	/**
	 * Get a user command (for the moment on stdin)
	 * @return the user command
	 */
	private Command fetchUserCommand() {
		System.out.print("?> ");
		String line = scanner.nextLine();
		return new Command(line);
	}
	
	/**
	 * Main test with a dummy dungeon
	 * @param argv command line arguments
	 */
	public static void main(String[] argv){
		
		Player player = new Player("Barth", "the boss is not me");

		IPassage passage1 = new BasicPassage("door", "a simple wood door");
		IPassage passage2 = new LockedPassage("locked-door", "a fat iron door", "golden-key");
		IPassage passage3 = new BasicPassage("tunnel",
				"a long and earthy tunnel");
		
		IItem key1 = new Key("golden-key", "a golden but dirty key, seems very old");
		
		IRoom room1 = new BasicRoom(Arrays.asList(passage1, passage3), null);
		IRoom room2 = new BasicRoom(Arrays.asList(passage1, passage2), null);
		IRoom room3 = new OneItemRoom(Arrays.asList(passage3), key1);
		IRoom roomE = new ExitRoom(Arrays.asList(passage2));

		passage1.setTwoRooms(room1, room2);
		passage2.setTwoRooms(room2, roomE);
		passage3.setTwoRooms(room1, room3);
		
		Dungeon dungeon1 = new Dungeon(room1);
		Dungeon[] dungeons = new Dungeon[]{ dungeon1 };
		
		Game game = new Game(dungeons, player);
		
		game.run();
	}
}
