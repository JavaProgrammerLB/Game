package liangfei.game.russiablock.util;

import java.util.TreeSet;

public class IntegerSortSet extends TreeSet {

	private static final long serialVersionUID = 1L;

	public IntegerSortSet() {
		super (new IntegerComparator());
	}

}
