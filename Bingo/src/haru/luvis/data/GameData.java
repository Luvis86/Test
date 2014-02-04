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
		
		Bot1_GameTable = null ;
		Bot2_GameTable = null ;
		Bot3_GameTable = null ;
		
		Bot1_BingoTable = null ;
		Bot2_BingoTable = null ;
		Bot3_BingoTable = null ;
	}
	
	// 게임 룰에 적용되는 테이블(선택한 번호의 자리를 체크하고 관리)
	public byte[][] User_GameTable ;
	public byte[][] Bot1_GameTable, Bot2_GameTable, Bot3_GameTable, Bot4_GameTable ; 
	
	// 랜덤으로 정렬된 테이블.
	public ArrayList<Byte> User_BingoTable ;
	public ArrayList<Byte> Bot1_BingoTable, Bot2_BingoTable, Bot3_BingoTable ;
	
}
