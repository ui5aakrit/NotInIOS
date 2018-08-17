//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.nio.file.Files;
import java.util.Scanner;

public class ScanFolder{
	
	public void getFileNames() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();
	//	System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		 
		File logIOS = null;
		File logPC  = null;
		
		//ArrayList<String>

		
		Scanner s = new Scanner(System.in);
		
		System.out.println("pc path of destFolder (d:/myfile/)");  
		String pathDest = s.nextLine(); //scan folder for PC storage
		System.out.println();
		
		System.out.println("ios path of iosFolder (ios:/appleDCIM/)");
		String pathIOS = s.nextLine(); //scan folder for IOS storage
		System.out.println();
		
		System.out.print("set pc destfolder path for log  (d:\\my file\\)");
		String pathDestLog = s.nextLine();	
		
		
		FileWriter fr = null;
		//FileWriter frIOS = null; //not needed if file can create multiple files and fr is only here to write file data.
		BufferedWriter br = null;
		//BufferedWriter brIOS = null;
		
		
		try {		//for log files // it was on third but since log file needs to be created before inserting data into it from scanning so. it's created first.
			File pathOfDestLog = new File(pathDestLog);
			pathOfDestLog.mkdirs();
			if(!pathOfDestLog.exists()) { // && !pathOfDestLog.isDirectory()) { may be unnecessary to check DIR.
				pathOfDestLog = new File("d:\\NotInIOSLOGS");
				pathOfDestLog.mkdirs();
				if(!pathOfDestLog.exists()) {
					pathOfDestLog = new File("c:\\NotInIOSLOGS\\");  //path check for log files
				}
			}
			logPC = new File(pathOfDestLog,"logPC_"+dateFormat.format(date)+".txt");
			logIOS = new File(pathOfDestLog,"logIOS_"+dateFormat.format(date)+".txt");
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		File folder = null;  //for PC
		try {
			fr = new FileWriter(logPC);
			br = new BufferedWriter(fr);
			
			folder = new File(pathDest); //works both ways either f:\\pix\\ or that
			if(!folder.exists()) {
				folder = new File("f:/pix/");
			}
			if(folder.exists() && folder.isDirectory()) {
				File[] listOfFiles = folder.listFiles();
		
				for(int i = 0; i<listOfFiles.length; i++){
					if(listOfFiles[i].isFile()){
						System.out.println(listOfFiles[i].getName());
						br.write(listOfFiles[i].getName());
						//br.newLine();
					}
					else if (listOfFiles[i].isDirectory()){
						System.out.println();
						fr.append("\n");
					//	br.newLine();
					}
				}
			}
		} finally {
			try {
				s.close();
				br.close();
				fr.close();
			} catch(IOException e){
				e.printStackTrace();
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		
		
		File iosFolder = null;  //for IOS
		try {
			fr = new FileWriter(logIOS);
			br = new BufferedWriter(fr);
			
			iosFolder = new File(pathIOS); //works both ways either f:\\pix\\ or that
			if(!iosFolder.exists()) {
				iosFolder = new File("f:/pix/");
			}
			if(iosFolder.exists() && iosFolder.isDirectory()) {
				File[] listOfFiles = iosFolder.listFiles();
		
				for(int i = 0; i<listOfFiles.length; i++){
					if(listOfFiles[i].isFile()){
						System.out.println(listOfFiles[i].getName());
						br.write(listOfFiles[i].getName());
						br.append("\n");
					}
					else if (listOfFiles[i].isDirectory()){
						System.out.println();
						fr.append("\n");
					//	br.newLine();
					}
				}
			}
		} finally {
			try {
				s.close();
				br.close();
				fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		try {
			
		}catch(Exception e){
			e.printStackTrace();		
		}
		
		
//		 String readFile(String fileName) throws IOException {
//		 	BufferedReader br = new BufferedReader(new FileReader(fileName));
//		 	try{
//		 		StringBuilder sb = new StringBuilder();
//		 		String line = br.readLine();
//
//		 		while (line != null){
//		 			sb.append(line);
//		 			sb.append("\n");
//		 			line = br.readLine();
//		 		}
//		 		return sb.toString();
//		 	} finally {
//		 		br.close();
//		 	}
			
	}
}


