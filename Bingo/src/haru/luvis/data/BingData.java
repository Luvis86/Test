package haru.luvis.data;

import android.content.Context;

public class BingData
{
	private static BingData gameData = null ;
	Context context ;
	public static BingData Linked(Context context)
	{
		if(gameData == null) gameData = new BingData(context) ;
		return gameData ;
	}
	
	public BingData(Context _context)
	{
		context = _context ;
		init() ;
	}
	
	private void init()
	{
		GamerCount = 0 ;
		GameLevel = 0;
		GameTurn = -1 ;
		
		GamePlayerManager = new Object[4][3] ;
	}
	public byte GamerCount ;
	public byte GameLevel ;
	public byte GameTurn ;
	
	/**
	 * object[0] : User
	 *  object[1] : Bot1
	 *  object[2] : Bot2
	 *  object[3] : Bot3
	 *  
	 *  object[][0] : GameTableid int[]
	 *  object[][1] : GameTable byte[][]
	 *  object[][2] : BingoPaper ArrayList<Byte>
	 */
	public Object[][] GamePlayerManager ;
}
