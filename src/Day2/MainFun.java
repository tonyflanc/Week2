package Day2;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.read.biff.BiffException;

public class MainFun {

	public static final String  FolderPath="C:/Users/Chen/Desktop/ExcelDatas";
	
	public static void main(String[] args) {
		MainFun f=new MainFun();
		List<XlsFileBean> mList=f.OutPutFile(FolderPath);
		try {
			ListTOMySQL(mList);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}
	/**
	 * 返回应当输出的excel文件数据的List
	 * @param folder
	 * @return
	 */
	public List<XlsFileBean> OutPutFile(String folder){
		GetFilesFromFolder getFolder=new GetFilesFromFolder();
		File[] files;
		files=getFolder.getFilesFromFolder(folder);
		GetXlsFile getXlsFile=new GetXlsFile();
		List<XlsFileBean> mList=new ArrayList<>();
		for(int i=0;i<files.length;i++){
			try {
				mList.addAll(getXlsFile.GetXlsFile(files[i]));
			} catch (BiffException | IOException e) {
			
				e.printStackTrace();
			}
		}
		return mList;
		
	}
	
	/**
	 * 将list集合数据输入mysql
	 * @param mList
	 * @throws SQLException 
	 */
	public static void ListTOMySQL(List<XlsFileBean> mList) throws SQLException{
		Connection conn=null;
		String sql;
		String url= "jdbc:mysql://localhost:3306/world?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn=DriverManager.getConnection(url);
			 // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql="create table projectTable(NO int,date varchar(50),,"
            		+ "project varchar(80),describle varchar(80),worktime varchar(50),primary key(NO))";
            int result=stmt.executeUpdate(sql);
			if(-1!=result){
				System.out.println("创建数据表成功");
				for(int i=0;i<mList.size();i++){
					Date date=mList.get(i).getDate();
					String project=mList.get(i).getProject();
					Double worktime=mList.get(i).getWorkTime();
					String describle=mList.get(i).getDescrible();
					sql = "insert into projectTable(NO,date,project,describle,worktime) values("
							+"'"+ i+"','"+date+"','"+project+"','"+describle+"','"+worktime
							+ "')";
					System.out.println(sql);
	                result = stmt.executeUpdate(sql);
				}
			}
		} catch (Exception e) {
			 System.out.println("MySQL操作错误");
		}finally {
			conn.close();
		}
	}

}
