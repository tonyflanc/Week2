package Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 解析xls文件
 * @author Chen
 *
 */
public class GetXlsFile {
	/**
	 * 读取file文件中所有的表(sheet)，并获得每个sheet的list，最后返回该file的数据的list
	 * @param file
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public List<XlsFileBean> GetXlsFile(File file) throws BiffException, IOException{
		List<XlsFileBean> mList=new ArrayList<>();
		Workbook workbook=Workbook.getWorkbook(file);
		for(int n=0;n<workbook.getNumberOfSheets();n++){
			//读取该文件中所有的表(Sheet)
			GetXlsSheet gxs=new GetXlsSheet();
			Sheet sheet=workbook.getSheet(n);
			//解析表（sheet），返回该sheet的list
			mList=gxs.GetSheets(sheet);
		}
		return mList;
	}
}
