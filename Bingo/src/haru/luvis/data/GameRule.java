package haru.luvis.data;


public class GameRule 
{
	private static GameRule gameRle = null ;
	
	public GameRule Linked()
	{
		if(gameRle == null)
			gameRle = new GameRule() ;
		return gameRle ;
	}
	
	public void GameRule()
	{
			
	}
	
	final public byte GAMELEVEL1 = 25 ;
	final public byte GAMELEVEL2 = 50 ;
	final public byte GAMELEVEL3 = 99 ;

	public final byte GAMEPLAYSINGLE = 1 ;
	final public byte GAMEPLAYDOUBLE = 2 ;
	final public byte GAMEPLAYFULL = 4 ;

	public byte DefaultBingoRule[][] = { 
		{ 0,   1,  2,   3,  4, 0, 0},
		{ 5,   6,  7,   8,  9, 0, 0},
		{10, 11, 12, 13, 14, 0, 0},
		{15, 16, 17, 18, 19, 0, 0},
		{20, 21, 22, 23, 24, 0, 0},

		{ 0,   5, 10, 15, 20, 0, 0},
		{ 1,   6, 11, 16, 21, 0, 0},
		{ 2,   7, 12, 17, 22, 0, 0},
		{ 3,   8, 13, 18, 23, 0, 0},
		{ 4,   9, 14, 19, 24, 0, 0},

		{ 4,   8, 12, 16, 20, 0, 0},
		{ 0,   6, 12, 18, 24, 0, 0} };

}
