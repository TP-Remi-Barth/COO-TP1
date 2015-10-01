/**
 * Interface for the rooms
 */
public interface IRoom {
	
	/**
	 * Here is a class into another class
	 * The GoResult class is needed to return two object in the method "go"
	 */
	public static class GoResult {
		
		private IRoom room;
		private String description;
		
		/**
		 * Create a IRoom.GoResult
		 * @param room the new room or null if the go has failed
		 * @param description the description of what happened
		 */
		public GoResult(IRoom room, String description){
			this.setRoom(room);
			this.description = description;
		}
		
		/**
		 * @return the new room
		 */
		public IRoom getRoom() {
			return room;
		}

		/**
		 * set the new room or null
		 * @param room the room
		 */
		public void setRoom(IRoom room) {
			this.room = room;
		}
		
		/**
		 * @return the description string of what happened
		 */
		public String getString() {
			return this.description;
		}
		
		/**
		 * @return true if there is a room in GoResult
		 */
		public boolean hasSucceeded() {
			return this.getRoom() != null;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof GoResult)){
				return false;
			}
			GoResult other = (GoResult) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (room == null) {
				if (other.room != null)
					return false;
			} else if (!room.equals(other.room))
				return false;
			return true;
		}
		
	}
	/**
	 * The error message that receive the user when he says something wrong
	 */
	public static final String ErrorMessage = "Repeat again, I didn't understand.";
	
	/**
	 * @return the name of the room
	 */
	public String getName();

	/**
	 * Set the current player
	 * @param player the player
	 */
	public void setPlayer(Player player);
	
	/**
	 * 
	 * @return true if the room is the exit of the dungeon
	 */
	public boolean isExit();
	
	/**
	 * take an item in the room
	 * the syntax is : take {replace by the item you want to take}
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public String take(Command cmd);
	
	/**
	 * hit a monster in the room
	 * the syntax is : hit {replace by the monster you want to hit}
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public String hit(Command cmd);
	
	/**
	 * describe something
	 * the syntax is : describe {replace by the thing you want to know about}
	 * syntax : describe gives the description of the room
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public String describe(Command cmd);
	
	/**
	 * push a button in the room
	 * the syntax is : push {replace by the button you want to push}
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public String push(Command cmd);
	
	/**
	 * try an item on something in the room
	 * the syntax is : try {replace by the item you want to use} \
	 * {replace by the thing in the room you want to try}
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public String trySomething(Command cmd);
	
	/**
	 * go to a passage in the room
	 * the syntax is : go {replace by the passage you want to take}
	 * @param cmd A command typed by the user
	 * @return a string which describes what's going on
	 */
	public GoResult go(Command cmd);
}
