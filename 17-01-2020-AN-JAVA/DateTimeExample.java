import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {
	public static void main(String[] args) {
		LocalDateTime myTime = LocalDateTime.parse("1998-11-06T08:56:59");
	      System.out.println("My DateTime: " + myTime);
	      
	      LocalDateTime sisTime=LocalDateTime.parse("1995-10-07T09:30:27");
	      System.out.println("Sis DateTime: " + sisTime);

	      Instant start=Instant.parse("1998-11-06T08:56:59.000Z");
	      Instant end=Instant.parse("1995-10-07T09:30:27.000Z");
	      Duration d=Duration.between(end, start);
	      System.out.println(d.toNanos());

	      ZonedDateTime z1=ZonedDateTime.parse("1998-11-06T08:56:59+05:30");
	      System.out.println(z1);
	      ZonedDateTime z2=ZonedDateTime.parse("1995-10-07T09:30:27-15:30");
	      System.out.println(z2);
	      ChronoUnit c=ChronoUnit.DAYS;
	      System.out.println(c.between(z2, z1));
	      
	}
}
