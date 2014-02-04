package haru.luvis.data;

import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.content.Context;

public class GameSetting {

	public static byte GamerCount ;
	/**
	 * Game 실행을 위해 랜덤값으로 세팅함 
	 */
	public ArrayList<Byte> TableSetting(int _gameLevel)
	{
		Lug.e("GameSetting - TableSetting  불려짐") ;
		ArrayList<Byte> _return = new ArrayList<Byte>() ;
		
		for(byte i = 0; i < _gameLevel ; i++)
		{
			byte a = (byte)((Math.random()*CountDecimal(_gameLevel))%_gameLevel +1) ;
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
	
	/**
	 * 게임에 참여한 인원이 몇인지 결정 
	 */
	private void GamerSetting(Context context, byte count)
	{
		
		if(count == new GameRule().GAMEPLAYSINGLE)
		{
		
			GameData.Linked(context).User_GameTable = new GameRule().DefaultBingoRule ;
		}else if(count == new GameRule().GAMEPLAYDOUBLE)
		{
			GameData.Linked(context).Bot1_GameTable = new GameRule().DefaultBingoRule ;
		}
		else
		{
			
		}
	}
}
