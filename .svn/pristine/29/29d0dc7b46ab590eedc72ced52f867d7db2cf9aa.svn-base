package com.sd.farmework.aop;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.ibatis.binding.MapperProxy;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
@SuppressWarnings("rawtypes")
public class TimeHandler  {
 
	Logger logger =Logger.getLogger(this.getClass().getName());
	 
	
	  
	public Object aroundTime(ProceedingJoinPoint point) throws Exception
    {
		try {
			logger.info("mapper目标方法为；"+getJdkDynamicProxyTargetObject(point.getTarget())+"."+point.getSignature().getName());
			//getJdkDynamicProxyTargetObject(point);
			logger.info("目标方法参数为：" + Arrays.toString(point.getArgs()));
		      //  System.out.println("@AfterReturning：返回值为：" + returnValue);
			Object result = point.proceed();
			logger.info("目标方法返回值为：" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new Exception(e);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		 
    }
	 
	  
	  
	  
	    private static String getJdkDynamicProxyTargetObject(Object proxy) throws Exception {  
	        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");  
	        h.setAccessible(true);  
	       
			MapperProxy aopProxy = (MapperProxy) h.get(proxy);  
	          
	        Field advised = aopProxy.getClass().getDeclaredField("mapperInterface");  
	        advised.setAccessible(true);  
	          
	        Object target = advised.get(aopProxy);  
	        Field advised2 = target.getClass().getDeclaredField("name");  
	        advised2.setAccessible(true);  
	        Object target1 = advised2.get(target);  
	        return target1.toString();  
	    }  
	    
//	    private static String getJdkDynamicProxyTargetObject(ProceedingJoinPoint point) throws Exception {  
//	    	
//	    	
//	       Method h = point.getClass().getMethod("methodInvocation", ProceedingJoinPoint.class);  
//	        
//	       String a=null;
//	       
//	        System.out.println(h);
//	       
//	        
//	        return null;  
//	    } 
}
