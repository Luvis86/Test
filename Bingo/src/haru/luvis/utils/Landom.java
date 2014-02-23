package haru.luvis.utils;

import java.util.ArrayList;

public class Landom 
{

	public ArrayList<Integer> NoOverlap(int range, boolean startZero)
	{
		ArrayList<Integer> _return = new ArrayList<Integer>() ;
		
		int sum = 0;
		if(startZero)
			sum = 1 ; 
			
		for(int i = 0; i < range ; i++)
		{
			
			int a = (int)((Math.random()*DecimalCount(range)) % range + sum) ;
			
			if(i == 0)
				_return.add(a) ;
			
			else
			{
				for(byte j = 0; j< i ; j++)
				{
					if(_return.get(j) != null && _return.get(j) == a)
					{
						i-- ;
						break ;
					}
					
					if(j == i-1)
						_return.add(a) ;
				}
			}
		}
		return _return ;
	}
	
	private int DecimalCount(int value)
	{
		String temp = String.format("%d", value) ;
		
		return (int)Math.pow(10, temp.length()) ;
	}
}
