package Day1;

public class Person {
	private static String name;
	public int age;
	public String getName() {
		System.out.println(name);
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("age");
		this.age = age;
	}
	
	

}
