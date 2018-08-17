import java.io.IOException;

public class NotInIOS{
	public static void main(String[] args){
		ScanFolder sf = new ScanFolder();
		try {
			sf.getFileNames(); //fetches the filenames of all the files in the respective ios and windows folders.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}