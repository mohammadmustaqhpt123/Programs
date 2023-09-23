import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

// how program will work 
// first we need to give  one parent folder path
// if item is file then it will store in linked list 
// if item is folder then it will call recursive method (same method) and read the all files and store it in linked list and
//if any other folder in side folder then that folder also read and add the all files into liked list it will read untill all folder should completed 


public class App 
{
	public static List files(String path) {
		List files = new LinkedList();
		try {
			Files.list(Paths.get(path)).
			forEach( 
					(file)->
					{
						if(Files.isRegularFile(file)) {	
							files.add(file);
						}
						if(Files.isDirectory(file)) {
              // recuresive method for folder inside files 
							files.addAll(files(file.toString()));
						}
					}
			);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;	
		
	}
    public static void main( String[] args )
    {
    	
    	List files= files("C:\\Users\\MUSTMOHA\\Desktop\\Playwright_Projects\\demo-playwright-project");
    	System.out.println(files.size());
    	files.forEach(
    			(file)->{
    				Path f = (Path) file;
    				System.out.println(f.getFileName().toString());
    			}
    	);
    	
    }
 }
