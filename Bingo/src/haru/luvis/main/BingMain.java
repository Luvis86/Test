package haru.luvis.main;

import haru.luvis.bing.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BingMain extends Activity{

	Button [] btn_line1, btn_line2 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bing_main) ;
		CreateButton(this) ;

	}
	private void CreateButton(Activity activity)
	{
		int address_line1 = getResources().getIdentifier("Button00", "id", getPackageName()) ;
		int address_line2 = getResources().getIdentifier("Button10", "id", getPackageName()) ;
		btn_line1 = new Button[3] ;
		btn_line2 = new Button[3] ;
		for(int a = 0; a<3; a++)
		{
			btn_line1[a] = (Button)findViewById(address_line1) ;
			btn_line1[a].setOnClickListener(BtnLine1_Clicked) ;
			btn_line1[a].setTag((Integer)a) ;
			address_line1++ ;

			btn_line2[a] = (Button)findViewById(address_line2) ;
			btn_line2[a].setOnClickListener(BtnLine2_Clicked) ;
			btn_line2[a].setTag((Integer)a) ;
			address_line2++ ;
		}
	}

	
	private OnClickListener BtnLine1_Clicked = new OnClickListener() {
		@Override
		public void onClick(View v) 
		{
			PressedButton(btn_line1, (Integer)v.getTag());
		}
	};

	
	private OnClickListener BtnLine2_Clicked = new OnClickListener() {
		@Override
		public void onClick(View v) 
		{
			PressedButton(btn_line2, (Integer)v.getTag());
		}
	};

	
	private void PressedButton(Button[] btn, int position) 
	{

		for(int k = 0; k<btn.length; k++)
		{
			if(k == position)
				btn[k].setBackgroundColor(Color.BLUE) ;
			else
				btn[k].setBackgroundResource(android.R.drawable.btn_default) ;

		}
	}
}
