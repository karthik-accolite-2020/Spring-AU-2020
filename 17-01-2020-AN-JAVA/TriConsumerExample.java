@FunctionalInterface
interface TriConsumer<X,Y,Z>{
	void accept(X x,Y y,Z z);
}
public class TriConsumerExample {
	public static void main(String[] args) {
		TriConsumer<Integer,Integer,Integer> tc=(x,y,z)->{
			if(x<=100&&y<=100&&z<=100&&x>=0&&y>=0&&z>=0) {
				int totalMarks=x+y+z;
				double avg=(double)totalMarks/3;
				System.out.println("Total marks="+totalMarks);
				System.out.println("Average in 3 subjects="+avg);
			}
			else {
				System.out.println("Invalid marks");
			}
		};
		tc.accept(99, 67, 87);
	}
}
