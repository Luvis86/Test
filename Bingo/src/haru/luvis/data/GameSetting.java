package haru.luvis.data;

import haru.luvis.bot.Game_AI;
import haru.luvis.player.Game_play;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

public class GameSetting {

//	public static byte GamerCount ;
//	public static int BingoTable_Player ;
//	public static int BingoTable_Bot1 ;
	
	Context m_context ;
	GameData gameData = null ;
	
	// 게임 시작시 초반에 반드시 한번 불려야 함.
	public void GameSetting(Activity activity, int[] _id)
	{
		m_context = activity.getApplicationContext() ;
		gameData = GameData.Linked(m_context) ;
		
		//게임 인원 세팅 
		gameData.GamerCount = (byte)_id.length ;

		//게임 테이블 세팅
		switch (_id.length) 
		{
		case 4:
			gameData.Bot3_GameTable = DefaultBingoRule ;
			gameData.Bot3_BingoTable = TableSetting() ;
			gameData.Bot3_BingoTableId = _id[3] ;
			
			gameData.Bot2_GameTable = DefaultBingoRule ;
			gameData.Bot2_BingoTable = TableSetting() ;
			gameData.Bot2_BingoTableId = _id[2] ;
			
		case 2 :
			gameData.Bot1_GameTable = DefaultBingoRule ;
			gameData.Bot1_BingoTable = TableSetting() ;
			gameData.Bot1_BingoTableId = _id[1] ;
			new Game_AI().Create_AI(activity, _id[1]) ;
		
		case 1 :
			gameData.User_GameTable = DefaultBingoRule ;
			gameData.User_BingoTable = TableSetting() ;
			gameData.User_BingoTableId = _id[0] ;
			new Game_play().Create_Player(activity, _id[0]) ;
			break ;
		}
	}
	/**
	 * Game 실행을 위해 랜덤값으로 세팅함 
	 */
	public ArrayList<Byte> TableSetting()
	{
		byte gamelevel = gameData.GameLevel ; 
		
		ArrayList<Byte> _return = new ArrayList<Byte>() ;
		
		for(byte i = 0; i < gamelevel ; i++)
		{
			byte a = (byte)((Math.random()*CountDecimal(gamelevel))%gamelevel +1) ;
			if(i == 0)
				_return.add(a) ;
			else
			{
				for(byte j = 0; j< i ; j++)
				{
					if(_return.get(j) == a)
					{
						i-- ;
						break ;
					}
					else if(j == i-1)
					{
						_return.add(a) ;
					}
					
				}
			}
		}
		return _return ;
	}
	
	
	/**
	 * 자릿수를 구한후 10의 (자릿수)제곱을 함 
	 */
	private int CountDecimal(int value)
	{
		//자릿수 구함
		String a = String.format("%d", value) ;
		
		//(자릿수)승 을 리턴 함 
		return (int)Math.pow(10,a.length()) ;
	}
	
	private byte DefaultBingoRule[][] = { 
		{ 0,  1,  2,  3,  4, 0, 0},
		{ 5,  6,  7,  8,  9, 0, 0},
		{10, 11, 12, 13, 14, 0, 0},
		{15, 16, 17, 18, 19, 0, 0},
		{20, 21, 22, 23, 24, 0, 0},

		{ 0,  5, 10, 15, 20, 0, 0},
		{ 1,  6, 11, 16, 21, 0, 0},
		{ 2,  7, 12, 17, 22, 0, 0},
		{ 3,  8, 13, 18, 23, 0, 0},
		{ 4,  9, 14, 19, 24, 0, 0},

		{ 4,  8, 12, 16, 20, 0, 0},
		{ 0,  6, 12, 18, 24, 0, 0} };
}
