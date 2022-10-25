public class Quit extends GenericCommand {

    public void handleCommand(String [] args) { 

	if(!args[0].equals("quit")) someThingWrong(); 

	if(args.length != 1) { 
	    System.out.println("Usage: quit");
	    return;
	}
		System.out.println("Number of commands : " + Shell.count);

	/* OK, so just die */ 
	System.exit(0); 
    }

}