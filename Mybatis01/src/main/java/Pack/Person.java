package Pack;

// Bean
// 1. 디폴트 생성자만 있음
// 2. 반드시 setter, gertter가 있음

public class Person {

	String name; // setter, getter가 있는 경우 필드x > Property
	int age;
	
	// 단줄처리 단축키 컨트롤 + 알트 + j
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	
}
