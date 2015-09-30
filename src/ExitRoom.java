import java.util.List;

public class ExitRoom extends BasicRoom {

	public ExitRoom(List<IPassage> passages) {
		super(passages, null);
	}

	public boolean isExit(){
		return true;
	}
	
}
