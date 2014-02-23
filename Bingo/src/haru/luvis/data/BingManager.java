package haru.luvis.data;

import haru.luvis.player.Play_bot;
import haru.luvis.player.Play_user;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class BingManager {

	@SuppressWarnings("unchecked")
	public void CheckPosition(Activity activity, byte selectedNumber)
	{
		Context context = activity.getApplicationContext() ;
		byte who =  GameTurn(context) ;

		ArrayList<Byte> temp_BingoPaper =  (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[0][2] ;
		byte[][] temp_GameTable =  (byte[][])BingData.Linked(context).GamePlayerManager[who][1] ;


		byte SelectedPosition = 0;
		for(byte _position : temp_BingoPaper)
		{
			if(_position == selectedNumber)
				break ;
			else
				SelectedPosition ++ ;
		}

		Toast.makeText(context, "자리 : "+SelectedPosition+"\n숫자 : "+ selectedNumber, Toast.LENGTH_SHORT).show() ;
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
		BingData.Linked(context).GamePlayerManager[who][1] = temp_GameTable;
		BingData.Linked(context).GamePlayerManager[who][1] = temp_GameTable;
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

	private byte GameTurn(Context context)
	{
		byte who  = BingData.Linked(context).GameTurn ;

		who ++ ;
		if(who > BingData.Linked(context).GamerCount)
			who = 0 ;

		BingData.Linked(context).GameTurn = who ;

		return who ;
	}

}
