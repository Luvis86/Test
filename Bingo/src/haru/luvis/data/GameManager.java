package haru.luvis.data;

import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;

public class GameManager {
	private byte GameTurn = -1 ;

	public void CheckPosition(Activity activity, int pointer, int selectedNumber)
	{

		GameTurn() ;
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

		byte positionOfSelectedNum = 0; 

		for(byte b : temp_BingoTable) 
		{
			if(b == selectedNumber)
				break ;
			else
				positionOfSelectedNum++ ;
		}		

		// gameTable[][] 의 5,6번째 배열에 값 넣기
		for(byte i = 0; i<12; i++)
		{
			for(byte j = 0; j < 5; j++)
			{
				if(temp_GameTable[i][j] == selectedNumber )
					temp_GameTable[i][5] ++ ;

				if(temp_GameTable[i][5] == 5)
					temp_GameTable[i][6] = 1 ;
			}
		}
//		Button btn_position = (Button)activity.findViewById(pointer) ;
	}


	private void GameTurn()
	{
		GameTurn ++ ;
		if(GameTurn > GameSetting.GamerCount)
			GameTurn = 0; 
	}

}
