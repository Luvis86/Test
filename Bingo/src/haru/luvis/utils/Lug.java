package haru.luvis.utils;

import android.util.Log;

public class Lug {
	public static void e(Object arg0)
	{
		Log.e(ClassName(), MethodName() + arg0) ;
	}
	
	public static void e(Object arg0, Object arg1)
	{
		Log.e(ClassName(), MethodName() + "arg1 : " + arg0 + "  |*|  arg2 : " + arg1) ;
	}
	
	public static void e(Object arg0, Object arg1, Object arg2)
	{
		Log.e(ClassName(), MethodName() + "arg0 : " + arg0 + "  |*|  arg1 : " + arg1 + "  |*|  arg2 : " + arg2) ;
	}
	
	private static String ClassName() 
	{
		return new Exception().getStackTrace()[2].getClassName() ;
	}
	
	private static String MethodName() 
	{
		return "["+ new Exception().getStackTrace()[2].getMethodName() + "] "  ;
	}
}
