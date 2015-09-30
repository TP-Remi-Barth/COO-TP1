import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	
	/**
	 * List of the items
	 */
	private List<IItem> items;
	
	public Inventory(){
		this.items = new LinkedList<IItem>();
	}
	
	/**
	 * Submit a 'inventory' command to the inventory
	 * This method list the entire inventory, or just lookup
	 * some particular items
	 * @return a text representation of the inventory
	 */
	public String list(Command cmd){
		
		if (cmd.count() <= 1){
			return this.listAll();
		}
		
		if (cmd.paramIsIn(1, Arrays.asList("keys", "key"))){
			return this.listKeys(cmd);
		}
		
		return this.listSyntaxError(cmd);
	}
	
	private String listSyntaxError(Command cmd) {
		return "Your bag says: \"Quezako ?\"";
	}

	private String listKeys(Command cmd) {
		String result = "Your bag says: \"I'm looking for your keys, wait...\"\n";
		List<Key> keys = this.getKeys();
		if (keys.size() == 0){
			result += "You have no key :(";
		}
		else {
			for (Key key : keys){
				result += "\t- " + key.getName() + ": " + key.describe() + "\n";
			}
			result += "Nothing more.";
		}
		return result;
	}

	private String listAll() {
		String result = "";
		if (this.items.size() == 0){
			result += "You don't have any item";
		}
		else {
			result += "You have these items in your bag:\n";
			for (IItem item : this.items){
				result += "\t- " + item.getName() + ": " + item.describe() + "\n";
			}
			result += "No more item.";
		}
		return result;
	}
	
	/**
	 * @return the list of item of type Key in the inventory
	 */
	public List<Key> getKeys() {
		LinkedList<Key> keys = new LinkedList<Key>();
		for (IItem item : this.items){
			if (item instanceof Key){
				keys.add((Key)item);
			}
		}
		return keys;
	}
	
	/**
	 * Add an item to the inventory
	 * @param item
	 */
	public void addItem(IItem item){
		this.items.add(item);
	}
}
