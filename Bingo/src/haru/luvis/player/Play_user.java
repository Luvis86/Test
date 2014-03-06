package haru.luvis.player;

import haru.luvis.data.BingData;
import haru.luvis.data.BingManager;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

@SuppressWarnings("unchecked")
public class Play_user{

	Activity m_activity ;
	Context m_context ;

	public static GridView gridView ;
	public void Create_Player(Activity activity)
	{
		m_activity = activity ;
		m_context = activity.getApplicationContext() ;

		//		GridView table1 = (GridView)activity.findViewById(_id) ;
		SetTableSetting(activity) ;

	}

	
	public void SetTableSetting(Activity activity)
	{
		//유저의 빙고리스트 생성 및 테이블 만듬

		Context context = activity.getApplicationContext() ;
		ArrayList<Byte> _val = (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[0][2] ;
		int id = (Integer)BingData.Linked(context).GamePlayerManager[0][0] ;

		TableUserAdapter adpter = new TableUserAdapter(activity, _val) ;
		
		if(gridView == null)
			gridView = (GridView)activity.findViewById(id) ;
		
		gridView.setAdapter(adpter) ;
	}

	public class TableUserAdapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		Activity actvity ;
		ArrayList<Boolean> checkBing = null;
		public TableUserAdapter(Activity activity, ArrayList<Byte> list)
		{
			this.list = list ;
			this.actvity = activity;
			checkBing = (ArrayList<Boolean>)BingData.Linked(activity.getApplicationContext()).GamePlayerManager[0][3] ;
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
			Button btn = new Button(actvity) ;
			btn.setText(""+list.get(position)) ;
			btn.setTag((byte)position);
			if(checkBing.get(position) == true)
			{
				btn.setBackgroundColor(Color.GREEN);
			}
			else
			{
				btn.setOnClickListener(btn_click) ;
			}
			return btn;
		}

	}
	 
	private OnClickListener btn_click = new OnClickListener() {
		@Override
		public void onClick(View v) {
//			Activity activity = (Activity) v.getContext() ;
//			view.isFocused() ;
			
			byte position = ((ArrayList<Byte>)BingData.Linked(v.getContext()).GamePlayerManager[0][2]).get((Byte)v.getTag()) ; 
			Lug.e(position);
			new BingManager().Management((Activity) v.getContext(), position) ;
		}
	};
	
	
}
