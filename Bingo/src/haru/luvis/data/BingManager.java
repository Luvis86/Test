package haru.luvis.data;

import haru.luvis.player.Play_bot;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

@SuppressWarnings("unchecked")
public class BingManager {


	public void Management(Activity activity, byte selectedNumber)
	{
		BingData bing = BingData.Linked(activity.getApplicationContext()) ;

		for(byte k = 1; k< bing.GamerCount; k++)
		{
			CheckPosition(activity, selectedNumber, k) ;
		}
	}


	public void CheckPosition(Activity activity, byte selectedNumber, byte who)
	{
		Context context = activity.getApplicationContext() ;
		BingData data = BingData.Linked(context) ;

		ArrayList<Byte> temp_BingoPaper =  (ArrayList<Byte>)data.GamePlayerManager[who][2] ;
		byte[][] temp_GameTable =  (byte[][])data.GamePlayerManager[who][1] ;

		ArrayList<Boolean> temp_BingoBoolean = new ArrayList<Boolean>() ; 
		temp_BingoBoolean = (ArrayList<Boolean>)data.GamePlayerManager[who][3] ;

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
		data.GamePlayerManager[who][3] = null ; 
		data.GamePlayerManager[who][3] = temp_BingoBoolean;

		RefreshGridView(activity, data.GamerCount) ;
	}
	
	
	
	private void RefreshGridView(Activity activity, byte gamerCount)
	{
		Context context = activity.getApplicationContext() ;

		for(byte k = 1; k<gamerCount ; k++)
			new Play_bot().SetTableSetting(activity, k) ;
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
