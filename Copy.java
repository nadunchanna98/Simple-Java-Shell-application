import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
public class  Copy extends GenericCommand {
    public void handleCommand(String [] args) throws IOException {

	if(!args[0].equals("copy")) someThingWrong();

	if(args.length != 3) { 
	    System.out.println("Usage: copy");
	    return;
	}
		String readfile = args[1];
		String writefile = args[2];

		FileReader reader=new FileReader("G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab6_2019e094\\"+readfile+".txt");
        BufferedReader text=new BufferedReader(reader);

		FileWriter writer = new FileWriter("G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab6_2019e094\\"+writefile+".txt");
		BufferedWriter text2 = new BufferedWriter(writer);

		text2.write(text.readLine());
		text2.close();
		System.out.print(readfile+" Successfully Copied to "+writefile+"\n");
		
    }

}