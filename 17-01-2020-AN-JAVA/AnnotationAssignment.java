import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Current{
	public String CurrentType();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Fridge{
	String doors() default "one";
	int capacity();
	
}

@Fridge(capacity = 190)
class LG{
	int version;
	String model;
	double rating;
	
	public LG(int version, String model, double rating) {
		super();
		this.version = version;
		this.model = model;
		this.rating = rating;
	}

	@Current(CurrentType = "AC")
	public void CurrentFlow() {
		System.out.println("Current type: AC");
	}
}
public class AnnotationAssignment {
	public static void main(String[] args) {
		try {
		LG lg=new LG(10, "GL-D201ASLI",3.6);
		Class c=lg.getClass();
		Fridge f=(Fridge) c.getAnnotation(Fridge.class);
		System.out.println("Doors="+f.doors()+"\tCapacity:"+f.capacity());
		Method m=c.getMethod("CurrentFlow");
		Current current=m.getAnnotation(Current.class);
		System.out.println("Cuurent type:"+current.CurrentType());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
