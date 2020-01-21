import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


@FunctionalInterface
interface VotingAgeHandler {
	void accept(Integer i) throws Exception;
}
class VotingAgeNotAttainedException extends Exception{
	int age;
	public VotingAgeNotAttainedException(int age) {
		this.age=age;
	}
	@Override
	public String toString() {
		String r="VotingAgeNotAttainedException: Your age is "+age;
		return r;
	}
}
class NegativeInputException extends Exception{
	int age;
	public NegativeInputException(int age) {
		this.age=age;
	}
	@Override
	public String toString() {
		String r="NegativeInputException: Age cannot be negative : "+age;
		return r;
	}
}

public class LambdaExceptionHandling {
	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(10,49,40,-2,439);
		l.forEach((wrapperMethod((c)->{
			if(c<0) {
				throw new NegativeInputException(c);				
			}
			else if(c<18) {				
				throw new VotingAgeNotAttainedException(c);
			}
			else {
				System.out.println("Your age is "+c+", You are eligible to vote");
			}
		})));
		
		
	}

	static Consumer<Integer> wrapperMethod(VotingAgeHandler c) {
		return i->{
			try {
				c.accept((Integer) i);
			}
			
			catch (Exception e) {
				System.out.println(e);
			}
		};
	}
	
	
}
