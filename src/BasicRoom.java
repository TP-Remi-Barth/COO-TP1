import IRoom.GoResult;

public class BasicRoom implements IRoom {

	List<Passage> passages;
	
	ARoomBasic(List<Passage> passages) {
		this.passages = passages;
	}

	public String take(Command cmd) {
		return null;
	}
	
	public String hit(Command cmd) {
		return null;
	}
	
	public String describe(Command cmd) {
		String describePassages =
				for (Passage p : passages) {
					p.getName() + " and ";
				}
		return "you see " + describePassages + "nothing else."
	}
	
	public String push(Command cmd) {
		return null;
	}
	
	public String trySomething(Command cmd) {
		return null;
	}
	
	public GoResult go(Command cmd) {
		return null;
	}
	
}
