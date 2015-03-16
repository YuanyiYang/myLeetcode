package others;
/**
 * This program shows that Java is a static scoping language. The non-local variable y in procedure
 * mostInner is actually declared in the outer scope of the definition, the class. Not in the 
 * caller of mostInner function, inner(). 
 * @author yuanyiyang
 *
 */
public class StaticScoping {
	int x,y;
	public StaticScoping(int x) {
		this.x = x;
	}
	public void mostInner(int z){
		System.out.println(x+y+z);
	}
	public void inner(){
		int y = 10;
		mostInner(15);
	}
	public void outer(){
		y = 5;
		inner();
	}
	public static void main(String[] args) {
		StaticScoping sp = new StaticScoping(20);
		sp.outer();
	}
}
