package haru.luvis.data;

import java.util.ArrayList;

import android.content.Context;

public class GameData
{
	private static GameData gameData = null ;
	private Context context ;
	
	public static GameData Linked(Context context)
	{
		if(gameData == null) gameData = new GameData(context) ;
		return gameData ;
	}
	
	public GameData(Context _context)
	{
		context = _context ;
		init() ;
	}
	
	private void init()
	{
		User_GameTable = null ;
		User_BingoTable = null ;
		User_BingoTableId = -1 ;		
		
		Bot1_GameTable = null ;
		Bot1_BingoTable = null ;
		Bot1_BingoTableId = -1 ;
		
		Bot2_GameTable = null ;
		Bot2_BingoTable = null ;
		Bot2_BingoTableId = -1 ;
		
		Bot3_GameTable = null ;
		Bot3_BingoTable = null ;
		Bot3_BingoTableId = -1 ;
		
		GamerCount = 0 ;
		GameLevel = 0;
		GameTurn = -1 ;
	}
	
	// 게임 룰에 적용되는 테이블(선택한 번호의 자리를 체크하고 관리)
	public byte[][] User_GameTable ;
	public byte[][] Bot1_GameTable, Bot2_GameTable, Bot3_GameTable, Bot4_GameTable ; 
	
	// 랜덤으로 정렬된 테이블.
	public ArrayList<Byte> User_BingoTable ;
	public ArrayList<Byte> Bot1_BingoTable, Bot2_BingoTable, Bot3_BingoTable ;
	
	// 게임 테이블(그리드뷰)의 id
	public int User_BingoTableId ;
	public int Bot1_BingoTableId, Bot2_BingoTableId, Bot3_BingoTableId ;
	
	public byte GamerCount ;
	public byte GameLevel ;
	public byte GameTurn ;
}
