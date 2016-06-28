package Day2;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 解析xls文件中的一个表(sheet)
 * @author Chen
 *
 */
public class GetXlsSheet {
	
	
	public static SimpleDateFormat format1=new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat format2=new SimpleDateFormat("yy-MM-dd");

	/**
	 * 获得该表(sheet)的数据的List
	 * @return
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public List<XlsFileBean> GetSheets(Sheet sheet) {
		List<XlsFileBean> mList=new ArrayList<>();
			for(int row=3;row<sheet.getRows();row++){
				int dateTag=0,projectTag=3,describleTag=6,workTimeTag=8;
				//获得工作时间并解析
				double workTime=WorkTimeParse(sheet.getCell(workTimeTag,row).getContents());
				//获得项目名
				String project=sheet.getCell(projectTag, row).getContents();
				//获得日期并解析
				Date date=DateParse(sheet.getCell(dateTag,row).getContents());
				//获得任务描述
				String describle=sheet.getCell(describleTag,row).getContents();
				//判断sheet是否已经读完
				if(MyUtil.StrIsNull(project)){
					break;
				}		
				XlsFileBean xlsBean=new XlsFileBean(date, project,describle,workTime);
				mList.add(xlsBean);
			}
		
	return mList;
}
	
	/**
	 * 解析日期
	 * @param str
	 * @return
	 */
	public Date DateParse(String date){
		Date d=null;
		SimpleDateFormat dateFormat=format1;
		if(date.contains("-")){
			dateFormat=format2;
		}
		try {
			d=dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 解析工作时间的单元格，判断是否为空。若是则设为0
	 * 获得工作时间单元格的String，返回double类型的工作时间。
	 * @param workTimeSheet
	 * @return
	 */
	public double WorkTimeParse(String workTimeSheet){
		double workTime;
		if(!"".equals(workTimeSheet)){
			workTime=Double.parseDouble(workTimeSheet.trim());
		}else{
			workTime=0;
		}	
		return workTime;		
	}
	
	
	
	
	
	
	
	
}
