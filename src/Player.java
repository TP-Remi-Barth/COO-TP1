
public class Player implements IGameObject {

	private String name;
	private String smallBiography;
	
	private Inventory inventory;
	
	private int lifePoints = 10;
	
	/**
	 * Create a player
	 * @param name
	 * @param bio
	 */
	public Player(String name, String bio){
		this.name = name;
		this.smallBiography = bio;
		this.inventory = new Inventory();
	}
	
	/**
	 * @return the name of the player
	 */
	@Override
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return the small biography of the player
	 */
	@Override
	public String describe(){
		return this.smallBiography;
	}

	/**
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Submit a 'use' command to the player
	 * @param cmd
	 * @return a string describing what happened
	 */
	public String use(Command cmd){
		return "";
	}
	
	/**
	 * @return true if the player is alive
	 */
	public boolean isAlive(){
		return lifePoints > 0;
	}
	
	/**
	 * @return true if the player is dead
	 */
	public boolean isDead(){
		return !this.isAlive();
	}
	
	/**
	 * Add n life points to the player
	 * @param n
	 * @return
	 */
	public void giveLifePoints(int n){
		this.lifePoints += n;
	}
	
	/**
	 * remove n life points to the player
	 * @param n
	 */
	public void removeLifePoints(int n){
		this.lifePoints -= n;	
	}

	/**
	 * @return the number of lifePoints of the player
	 */
	public int getLifePoints(){
		return this.lifePoints;
	}
}
