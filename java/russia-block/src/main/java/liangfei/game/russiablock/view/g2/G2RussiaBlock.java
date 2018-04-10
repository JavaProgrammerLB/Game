package liangfei.game.russiablock.view.g2;

import liangfei.game.russiablock.controller.facade.CommandManager;
import liangfei.game.russiablock.model.Game;
import liangfei.game.russiablock.model.Player;
import liangfei.game.russiablock.model.resolver.AllReadyThenStartResolver;
import liangfei.game.russiablock.model.resolver.OnlyMemberThenStopResolver;
import liangfei.game.russiablock.view.decorator.frame.UIStyle;
/**
 * 
 * 单机对战版
 * 
 * @author 梁飞 (liangfei0201@163.com)
 * 
 * @version 1.0
 * 
 */
public class G2RussiaBlock {
	
	public G2RussiaBlock() {
		int members = 2;
		
		// 服务器端
		Game game = new Game(new AllReadyThenStartResolver(), new OnlyMemberThenStopResolver(), members);
		Player player1 = new Player();
		game.addPlayer(player1);
		Player player2 = new Player();
		game.addPlayer(player2);
		
		// 客户端
		UIStyle.setMyStyle();
		new G2GameFrame(new CommandManager(player1), player1,
				new CommandManager(player2), player2);
	}
	
	public static void main(String[] args) {
		new G2RussiaBlock();
	}
	
}
