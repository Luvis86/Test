package haru.luvis.data;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

public class GameManager {

	public void CheckPosition(Activity activity, int selectedNumber)
	{

		GameTurn(activity.getApplicationContext()) ;
		
		ArrayList<Byte> temp_BingoPaper = null ;
		byte[][] temp_GameTable = null ;
		switch (GameData.Linked(activity.getApplicationContext()).GameTurn) {
		case 0 :
			temp_BingoPaper = GameData.Linked(activity.getApplicationContext()).User_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).User_GameTable ;
			break;

		case 1 :
			temp_BingoPaper = GameData.Linked(activity.getApplicationContext()).Bot1_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot1_GameTable ;
			break ;

		case 2 :
			temp_BingoPaper = GameData.Linked(activity.getApplicationContext()).Bot2_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot2_GameTable ;
			break ;

		case 3 :
			temp_BingoPaper = GameData.Linked(activity.getApplicationContext()).Bot3_BingoTable ;
			temp_GameTable = GameData.Linked(activity.getApplicationContext()).Bot3_GameTable ;
			break ;
		}

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


	ArrayList<Byte> list1  = new ArrayList<Byte>() ;
	ArrayList<Byte> list2  = new ArrayList<Byte>() ;
	ArrayList<Byte> list3  = new ArrayList<Byte>() ;
	
	Byte[] array1 = new Byte[2] ;
	Byte[] array2 = new Byte[2] ;
	Byte[] array3 = new Byte[2] ;

	Object[][] obj = new Object[3][2] ;
	
	public Object[] Get_ReturnDoble(byte room)
	{
		return obj[room] ;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Byte> Get_ReturnDouble(byte room)
	{
		return (ArrayList<Byte>)obj[room][1];
		
	}
	
	public Byte[] GetReturnDouble(byte room)
	{
		return (Byte[])obj[room][0] ;
	}
	
	public void Set_ReturnDouble(byte room, Object[] _Value)
	{
		obj[room] = _Value ;
	}
	
	
	private void OtherPlaeyer(byte who, byte SelctedNumber)
	{
		
	}
	private void GameTurn(Context context)
	{
		GameData.Linked(context).GameTurn ++ ;
		if(GameData.Linked(context).GameTurn > GameData.Linked(context).GamerCount)
			GameData.Linked(context).GameTurn = 0; 
	}

}
