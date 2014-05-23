package haru.luvis.player;

import haru.luvis.data.BingData;
import haru.luvis.utils.Lug;

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

@SuppressWarnings("unchecked")
public class Play_bot 
{

	Activity m_activity ;
	Context m_context;
	public static GridView gridView_Bot ;
	public void Create_AI(Activity activity, byte who)
	{
		m_activity = activity ;
		m_context = activity.getApplicationContext();

		SetTableSetting(activity, who) ;
	}


	public void SetTableSetting(Activity activity, byte who)
	{
		//유저의 빙고리스트 생성 및 테이블 만듬

		Context context = activity.getApplicationContext() ;
		ArrayList<Byte> _val = (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[who][2] ;
		int id = (Integer)BingData.Linked(context).GamePlayerManager[who][0] ;
		
		TableAIAdapter adapter = new TableAIAdapter(activity, _val, who) ;
		
		if(gridView_Bot == null)
			gridView_Bot =(GridView)activity.findViewById(id) ;
		
		gridView_Bot.setAdapter(adapter) ;

	}



	/**
	 * @param context
	 * @param who
	 * @return
	 * AI가 선택해야 하는 최적의 숫자를 찾음 
	 */
	public byte FindRandomNumber(Activity activity, Context context, byte who)
	{
		byte Return = 0;
		byte ChoiceLineCount = 0;
		byte ChoiceLine = -1 ;
		byte bestPosition = 12 ;
		byte[][] RuleTable = (byte[][])BingData.Linked(context).GamePlayerManager[who][1] ;
		ArrayList<Boolean> checkBing = (ArrayList<Boolean>)BingData.Linked(context).GamePlayerManager[who][3] ;
		ArrayList<Byte> BingTable = (ArrayList<Byte>)BingData.Linked(context).GamePlayerManager[who][2] ;

		//리스트의 가장 중간 값이 True 일 경우 다른 랜덤 숫자를 불러옴.
		//False 일 경우는 bingTable의 가운데 숫자를 가져옴.

		if(checkBing.get(12))
		{
			for(byte i = 0; i<12; i++)
			{
				if(RuleTable[i][5] > ChoiceLineCount && RuleTable[i][5] < 5)
				{
					ChoiceLine = i ;
					ChoiceLineCount = RuleTable[i][5] ;
				}
			}

			for(byte i = 0; ; i++)
			{
				byte rand = (byte)(Math.random()*100 %5) ;
				if(!checkBing.get(i))
				{
					bestPosition = RuleTable[ChoiceLine][rand];
					break ;
				}
			}
			Return = BingTable.get(bestPosition) ;
		}
		else
			Return = BingTable.get(12) ;

		Lug.e(Return) ;
		return Return ;
	}
	
	
	public class TableAIAdapter extends BaseAdapter
	{
		ArrayList<Byte> list ;
		Activity activity ;
		ArrayList<Boolean> checkBing = null ;

		public TableAIAdapter(Activity activity, ArrayList<Byte> list, byte who)
		{
			this.list = list ;
			this.activity = activity ;

			checkBing = (ArrayList<Boolean>)BingData.Linked(activity.getApplicationContext()).GamePlayerManager[who][3] ;
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
			txt.setTextColor(Color.BLACK) ;
			txt.setGravity(Gravity.CENTER) ;
			if(checkBing.get(position))
			{
				txt.setBackgroundColor(Color.RED) ;
			}
			return txt;
		}
	}
}
