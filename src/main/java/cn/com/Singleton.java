package cn.com;
import java.util.concurrent.atomic.AtomicBoolean;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;;

public class Singleton{
	
	private static AtomicBoolean shouldEnter = new AtomicBoolean(false);
	private static AtomicBoolean enter = new AtomicBoolean(false);
	private static volatile Singleton singleton;
	private Singleton(){
		
	}
	
	public Singleton getInstance(){
		if(singleton==null){
			if(shouldEnter.compareAndSet(false, true)){
				singleton = new Singleton();
				enter.set(true);
			}
		}
		while(!enter.get()){
			
		}
		return singleton;
	}
}
