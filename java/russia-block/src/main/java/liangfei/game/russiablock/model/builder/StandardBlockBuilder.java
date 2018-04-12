package liangfei.game.russiablock.model.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.Box;

public class StandardBlockBuilder implements BlockBuilder {
	
	public StandardBlockBuilder() {
		
	}

	@Override
	public Collection build() {
		return getBlocksByArray();
	}
	
	private List getBlocksByArray() {
		List list = new ArrayList();
		String[] config = {"0,0,0,-1,0,1,0,2;0,0,-1,0,1,0,2,0", // I形
				"0,0,1,0,0,-1,0,1;0,0,1,0,0,-1,-1,0;0,0,0,-1,-1,0,0,1;0,0,1,0,-1,0,0,1", // T形
				"0,0,-1,-1,-1,0,0,1;0,0,1,0,0,1,-1,1", // Z形
				"0,0,1,0,-1,0,1,1;0,0,1,-1,0,-1,0,1;0,0,1,0,-1,-1,-1,0;0,0,0,-1,0,1,-1,1", // L形
				"0,0,1,-1,1,0,0,1;0,0,1,1,-1,0,0,1", // 反Z形
				"0,0,1,-1,1,0,-1,0;0,0,0,-1,-1,-1,0,1;0,0,1,0,-1,0,-1,1;0,0,1,1,0,-1,0,1", // 反L形
				"0,0,1,0,1,1,0,1"}; // 方形
		for (int i = 0; i < config.length; i ++) {
			list.addAll(parseBlockList(config[i], i + 1));
		}
		return list;
	}
	
	/*private List getBlocksByTxt() {
		List list = new ArrayList();
		String url = this.getClass().getPackage().getName();
		url = url.replace('.', '/');
		InputStream input = this.getClass().getClassLoader().getResourceAsStream(url + "block-standard.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(input));
			String line = br.readLine();
			while (line != null) {
				list.addAll(parseBlockList(line));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}*/
	
	private List parseBlockList(String line, int style) {
		line = line.trim();
		
		String[] parts = line.split(";");
		List blocks = new ArrayList(parts.length);
		for (int i = 0; i < parts.length; i++) {
			Block block = parseBlock(parts[i], style);
			blocks.add(block);
		}
		
		for (int i = 0; i < blocks.size(); i++) {
			BaseBlock block = (BaseBlock)blocks.get(i);
			if (i == blocks.size() -1) {
				block.setNextDirectionBolck((BaseBlock)blocks.get(0));
			} else {
				block.setNextDirectionBolck((BaseBlock)blocks.get(i + 1));
			}
			if (i == 0) {
				block.setPreviousDirectionBolck((BaseBlock)blocks.get(blocks.size() - 1));
			} else {
				block.setPreviousDirectionBolck((BaseBlock)blocks.get(i - 1));
			}
		}
		return blocks;
	}
	
	private Block parseBlock(String part, int style) {
		String[] points = part.split(",");
		Box[] boxes = new Box[points.length / 2];
		for (int i = 0; i < points.length; i += 2) {
			int offsetRow = Integer.parseInt(points[i]);
			int offsetCol = Integer.parseInt(points[i + 1]);
			boxes[i / 2] = new Box(offsetRow, offsetCol, style);
		}
		return new BaseBlock(boxes);
	}
}
