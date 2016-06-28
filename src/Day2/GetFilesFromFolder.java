package Day2;

import java.io.File;
/**
 * 获取folderPath文件夹内所有文件
 * @author Chen
 *
 */
public class GetFilesFromFolder {
	public File[] getFilesFromFolder(String folderPath){
		File file=new File(folderPath);
		File[] filesList=file.listFiles();	
		return filesList;
		
	}
}
