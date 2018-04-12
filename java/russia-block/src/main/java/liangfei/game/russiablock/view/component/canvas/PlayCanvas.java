package liangfei.game.russiablock.view.component.canvas;

import java.awt.Graphics;

import liangfei.game.russiablock.controller.listener.BlockListener;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.controller.listener.LocationListener;
import liangfei.game.russiablock.controller.listener.LocationSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Box;
import liangfei.game.russiablock.domain.Location;
import liangfei.game.russiablock.view.decorator.box.BoxDecorator;

public class PlayCanvas extends BoardCanvas implements BlockListener, LocationListener {

	private static final long serialVersionUID = 1L;

	public PlayCanvas() {
		super();
	}
	
	public PlayCanvas(BoxDecorator boxDecorator) {
		super(boxDecorator);
	}
	
	// BlockListener ---------
	
	private BlockSubject blockSubject;
	
	public void setBlockSubject(BlockSubject blockSubject) {
		if (this.blockSubject != null) {
			this.blockSubject.removeBlockListener(this);
		}
		if (blockSubject != null) {
			blockSubject.addBlockListener(this);
		}
		this.blockSubject = blockSubject;
	}
	
	private Block block;

	@Override
	public void blockChanged(Block block) {
		this.block = block;
		repaint();
	}
	
	// LocationListener -------
	
	private LocationSubject locationSubject;
	
	public void setLocationSubject(LocationSubject locationSubject) {
		if (this.locationSubject != null) {
			this.locationSubject.removeLocationListener(this);
		}
		if (locationSubject != null) {
			locationSubject.addLocationListener(this);
		}
		this.locationSubject = locationSubject;
	}
	
	private Location location;

	@Override
	public void locationChanged(Location location) {
		this.location = location;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (block != null && location != null) {
			for (BlockIterator i = block.iterator(); i.hasNextBox();) {
				Box box = i.nextBox();
				int row = location.getRow() + box.getOffsetRow();
				int col = location.getCol() + box.getOffsetCol();
				boxDecorator.drawBox(g, col * getBoxSize(), row * getBoxSize(), getBoxSize(), box.getStyle());
			}
		}
	}

}
