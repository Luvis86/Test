package haru.luvis.player;

import haru.luvis.data.GameData;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Play_bot {

	Activity activity ;
	Context context;
	public void Create_AI(Activity activity, int id)
	{
		this.activity = activity ;
		this.context = activity.getApplicationContext();
		
		GridView table_ai = (GridView)activity.findViewById(id) ;
		
		ArrayList<Byte> _val = (ArrayList<Byte>)GameData.Linked(context).GamePlayerManager[1][2] ;
		TableAiAdapter adpter = new TableAiAdapter(_val) ;
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
