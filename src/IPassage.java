
public interface IPassage extends IGameObject {

	public IRoom[] getTwoRooms();
	public IRoom getOtherSideRoom(IRoom here);
	
	public IRoom setTwoRooms(IRoom room1, IRoom room2);

	public boolean isLocked();
	public boolean tryUnlock(IItem item);
	
}
