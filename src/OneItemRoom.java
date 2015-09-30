import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author barth
 *
 */
public class OneItemRoom extends BasicRoom {

	private IItem item;
	
	/**
	 * Create a room that contains one item
	 * @param passages
	 * @param item
	 */
	public OneItemRoom(List<IPassage> passages, IItem item) {
		super(passages);
		this.item = item;
	}

	@Override
	public String take(Command cmd) {
		if (this.item == null){
			return super.take(cmd);			
		}
		else if (cmd.count() == 1 || cmd.paramIsIn(1,
					Arrays.asList("item", this.item.getName()))){
			this.player.getInventory().addItem(this.item);
			String result = "you have take " + this.item.getName()
				+ " (" + this.item.describe() + ")"; 
			this.item = null;
			return result;
		}
		else {
			return "There's no " + cmd.getParam(1) + "in this room";
		}
	}

	@Override
	protected String describeItems() {
		if (this.item == null){
			return super.describeItems();
		}
		else {
			return "You see one item: "
					+ this.item.getName() + ": "
					+ this.item.describe();
		}
	}
}
