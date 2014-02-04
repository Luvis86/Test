package haru.luvis.utils;


public class DevelopeGuide {

	/*
	GameSetting.java
		public static byte				GamerCount 						// 게임에 참여한 인원
		public ArrayList<Byte> 			TableSetting(int _gameLevel) 	// Game 실행을 위해 랜덤값으로 세팅함 
		private int 					CountDecimal(int value) 		// 자릿수를 구한후 10의 (자릿수)제곱을 함
		
	
	GameData.java
		byte[][]	 					GameTable_User, GameTable_Bot   // 게임 룰에 적용되는 테이블(선택한 번호의 자리를 체크하고 관리)
		ArrayList<Byte> 				UserBingoTable, BotBingoTable 	// 랜덤으로 정렬된 테이블.
		 
		 
	GameRule.java
		final public byte 				GAMELEVEL1 = 25 				// 1~25까지중 난수 선택 가능 
		final public byte 				GAMELEVEL2 = 50 				// 1~50까지중 난수 선택 가능
		final public byte 				GAMELEVEL3 = 99 				// 1~99까지중 난수 선택 가능
	
		final public byte 				GAMEPLAYSINGE = 1 				// 랜덤으로 주어진 난수 체크(1:m)
		final public byte 				GAMEPLAYDOUBLE = 2 				// 봇(AI)과의 게임(1:1) 
		final public byte 				GAMEPLAYFULL = 4 				// 봇(AI)들과의 게임(1:3)

		public byte 					DefaultTableRule[][]  			// 테이블의 선택된 포지션 체크 및 빙고 라인 체크 
	 */
}
