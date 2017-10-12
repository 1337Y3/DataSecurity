import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {
	public fileReader() {
		String fileData = null;
		String nameOfFile = null;
	}
	public String dataFromFile(String nameOfFile) {
		String fileData = "";
		try  {
			FileReader fr = new FileReader(nameOfFile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				fileData = fileData + " " + line;
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return fileData;
	}
}
