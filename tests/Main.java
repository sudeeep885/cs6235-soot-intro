public class Main {
	public static void main(String[] args) {
		
		A a1 = new A(2, 5);
		int x = a1.getSum();
		
		// do something..
		
	}
}

class A {
	int f1, f2;
	
	public A(int f1, int f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public int getSum() {
		return f1 + f2;
	}
}