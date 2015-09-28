public class Command {
	
	private String[] params;
	
	/**
	 * Create a Command object from a command line string
	 * @param commandLine A command line of the form : "name param1 param2 ..."
	 */
	public Command(String commandLine){
		this.params = commandLine.trim().split("\\s+");
	}

	/**
	 * @return the name part of the command
	 */
	public String getName(){
		return this.getParam(0);
	}
	
	/**
	 * Get the n'ieme parameter (0 for the name, 1 for the first parameter).
	 * @param n index
	 * @return A parameter of the original command line as string
	 * 		or null if the n position is to high
	 */
	public String getParam(int n){
		return n < this.params.length && n >= 0 ? this.params[n] : null;
	}
	
	/**
	 * Do the same that getParam, but convert it into an integer
	 * @param n
	 * @return the converted integer
	 * @throws NumberFormatException if the string has not an integer format
	 * @throws NullPointerEception if the n position is to high
	 */
	public int getParamAsInteger(int n){
		String param = this.getParam(n);
		if (param == null){
			throw new NullPointerException();
			
		}
		return Integer.parseInt(param);
	}
	
	/**
	 * @return the total number of parameters including the name (the index 0)
	 */
	public int count(){
		return this.params.length;
	}
}
