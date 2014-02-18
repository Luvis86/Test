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

	private GameManager manager = new GameManager() ;
	Activity m_activity ;
	Context m_context ;
	public void Create_Player(Activity activity, int _id)
	{
		m_activity = activity ;
		m_context = activity.getApplicationContext() ;
		
		GridView table1 = (GridView)activity.findViewById(_id) ;

		//유저의 빙고리스트 생성 및 테이블 만듬 
		Table1Adapter adpter = new Table1Adapter(GameData.Linked(m_context).User_BingoTable) ;
		table1.setAdapter(adpter) ;
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
			Button btn = new Button(m_activity) ;
//						Lug.e(list.get(position)) ;
			btn.setText(""+list.get(position)) ;
			btn.setTag((int)position) ;
			btn.setOnClickListener(selcetTable) ;
			return btn;
		}

	}

	OnClickListener selcetTable = new OnClickListener() {

		@Override
		public void onClick(View v) { 
//			manager.CheckPosition(m_activity, ((View)v.getParent()).getId(), (Integer)v.getTag()) ;

		}
	};
}
