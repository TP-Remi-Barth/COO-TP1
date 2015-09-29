import org.junit.experimental.theories.Theories;

/**
 * See the IPassage documentation
 * @author barth
 */
public class LockedPassage extends BasicPassage {

	protected boolean locked = true;
	protected String keyName;
	
	/**
	 * Create a LockedPassage
	 * @param name
	 * @param keyName the name of the key that unlocks the passage
	 */
	public LockedPassage(String name, String keyName) {
		super(name);
		this.keyName = keyName;
	}
	
	@Override
	public String describe(){
		return "The " + this.getName() + " is locked";
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
			return key.getName().equals(this.keyName);
		}
		return false;
	}
}
