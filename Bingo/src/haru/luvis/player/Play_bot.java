package haru.luvis.player;

import haru.luvis.data.BingData;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Play_bot {

	Activity activity ;
	Context context;
	public void Create_AI(Activity activity, byte who)
	{
		this.activity = activity ;
		this.context = activity.getApplicationContext();
		
		SetTableSetting(activity, who) ;
	}
	
	
	@SuppressWarnings("unchecked")
	public void SetTableSetting(Activity activity, byte who)
	{
		//유저의 빙고리스트 생성 및 테이블 만듬
		
		Context context = activity.getApplicationContext() ;
		ArrayList<Byte> _val = (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[who][2] ;
		int id = (Integer)BingData.Linked(context).GamePlayerManager[who][0] ;
		
		TableAIAdapter adpter = new TableAIAdapter(_val) ;
		
		GridView _gridView = (GridView)activity.findViewById(id) ;
		_gridView.setAdapter(adpter) ;
	}

	public class TableAIAdapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		
		public TableAIAdapter(ArrayList<Byte> list)
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
			txt.setTextColor(Color.RED) ;
			txt.setGravity(Gravity.CENTER) ;
 			return txt;
		}
		
	}
}
