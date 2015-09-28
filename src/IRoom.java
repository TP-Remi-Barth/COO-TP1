public interface IRoom {

	public static class GoResult {
		
	}
	
	public String take(Command cmd);
	
	public String hit(Command cmd);
	
	public String describe(Command cmd);
	
	public String push(Command cmd);
	
	public String trySomething(Command cmd);
	
	public GoResult go(Command cmd);
	
}
