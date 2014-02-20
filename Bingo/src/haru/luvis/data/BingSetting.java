package haru.luvis.data;

import haru.luvis.player.Play_bot;
import haru.luvis.player.Play_user;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

public class BingSetting {

	Context m_context ;
	BingData gameData = null ;

	//luvis 수정해야 함 
	public final byte GamerTurn = 0 ; 

	// 게임 시작시 초반에 반드시 한번 불려야 함.
	public void GameSetting(Activity activity,   int[] _id)
	{
		m_context = activity.getApplicationContext() ;
		gameData = BingData.Linked(m_context) ;

		//luvis 누가 먼저 시작인지 판단
		gameData.GameTurn = GamerTurn ;

		//게임 인원 세팅 
		gameData.GamerCount = (byte)_id.length ;

		//게임 테이블 세팅
		for(byte who = 0; who < _id.length; who++)
		{
			gameData.GamePlayerManager[who][0] = _id[who] ;
			gameData.GamePlayerManager[who][1] = DefaultBingoRule ;
			gameData.GamePlayerManager[who][2] = TableSetting() ;
			
			if(who == 0)
			{
				new Play_user().Create_Player(activity) ;
			}
			else
			{
				new Play_bot().Create_AI(activity, who) ;
			}
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
