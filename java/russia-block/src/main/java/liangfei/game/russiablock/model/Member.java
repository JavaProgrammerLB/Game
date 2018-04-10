package liangfei.game.russiablock.model;

import liangfei.game.russiablock.controller.command.GroupCommandReceiver;

public class Member implements GroupCommandReceiver {
	
	private String name;
	
	private int group = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}
	
	// GroupCommandReceiver ----
	
	public void free() {
		this.group = 0;
	}

	public void join(int group) {
		this.group = group;
	}

}
