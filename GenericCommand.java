import java.io.FileNotFoundException;
import java.io.IOException;

/*******************************************************************
                 Skeleton code 
********************************************************************/

public class GenericCommand { 
    /* this is the generic command 
     * your commands should reimplement this
     */

    public void handleCommand(String [] args) throws IOException {
	System.out.println("Command not implemented!");
    }

    public void someThingWrong() { 
	System.out.println("Something Wrong in code!!!");
	System.exit(-1);
    }
}

