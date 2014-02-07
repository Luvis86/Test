package haru.luvis.bingo;

import haru.luvis.data.GameData;
import haru.luvis.data.GameRule;
import haru.luvis.data.GameSetting;

import java.util.ArrayList;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Game_AI {

	Activity activity ;
	public void Game_AI(Activity activity, int id)
	{
		this.activity = activity ;
		GridView table_ai = (GridView)activity.findViewById(id) ;
		
		GameData.Linked(activity.getApplicationContext()).Bot1_BingoTable = new GameSetting().TableSetting(new GameRule().GAMELEVEL1) ;
		
		TableAiAdapter adpter = new TableAiAdapter(GameData.Linked(activity.getApplicationContext()).Bot1_BingoTable) ;
		
		table_ai.setAdapter(adpter) ;
		
	}
	
	public class TableAiAdapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		
		public TableAiAdapter(ArrayList<Byte> list)
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
			TextView txt = new TextView(activity) ;
			txt.setText(""+list.get(position)) ;
			txt.setGravity(Gravity.CENTER) ;
 			return txt;
		}
		
	}
}
