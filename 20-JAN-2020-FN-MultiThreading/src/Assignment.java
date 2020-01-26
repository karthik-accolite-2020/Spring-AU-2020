import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Assignment {
	static Random r=new Random();
	static String[] arr=new String[] {"Apple","Orange","Grape","Watermelon"};
	static int size=arr.length;
	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<String,Integer>();
		Runnable r1=()->{

			while(true) { 
				
					try {											
						int ind=r.nextInt()%size;
						if(ind<0)
							ind=-ind;
						synchronized (arr[ind]) {
							if(map.containsKey(arr[ind])) {
								if(map.get(arr[ind])==2) {
									System.out.println(Thread.currentThread().getName()+"--Market has lot of "+arr[ind]);								
									arr[ind].wait();								
								}
								System.out.println(Thread.currentThread().getName()+"--Adding:"+arr[ind]);
								map.put(arr[ind],map.get(arr[ind])+1);
							}
							else {
								System.out.println(Thread.currentThread().getName()+"--Adding:"+arr[ind]);
								map.put(arr[ind],1);
							}
							arr[ind].notify();
							
						}
						
						synchronized (map) { 
							map.notify();
							System.out.println(Thread.currentThread().getName()+"--Producer--"+map); 
							map.wait();
						}
						Thread.sleep(1000);
						
					}catch (Exception e) {
						System.out.println(e);
					}
				}
			
		
		};
		
		Runnable r2=()->{

			while(true) {
				
					try {					
						int ind=r.nextInt()%size;
						if(ind<0)
							ind=-ind;
						synchronized (arr[ind])
						{
							if(!map.containsKey(arr[ind])) {
								System.out.println(Thread.currentThread().getName()+"--Market doesnt has "+arr[ind]);
								arr[ind].wait();							
							}
							System.out.println(Thread.currentThread().getName()+"--Removing:"+arr[ind]);
							map.replace(arr[ind], map.get(arr[ind])-1);
							if(map.get(arr[ind])==0) {
								map.remove(arr[ind]);
							}
							arr[ind].notify();
						}
						synchronized (map) {
							map.notify();
							System.out.println(Thread.currentThread().getName()+"--Consumer--"+map);						
							map.wait();
						}
						Thread.sleep(100);
					}catch (Exception e) {
						System.out.println(e);
					}
				}
		
			
		
		};
		
		Thread t1=new Thread(r1,"Pro One");
		Thread t2=new Thread(r1,"Pro Two");
		Thread t3=new Thread(r2,"Con One");
		Thread t4=new Thread(r2,"Con Two");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
