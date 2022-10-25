/*******************************************************************
                         E/1X/XXX 
********************************************************************/
import java.io.*;
import java.util.*; /* hash map */

/* import anything you need here */

/****
 * this is the basic shell class. 
 * to add a new command to your shell 
 * you should implement the class and 
 * add the command here. 
 */

public class Shell { 

 

    /* Prompt is the default prompt that you would see. 
     * You should be able to set this to something else 
     * by passing the new prompt from the command line
     * for example; if I say "java Shell MyShell$" that 
     * "MySell$" should be used as the prompt 
     */
    public static String prompt = "$ ";
	public static int count = 0;

    public static HashMap<String, GenericCommand> commands = 
	new HashMap<String, GenericCommand>();

    /** 
     * @line what the user typed at the prompt 
     * Should process this line, find the command and the arguments
     * pack them to a String[] where the first is the command 
     * rest are the arguments. 
     *#### For additional marks you can implement this method without using split
     * 
     */
    public static String [] findArguments (String line) { 
	String [] args = line.split(" "); // %%%%%%%%%%% SPLIT seems to have issues on Windows 
	return args;
    }

    /** 
     * Code to initialize the shell. 
     * Map commands to objects that handles them. 
     */
    public static void init_shell() { 
	/* register all the commands 
	 * put them to the hash map command name and object 
	 */
	commands.clear(); /* just in case there is anything */

	/* The new commands you should add here 
	 * You are required to implement read, write. 
	 *##### Implement your commands and add them here.
	 */
	commands.put("quit", new Quit());

	commands.put("less", new Less());
	
	commands.put("copy", new Copy());
    }

    /**
     * Running the command. We want array of strings. 
     * 0th element should say what the command is 
     * followed by some number of arguments depending on the command 
     * ##### Commands should check if they have the correct number 
     * of arguments 
     */
    public static void runCommand(String [] args) throws IOException {
	if(args.length == 0) /* did not find any command */
	    return; /* there is nothing to do */

	/** 
	 * We expect the first argument to the command 
	 * followed by options required for the command 
	 */	
	GenericCommand obj = commands.get(args[0]); 
	if(obj == null) { /* no such command */
	    System.out.println("Command not found!"); 
	    return; 
	}
	
	/* let the handler of that object takes care of it */
	obj.handleCommand(args);
    }

	

    /**
     * @read a line from user and return
     */
    public static String runShell() {       
	Console console = System.console();
	return console.readLine("%s",prompt);
    }

    /**
     * Initialize the prompt 
     */
    public static void init_prompt() { 
    }

    public static void init_prompt(String userPrompt) { 
	System.out.println("New Prompt"+userPrompt);
	prompt = userPrompt; 
    }
       
    /** 
     * Main methods.
     * Check if the user wants a different prompt and set it
     * Look at init_prompt and implement accordingly 
     */
    public static void main(String [] args) throws IOException {
	/**
	 * not the best implementation. 
	 * want to show function overloading 
	 */
	if(args.length == 0)      init_prompt(); 
	else if(args.length == 1) init_prompt(args[0]); 
	else { 
	    System.out.println("Usage: java Shell <prompt>");
	    System.exit(-1); 
	}
	
	init_shell(); /* initialize the shell and commands */
	
   

	while(true) { 
	    String userInput = runShell(); /* get user input */
	    String [] userArgs = findArguments(userInput);/* find command etc. */
	    
		count++;
		System.out.print("\n");
	    runCommand(userArgs); /*run the command */
		System.out.print("\n");
	
    }
	}
}
	
