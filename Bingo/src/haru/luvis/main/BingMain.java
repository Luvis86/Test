package haru.luvis.main;

import haru.luvis.bingo.R;
import haru.luvis.data.BingData;
import haru.luvis.data.BingSetting;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BingMain extends Activity{
	//Luvis user가 선택한 값
	final byte HowManyPlayer = 2 ; 
	final byte WhatsThePlayLevel = 25 ; 
	
	final public byte GAMELEVEL1 = 25 ;
	final public byte GAMELEVEL2 = 50 ;
	final public byte GAMELEVEL3 = 99 ;

	public final byte GAMEPLAYSINGLE = 1 ;
	final public byte GAMEPLAYDOUBLE = 2 ;
	final public byte GAMEPLAYFULL = 4 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE) ;
		
		BingData gameData = BingData.Linked(this) ;
		
		//Luvis 고정값이 변경해야 함.
		gameData.GamerCount = HowManyPlayer ;
		gameData.GameLevel = WhatsThePlayLevel ;
		
		int [] id_table  = new int[gameData.GamerCount];	//gridview Table ID 저장.[user, bot1, bot2, bot3]
		int contentViewID = -1 ;	//인원수에 따라 layout 을 다르게 불러옴
		
		switch (gameData.GamerCount) 
		{ 
		case GAMEPLAYFULL :
			
		case GAMEPLAYDOUBLE :
			id_table[1] = R.id.table_ai ;
			contentViewID = R.layout.bing_play2 ;
			
		case GAMEPLAYSINGLE :
			id_table[0] = R.id.table_player ;
			break ;
		}

		setContentView(contentViewID);
		new BingSetting().GameSetting(BingMain.this, id_table) ;
	}

}
