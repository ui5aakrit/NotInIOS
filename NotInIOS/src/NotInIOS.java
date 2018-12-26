import java.io.IOException;

public class NotInIOS extends ScanFolderModel{
	
	private static boolean moveIOSFiles = false;
	private static boolean movePCFiles = false;
	
	public static void main(String[] args){
		NotInIOS notInIOS = new NotInIOS();
		notInIOS.doIOSStuffs();
	}
	
	public void doIOSStuffs() {

		try {
			super.getFileNames(); //fetches the filenames of all the files in the respective ios and windows folders.
			super.checkIfExistInPC(); //will use when later added to the ScanFOlderModel Class.
			//sf.printValuesOfList();
			if (moveIOSFiles==true) {
				super.moveFilesIOSToPC();
			}
			if(movePCFiles ==true) {
				super.movePCToNewFolder();
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}

