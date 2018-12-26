import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ScanFolderModel{
	private ArrayList<File> listOfFilesPC,listOfFilesIOS; //listOfFilesPCMain,,listOfFilesIOSMain;
	private ArrayList<String> storePC = new ArrayList<>();
	private ArrayList<String> storeIOS = new ArrayList<>();
	
	
	private String pathIOS,pathDest;
	
	public void getFileNames() throws IOException, NullPointerException{

		Scanner s = new Scanner(System.in); //later it'll be in get path and set path methods;

//		@SuppressWarnings("unused")
		PathsOfPCIOSFoldersModel pcIO= new PathsOfPCIOSFoldersModel(); //may be i am creating unnecessary objects
		
		System.out.println("pc path of destFolder (d:/myfile/)");  
		pcIO.setPathPCDest(s.nextLine());
		pathDest = pcIO.getPathPCDest(); //scan folder for PC storage //may be //it can be just--- string pathDest= s.nextLine();
		
		System.out.println("ios path of iosFolder (ios:/appleDCIM/)");
		pcIO.setPathIOSDest(s.nextLine());
		pathIOS = pcIO.getPathIOSDest(); //scan folder for IOS storage
//	//	System.out.println();
		
		String test1 = "d:/NotInIOS/test/test1/";
		String test2 = "d:/NotInIOS/test/test2/";
		
//		pathDest = test1;
//		pathIOS  = test2;
		
		setListOfFiles(pathDest,test1,listOfFilesPC,"pc");
		setListOfFiles(pathIOS,test2,listOfFilesIOS,"ios");
		s.close();
	}

	private void setListOfFiles(String path, String test, ArrayList<File> listOfFiles,String type ){
		try {
			
			File folder = new File(path); //works both ways either f:\\pix\\ or that
			if(!folder.exists()) {
				folder = new File(test);
			}
			if(folder.exists() && folder.isDirectory()) {
				if(type=="pc")  listOfFilesPC = new ArrayList<File>(Arrays.asList(folder.listFiles()));
				else listOfFilesIOS = new ArrayList<File>(Arrays.asList(folder.listFiles()));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfExistInPC() {
		String tempName = null;
		try {
				//System.out.println(listOfFilesPC.size()+ " "+ listOfFilesIOS.size());
			
			Iterator<File> pc = listOfFilesPC.iterator(); 
	        while (pc.hasNext()) {
	        	tempName = pc.next().getName();
	        	//System.out.println("File Name in pc: " +  tempName);
	        	this.storePC.add(tempName);
			}
	        
	        Iterator<File> ios = listOfFilesIOS.iterator(); 
	        while (ios.hasNext()) {
	        	tempName = ios.next().getName();
	        	System.out.println("File Name in ios: " +  tempName);
	        	this.storeIOS.add(tempName);
	        }
			
	        System.out.println("File Name in removing all");
	        
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


