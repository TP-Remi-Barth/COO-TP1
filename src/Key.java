
/**
 * See the IItem interface for a complete documentation
 * @author barth
 */
public class Key implements IItem {
	
	protected String name;
	
	public Key(String name){
		this.name = name;
	}
	
	@Override
	public String describe() {
		return "a dirty and rusted key";
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
