package haru.luvis.data;

import java.util.ArrayList;

import android.content.Context;

public class GameManager {

	@SuppressWarnings("unchecked")
	public void CheckPosition(Context context, int selectedNumber)
	{
		GameTurn(context) ;
		
		ArrayList<Byte> temp_BingoPaper =  (ArrayList<Byte>)GameData.Linked(context).GamePlayerManager[0][2] ;
		byte[][] temp_GameTable =  (byte[][])GameData.Linked(context).GamePlayerManager[0][1] ;

//		byte NumberOfSelectedPosition = temp_BingoPaper.get(selectedPosition); 
//
//		Toast.makeText(activity.getApplicationContext(), "숫자 : "+NumberOfSelectedPosition+"\n자리 : "+ selectedPosition, Toast.LENGTH_SHORT).show() ;
//		// gameTable[][] 의 5,6번째 배열에 값 넣기
//		for(byte i = 0; i<12; i++)
//		{
//			for(byte j = 0; j < 5; j++)
//			{
//				if(temp_GameTable[i][j] == selectedPosition )
//					temp_GameTable[i][5] ++ ;
//
//				if(temp_GameTable[i][5] == 5)
//					temp_GameTable[i][6] = 1 ;
//			}
//		}
	}

	/**
	 *  Player Data 관리를 위한 부분
	 */
	
	public Object[] GetReturnDouble_All(Context context, byte room)
	{
		return GameData.Linked(context).GamePlayerManager[room] ;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Byte> GetReturnDouble_ArrayList(Context context, byte room)
	{
		return (ArrayList<Byte>)GameData.Linked(context).GamePlayerManager[room][1];
		
	}
	
	public Byte[] GetReturnDouble_Array(Context context, byte room)
	{
		return (Byte[])GameData.Linked(context).GamePlayerManager[room][0] ;
	}
	
	public void SetReturnDouble(Context context, byte room, Object[] _Value)
	{
		GameData.Linked(context).GamePlayerManager[room] = _Value ;
	}

	private void GameTurn(Context context)
	{
		GameData.Linked(context).GameTurn ++ ;
		if(GameData.Linked(context).GameTurn > GameData.Linked(context).GamerCount)
			GameData.Linked(context).GameTurn = 0; 
	}

}
