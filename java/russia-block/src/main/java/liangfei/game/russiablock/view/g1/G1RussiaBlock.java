package liangfei.game.russiablock.view.g1;

import liangfei.game.russiablock.controller.facade.CommandManager;
import liangfei.game.russiablock.model.Game;
import liangfei.game.russiablock.model.Player;
import liangfei.game.russiablock.model.resolver.AllOverThenStopResolver;
import liangfei.game.russiablock.model.resolver.AllReadyThenStartResolver;
import liangfei.game.russiablock.view.decorator.frame.UIStyle;
/**
 * 
 * 单人版
 * 
 * @author 梁飞 (liangfei0201@163.com)
 * 
 * @version 1.0
 * 
 */
public class G1RussiaBlock {
	
	public G1RussiaBlock() {
		int members = 1;
		
		// 服务器端
		Game game = new Game(new AllReadyThenStartResolver(), new AllOverThenStopResolver(), members);
		Player player = new Player();
		game.addPlayer(player);
		
		// 客户端
		UIStyle.setMyStyle();
		new G1GameFrame(new CommandManager(player), player);
	}
	
	public static void main(String[] args) {
		new G1RussiaBlock();
	}
}
