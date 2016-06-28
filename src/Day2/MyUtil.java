package Day2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyUtil {

	/**
	 * 遍历检查List
	 * @param mList
	 */
	public static void TestList(List<XlsFileBean> mList){
		for(XlsFileBean item:mList){
			System.out.println(item.getDate()+"/"+item.getProject()+"/"+item.getWorkTime());
		}
	}
	/**
	 * 检查str是否为空
	 * @param str
	 * @return
	 */
	public static boolean StrIsNull(String str){	
		return str==null||str.length()==0;
	}
	
}
