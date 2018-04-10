package liangfei.game.russiablock.view.g6;

import liangfei.game.russiablock.controller.facade.CommandManager;
import liangfei.game.russiablock.model.Game;
import liangfei.game.russiablock.model.Player;
import liangfei.game.russiablock.model.resolver.AllOverThenStopResolver;
import liangfei.game.russiablock.model.resolver.AllReadyThenStartResolver;
import liangfei.game.russiablock.view.decorator.frame.UIStyle;
/**
 * 
 * 网络对战版
 * 
 * @author 梁飞 (liangfei0201@163.com)
 * 
 * @version 1.0
 * 
 */
public class G6RussiaBlock {
	
	public G6RussiaBlock() {
		// int rows = 24;
		// int cols = 12;
		int members = 6;
		
		// 服务器端
		Game game = new Game(new AllReadyThenStartResolver(), new AllOverThenStopResolver(), members);
		Player player = new Player();
		game.addPlayer(player);
		
		// 客户端
		UIStyle.setMyStyle();
		new G6GameFrame(new CommandManager(player), player);
	}
	
	public static void main(String[] args) {
		new G6RussiaBlock();
	}
}
