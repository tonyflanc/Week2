package Day2;

import java.util.Date;

public class XlsFileBean {
	private Date date;
	private String describle;
	private String project;
	private double workTime;
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	
	
	public XlsFileBean(Date date,String project,String describle,double workTime){
		this.date=date;
		this.project=project;
		this.workTime=workTime;
		this.describle=describle;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getWorkTime() {
		return workTime;
	}
	public void setWorkTime(double workTime) {
		this.workTime = workTime;
	}

	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}	
	
}
