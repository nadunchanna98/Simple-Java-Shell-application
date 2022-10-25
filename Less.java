import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class  Less extends GenericCommand {

    public void handleCommand(String [] args) throws IOException {

	if(!args[0].equals("less")) someThingWrong();

	if(args.length != 2) { 
	    System.out.println("Usage: less");
	    return;
	}
        String readfile = args[1];

        FileReader  reader = new FileReader("G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab6_2019e094\\"+readfile+".txt");
        BufferedReader text=new BufferedReader(reader);

        int i;
          while((i=text.read())!=-1){
          System.out.print((char)i);
          }
		System.out.print("\n");
		
    }

}