
public interface IRoom {

	public void setPlayer(Player player);
	public void unsetPlayer();
	
	public String getDescription();
	
	public String hit(String monsterName);
	
	public String take(String itemName);
	
	public String push(String buttonName);
	
	public String use(String itemName, String objectTypeName, String targetName);
}
