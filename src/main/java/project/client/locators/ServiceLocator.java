package project.client.locators	;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {
	
	
	
	private Map<String, Object> cache;
	private Context ctx;
	private static ServiceLocator serviceLocator;
	
	private ServiceLocator()
	{
		try {
			ctx= new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cache= new HashMap<String, Object>();
	}
	public static ServiceLocator getInstance()
	{
		if(serviceLocator==null)
		{
			serviceLocator=new ServiceLocator();
		}
		return serviceLocator;
	}
	public Object getRemoteProxy(String jndiName)
	{
		Object obj=null;
		obj=cache.get(jndiName);
		if(obj==null)
		{
			try {
				obj=ctx.lookup(jndiName);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cache.put(jndiName, obj);
		}
		return obj;
	}

}
/*public class ServiceLocator {
	private static ServiceLocator instance;
	//private GestionRequestRemote remote ;
	private Map<String, Object> cache;
	Context context;

	private ServiceLocator() {
		cache = new HashMap<String, Object>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/*public synchronized Object getProxy(String jndi) {
		if (cache.get(jndi) != null)
			return cache.get(jndi);
		else {
			Object object = null;
			try {
				object = context.lookup(jndi);
				cache.put(jndi, object);
			} catch (NamingException e) {
				e.printStackTrace();
			}

			return object;
		}

	}*/

	
	/*public Object getProxy(String jndi) {
		Object proxy = null;
	   proxy=cache.get(jndi);
	if(proxy!=null)
		return proxy;
	else {
		try { 
			proxy=context.lookup(jndi);
			cache.put(jndi, proxy);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	
	 return proxy;
	}
	
	
	}
	
	
	

	public static ServiceLocator getInstance() {
		if (instance == null)
			instance = new ServiceLocator();
		return instance;
	}

}*/
