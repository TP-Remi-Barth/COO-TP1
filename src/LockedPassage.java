/**
 * A passage that is locked. Need a key to unlock it.
 */
public class LockedPassage extends BasicPassage {

	protected boolean locked = true;
	protected String keyName;
	
	/**
	 * Create a LockedPassage
	 * @param name
	 * @param description
	 * @param keyName the name of the key that unlocks the passage
	 */
	public LockedPassage(String name, String description, String keyName) {
		super(name, description);
		this.keyName = keyName;
	}
	
	@Override
	public String describe(){
		return this.description + (this.locked ? "(locked)" : "(unlocked)");
	}
	
	/**
	 * Unlock the passage without key (for convenience, not used by player)
	 */
	public void forceUnlock(){
		this.locked = false;
	}

	/**
	 * Lock the passage without key (for convenience, not used by player)
	 */	
	public void forceLock(){
		this.locked = true;
	}
	
	@Override
	public boolean isLocked(){
		return this.locked;
	}
	
	@Override
	public boolean tryUnlock(IItem item){
		if (item instanceof Key){
			Key key = (Key)item;
			if (key.getName().equals(this.keyName)){
				this.forceUnlock();
				return true;
			}
		}
		return false;
	}
}
