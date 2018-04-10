package liangfei.game.russiablock.model;

import java.util.HashMap;
import java.util.Map;

public class MagicHeap {
	
	private Map magics = new HashMap();
	
	public boolean hasMagic(int magic) {
		return magics.containsKey(new Integer(magic));
	}
	
	public int popMagic(int magic) {
		magics.remove(new Integer(magic));
		return magic;
	}
	
}
