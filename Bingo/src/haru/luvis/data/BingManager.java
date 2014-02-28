package haru.luvis.data;

import haru.luvis.player.Play_bot;
import haru.luvis.player.Play_user;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

public class BingManager {

	
	public void Management(Activity activity, byte selectedNumber)
	{
		BingData bing = BingData.Linked(activity.getApplicationContext()) ;
		
		for(int i = 0; i< bing.GamerCount; i++)
		{
			if(i != bing.GameTurn)
			{
				CheckPosition(activity, selectedNumber) ;
				
				bing.GameTurn++ ;
			}
			Lug.e("탄다 : i = " + i + "    gameTurn = " + bing.GameTurn) ;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void CheckPosition(Activity activity, byte selectedNumber)
	{
		Context context = activity.getApplicationContext() ;
		BingData data = BingData.Linked(context) ;
//		byte who =  data.GameTurn;
		byte who = WhoIs(context) ;

		
		ArrayList<Byte> temp_BingoPaper =  (ArrayList<Byte>)data.GamePlayerManager[who][2] ;
		byte[][] temp_GameTable =  (byte[][])data.GamePlayerManager[who][1] ;
		ArrayList<Boolean> temp_BingoBoolean = (ArrayList<Boolean>)data.GamePlayerManager[who][3] ;

		byte SelectedPosition = 0;
		for(byte _position : temp_BingoPaper)
		{
			if(_position == selectedNumber)
			{
				temp_BingoBoolean.add(SelectedPosition, true) ;
				break ;
			}
			else
				SelectedPosition ++ ;
		}
		
		Lug.e("자리 : "+SelectedPosition) ;
		Lug.e("n숫자 : "+ selectedNumber) ;
		// gameTable[][] 의 5,6번째 배열에 값 넣기
		for(byte i = 0; i<12; i++)
		{
			for(byte j = 0; j < 5; j++)
			{
				if(temp_GameTable[i][j] == SelectedPosition )
					temp_GameTable[i][5] ++ ;

				if(temp_GameTable[i][5] == 5)
					temp_GameTable[i][6] = 1 ;
			}
		}
		data.GamePlayerManager[who][1] = temp_GameTable;
		data.GamePlayerManager[who][3] = temp_BingoBoolean;
		
		RefreshGridView(activity) ;
	}
	private void RefreshGridView(Activity activity)
	{
		Context context = activity.getApplicationContext() ;
		byte who = BingData.Linked(context).GameTurn ;
		switch (who) {
		case 0:
			new Play_user().SetTableSetting(activity) ;
			break;
		case 1 :
		case 2 :
		case 3 :
			new Play_bot().SetTableSetting(activity, who) ;
		}
	}
	/**
	 *  Player Data 관리를 위한 부분
	 */

	public Object[] GetReturnDouble_All(Context context, byte room)
	{
		return BingData.Linked(context).GamePlayerManager[room] ;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Byte> GetReturnDouble_ArrayList(Context context, byte room)
	{
		return (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[room][1];

	}

	public Byte[] GetReturnDouble_Array(Context context, byte room)
	{
		return (Byte[])BingData.Linked(context).GamePlayerManager[room][0] ;
	}

	public void SetReturnDouble(Context context, byte room, Object[] _Value)
	{
		BingData.Linked(context).GamePlayerManager[room] = _Value ;
	}

	private byte WhoIs(Context context)
	{
		byte who  = BingData.Linked(context).GameTurn ;
		
		if(who > BingData.Linked(context).GamerCount)
			who = 0 ;

//		BingData.Linked(context).GameTurn = who ;
		BingData.Linked(context).GameTurn ++ ;
		return who ;
	}

}
