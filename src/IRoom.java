public interface IRoom {

	public static class GoResult {
		
		private IRoom room;
		private String description;
		
		GoResult(IRoom room, String description){
			this.setRoom(room);
			this.description = description;
		}
		
		public IRoom getRoom() {
			return room;
		}

		public void setRoom(IRoom room) {
			this.room = room;
		}

		public boolean hasSuceeded() {
			if (this.getRoom() != null) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public String getString() {
			return this.description;
		}
		
	}
	
	public static final String ErrorMessage = "Repeat again, I didn't understand.";

	public String take(Command cmd);
	
	public String hit(Command cmd);
	
	public String describe(Command cmd);
	
	public String push(Command cmd);
	
	public String trySomething(Command cmd);
	
	public GoResult go(Command cmd);
	
}
