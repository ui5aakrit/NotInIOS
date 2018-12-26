import java.io.IOException;

public class NotInIOS{
	private static boolean moveIOSFiles = false;
	private static boolean movePCFiles = false;
	public static void main(String[] args){
		ScanFolderModel sf = new ScanFolderModel();
		try {
			sf.getFileNames(); //fetches the filenames of all the files in the respective ios and windows folders.
			sf.checkIfExistInPC(); //will use when later added to the ScanFOlderModel Class.
			//sf.printValuesOfList();
			if (moveIOSFiles==true) {
				sf.moveFilesIOSToPC();
			}
			if(movePCFiles ==true) {
				sf.movePCToNewFolder();
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}