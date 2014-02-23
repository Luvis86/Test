package haru.luvis.player;

import haru.luvis.data.GameData;
import haru.luvis.data.GameManager;
import haru.luvis.utils.Lug;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class Play_user{

	Activity m_activity ;
	Context m_context ;

	public void Create_Player(Activity activity)
	{
		m_activity = activity ;
		m_context = activity.getApplicationContext() ;

//		GridView table1 = (GridView)activity.findViewById(_id) ;
		SetTableSetting(activity) ;

	}
	
	@SuppressWarnings("unchecked")
	public void SetTableSetting(Activity activity)
	{
		//유저의 빙고리스트 생성 및 테이블 만듬
		
		Context context = activity.getApplicationContext() ;
		ArrayList<Byte> _val = (ArrayList<Byte>)GameData.Linked(context).GamePlayerManager[0][2] ;
		int id = (Integer)GameData.Linked(context).GamePlayerManager[0][0] ;
		
		Table1Adapter adpter = new Table1Adapter(activity, _val) ;
		GridView _gridView = (GridView)activity.findViewById(id) ;
		_gridView.setAdapter(adpter) ;
	}

	public class Table1Adapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		Activity actvity ;
		public Table1Adapter(Activity _activity, ArrayList<Byte> list)
		{
			this.list = list ;
			this.actvity = _activity;
		}

		@Override
		public int getCount()
		{
			Lug.e(list.size()) ;
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
			Lug.e(""+list.get(position)) ;
			
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Button btn = (Button)v.findViewById(v.getId()) ;
					int a = Integer.valueOf(btn.getText()+"");
					new GameManager().CheckPosition(actvity, a) ;
				}
			}) ;
			return btn;
		}

	}
}
