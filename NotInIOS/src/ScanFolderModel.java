import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.Scanner;

public class ScanFolderModel{
	private ArrayList<File> listOfFilesPC,listOfFilesIOS; //listOfFilesPCMain,,listOfFilesIOSMain;
	private ArrayList<String> storePC,storeIOS;
	private String pathIOS,pathDest;
	
	public void getFileNames() throws IOException, NullPointerException{

		Scanner s = new Scanner(System.in); //later it'll be in get path and set path methods;

		PathsOfPCIOSFoldersModel pcIO= new PathsOfPCIOSFoldersModel(); //may be i am creating unnecessary objects
		
		System.out.println("pc path of destFolder (d:/myfile/)");  
		pcIO.setPathPCDest(s.nextLine());
		pathDest = pcIO.getPathPCDest(); //scan folder for PC storage //may be //it can be just--- string pathDest= s.nextLine();
		
		System.out.println("ios path of iosFolder (ios:/appleDCIM/)");
		pcIO.setPathIOSDest(s.nextLine());
		pathIOS = pcIO.getPathIOSDest(); //scan folder for IOS storage
	//	System.out.println();
		
		String test1 = "d:/NotInIOS/test/test1/";
		String test2 = "d:/NotInIOS/test/test2/";
		
		creatingFolders(pathDest,test1,listOfFilesPC);
		creatingFolders(pathIOS,test2,listOfFilesIOS);
		s.close();
	}

	private void creatingFolders(String path, String test, ArrayList<File> listOfFiles){
		try {
			
			File folder = new File(path); //works both ways either f:\\pix\\ or that
			if(!folder.exists()) {
				folder = new File(test);
			}
			if(folder.exists() && folder.isDirectory()) {
				listOfFiles = new ArrayList<File>(Arrays.asList(folder.listFiles()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfExistInPC() {
		try {
				//System.out.println(listOfFilesPC.size()+ " "+ listOfFilesIOS.size());
			
			
			Iterator<File> pc = listOfFilesPC.iterator(); 
	        while (pc.hasNext()) {
	        	Path p = Paths.get(pc.toString());
	        	String file = p.getFileName().toString();
	        	System.out.println(file);
	        	this.storePC.add(file);
	        	//this.abc.add(pc.next().getName().toString());     //the value is not being passed and doesn't run after this even if i remove the toString() method.
	        	System.out.println("asdf");
			}
	        
	        Iterator<File> ios = listOfFilesIOS.iterator(); 
	        while (ios.hasNext()) {
	        	Path p = Paths.get(pc.toString());
	        	String file = p.getFileName().toString();
	        	this.storeIOS.add(file);
	        	//String filename = ios.next().getName(); 
	        	//this.storeIOS.add(ios.next().getName());
	        }
			
//	            System.out.println(it.next().getName());                         /***
		//	this.abc.addAll(listOfFilesPC);
		//	this.bcd.addAll(listOfFilesIOS);										***
			
			
//			for(int i=0;i<listOfFilesPC.size();i++) { 
//					this.abc.add(i,listOfFilesPC.get(i).getName().toString());  ****** THis whole comment block should act similar
//					System.out.println(i);
//				}
//				
//			System.out.println("CheckIf method for loop 1st start");
//			for(int j=0;j<listOfFilesIOS.size();j++) {
//				System.out.println("line 84 working");
//				this.bcd.add(listOfFilesIOS.get(j).getName().toString());          *****/
//			}
			
			this.storePC.removeAll(this.storeIOS);
			for(String m: storePC){
				System.out.println(m);
			}			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void printValuesOfList(){
		for(File j:listOfFilesPC) {
			System.out.println(j.getName());
			
		}
		for(File i:listOfFilesIOS) {
			System.out.println(i.getName());
		}
	}
	
	@SuppressWarnings("unused") void movePCToNewFolder(){
		
	}
	
	@SuppressWarnings("unused")
	 void moveFilesIOSToPC(){
		
	}
}


