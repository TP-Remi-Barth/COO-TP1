public interface IRoom {

	public static class GoResult {
		
		private IRoom room;
		private String description;
		
		public GoResult(IRoom room, String description){
			this.setRoom(room);
			this.description = description;
		}
		
		public IRoom getRoom() {
			return room;
		}

		public void setRoom(IRoom room) {
			this.room = room;
		}
		
		public String getString() {
			return this.description;
		}

		public boolean hasSucceeded() {
			if (this.getRoom() != null) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
	public static final String ErrorMessage = "Repeat again, I didn't understand.";

	public void setPlayer(Player player);
	
	public boolean isExit();
	
	public String take(Command cmd);
	
	public String hit(Command cmd);
	
	public String describe(Command cmd);
	
	public String push(Command cmd);
	
	public String trySomething(Command cmd);
	
	public GoResult go(Command cmd);
	
}
