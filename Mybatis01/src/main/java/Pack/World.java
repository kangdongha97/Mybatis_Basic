package Pack;

// 반복되는 코드 방지
class Tiger{
	void m1() {System.out.println(1);} //연결
	void m2() {System.out.println(2);}
	void m3() {System.out.println(3);}
	void m4() {System.out.println(4);}
	void m5() {System.out.println(5);}
}

interface Delegate{
	void delegage(Tiger t); //sql 구현, ssf를 받아와야함
}

class Proxy{
	void command(Delegate d) {
		Tiger t = new Tiger(); //연결 + 구현
		t.m1();
		d.delegage(t);
		t.m5();
	}
}

public class World { // sql문 구현

	public static void main(String[] args) {
		
		Proxy proxy = new Proxy();
		proxy.command(new Delegate() {
			public void delegage(Tiger t) {
				t.m2();
			}
		});
		System.out.println("-----------------------");
		proxy.command(new Delegate() {
			public void delegage(Tiger t) {
				t.m5();
			}
		});
		System.out.println("-----------------------");
		proxy.command(new Delegate() {
			public void delegage(Tiger t) {
				t.m1();
			}
		});
		
		
	}

}
