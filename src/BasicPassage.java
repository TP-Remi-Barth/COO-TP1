
/**
 * See the IPassage documentation
 * @author barth
 */
public class BasicPassage implements IPassage {

	protected String description = "a cold and dark passage";
	protected String name;
	protected IRoom room1 = null;
	protected IRoom room2 = null;
	
	/**
	 * Create a BasicPassage with a name, a default description,
	 * and no rooms.
	 * @param name
	 */
	public BasicPassage(String name){
		this.name = name;
	}
	
	public static BasicPassage createWithDescription(
			String name, String description){
		BasicPassage passage = new BasicPassage(name);
		passage.description = description;
		return passage;
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
	public IRoom[] getTwoRooms() {
		return new IRoom[]{ this.room1, this.room2 };
	}

	@Override
	public IRoom getOtherSideRoom(IRoom here) {
		if (here == this.room1){
			return this.room2;
		}
		else if (here == this.room2){
			return this.room1;
		}
		else {
			return null;
		}
	}

	@Override
	public void setTwoRooms(IRoom room1, IRoom room2) {
		this.room1 = room1;
		this.room2 = room2;
	}

	@Override
	public boolean isLocked() {
		return false;
	}

	@Override
	public boolean tryUnlock(IItem item) {
		return false;
	}

}
