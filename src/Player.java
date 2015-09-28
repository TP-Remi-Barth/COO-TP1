
public class Player implements IGameObject {

	private String name;
	private String smallBiography;
	
	private Inventory inventory;
	
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
}
