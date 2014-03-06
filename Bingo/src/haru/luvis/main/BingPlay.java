package haru.luvis.main;

import haru.luvis.bing.R;
import haru.luvis.data.BingData;
import haru.luvis.data.BingSetting;
import haru.luvis.player.Play_bot;
import haru.luvis.player.Play_user;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BingPlay extends Activity{
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
		int centerLayoutId = -1 ;
		switch (gameData.GamerCount) 
		{ 
		case GAMEPLAYFULL :

		case GAMEPLAYDOUBLE :
			id_table[1] = R.id.table_ai ;
			contentViewID = R.layout.bing_play2 ;
			centerLayoutId = getResources().getIdentifier("game_play2_include", "id", getPackageName()) ;
		case GAMEPLAYSINGLE :
			id_table[0] = R.id.table_player ;
			break ;
		}

		setContentView(contentViewID);
		new BingSetting().GameSetting(BingPlay.this, id_table, centerLayoutId) ;
	}
	@Override
	protected void onDestroy() {
		if(Play_bot.gridView_Bot != null)
		{
			Play_bot.gridView_Bot = null ;
			Play_user.gridView = null ;
		}
				
		super.onDestroy();
	}
}
