import java.util.List;

public class ExitRoom extends BasicRoom {

	public ExitRoom(List<IPassage> passages) {
		super(passages);
	}

	public boolean isExit(){
		return true;
	}
	
}
