package haru.luvis.player;

import haru.luvis.bingo.R;
import haru.luvis.bot.Game_AI;
import haru.luvis.data.GameData;
import haru.luvis.data.GameManager;
import haru.luvis.data.GameRule;
import haru.luvis.data.GameSetting;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class Game_play extends Activity {

	private GameManager manager = new GameManager() ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE) ;
		setContentView(R.layout.game_play_2);
		
		GridView table1 = (GridView)findViewById(R.id.table_player) ;
		
		//유저의 빙고리스트 생성 및 테이블 만듬 
		Table1Adapter adpter = new Table1Adapter(GameData.Linked(Game_play.this).User_BingoTable) ;
		table1.setAdapter(adpter) ;
		
		//상대방의 데이터 세팅 및 게임 테이블 만듦
		new Game_AI().Game_AI(Game_play.this, R.id.table_ai) ;
		
	}
	
	public class Table1Adapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		
		public Table1Adapter(ArrayList<Byte> list)
		{
			this.list = list ;
		}
		
		@Override
		public int getCount()
		{
			if(list != null)
				return list.size() ;
			else
				return 0;
		}

		@Override
		public Object getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int position, View arg1, ViewGroup arg2) {
			Button btn = new Button(Game_play.this) ;
//			Lug.e(list.get(position)) ;
			btn.setText(""+list.get(position)) ;
			btn.setTag((int)position) ;
			btn.setOnClickListener(selcetTable) ;
  			return btn;
		}
		
	}
	
	OnClickListener selcetTable = new OnClickListener() {
		
		@Override
		public void onClick(View v) { 
			manager.CheckPosition(Game_play.this, ((View)v.getParent()).getId(), (Integer)v.getTag()) ;
			
		}
	};
}
