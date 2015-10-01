
/**
 * Class for the key item
 */
public class Key implements IItem {
	
	protected String name;
	protected String description;
	
	/**
	 * Create a key
	 * @param name the reliable name of the key
	 * @param description the description of the key
	 */
	public Key(String name, String description){
		this.name = name;
		this.description = description;
	}

	@Override
	public String describe() {
		return this.description;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String use(IGameObject gameObject) {
		if (gameObject instanceof IPassage){
			IPassage passage = (IPassage)gameObject;
			if (!passage.isLocked()){
				return "this passage isn't actually locked...";
			}
			else if (!passage.tryUnlock(this)){
				return "this doesn't appear to work...";
			}
			else {
				return "this key works, the passage is open now !";
			}
		}
		else {
			return "this has not had any effect";
		}
	}
}
