
/**
 * Interface for passages
 */
public interface IPassage extends IGameObject {

	/**
	 * @return An array of the two rooms linked by the passage
	 */
	public IRoom[] getTwoRooms();
	
	/**
	 * Get the room at the other side of the parameter [code]here[/code]
	 * @param here
	 * @return the room or null if here is not one of
	 * 		the two rooms of the passage
	 */
	public IRoom getOtherSideRoom(IRoom here);
	
	/**
	 * Set the two rooms of the passage
	 * @param room1
	 * @param room2
	 */
	public void setTwoRooms(IRoom room1, IRoom room2);

	/**
	 * @return true if the passage is locked
	 */
	public boolean isLocked();
	
	/**
	 * Try to unlock the passage with an item 
	 * @param item
	 * @return true if that succeeded
	 */
	public boolean tryUnlock(IItem item);
}
