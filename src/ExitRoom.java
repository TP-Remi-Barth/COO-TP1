import java.util.List;

/**
 * The exit room. When the player reaches it, he wins !
 */
public class ExitRoom extends BasicRoom {

	/**
	 * Create an exit room
	 * @param passages the list of passages of the room
	 */
	public ExitRoom(List<IPassage> passages) {
		super(passages, null);
	}

	@Override
	public boolean isExit(){
		return true;
	}
}
