
/**
 * Interface for all items
 */
public interface IItem extends IGameObject {
	
	/**
	 * Use the item on the gameObject
	 * @param gameObject the GameObject on which use the item
	 * @return the string describing what has happened
	 */
	public String use(IGameObject gameObject);

}
