package haru.luvis.data;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class GameManager {
	private byte GameTurn = -1 ;

	public void CheckPosition(Activity activity, int pointer, int selectedPosition)
	{

		GameTurn(activity.getApplicationContext()) ;
		
		ArrayList<Byte> temp_BingoTable = null ;
		byte[][] temp_GameTable = null ;
		switch (GameTurn) {
		case 0 :
			temp_BingoTable = GameData.Linked(activity.getApplicationContext()).User_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).User_GameTable ;
			break;

		case 1 :
			temp_BingoTable = GameData.Linked(activity.getApplicationContext()).Bot1_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot1_GameTable ;
			break ;

		case 2 :
			temp_BingoTable = GameData.Linked(activity.getApplicationContext()).Bot2_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot2_GameTable ;
			break ;

		case 3 :
			temp_BingoTable = GameData.Linked(activity.getApplicationContext()).Bot3_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot3_GameTable ;
			break ;
		}

		byte NumberOfSelectedPosition = temp_BingoTable.get(selectedPosition); 

		Toast.makeText(activity.getApplicationContext(), "숫자 : "+NumberOfSelectedPosition+"\n자리 : "+ selectedPosition, Toast.LENGTH_SHORT).show() ;
		// gameTable[][] 의 5,6번째 배열에 값 넣기
		for(byte i = 0; i<12; i++)
		{
			for(byte j = 0; j < 5; j++)
			{
				if(temp_GameTable[i][j] == selectedPosition )
					temp_GameTable[i][5] ++ ;

				if(temp_GameTable[i][5] == 5)
					temp_GameTable[i][6] = 1 ;
			}
		}
//		Button btn_position = (Button)activity.findViewById(pointer) ;
	}


	private void GameTurn(Context context)
	{
		GameTurn ++ ;
		if(GameTurn > GameData.Linked(context).GamerCount)
			GameTurn = 0; 
	}

}
