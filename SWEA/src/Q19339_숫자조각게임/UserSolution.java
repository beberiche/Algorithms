package Q19339_숫자조각게임;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolution {


	private Block blocks[];
	private boolean visited[][];
	private int[][] map;
	private List<int[]> used;

	public void init(int mRows, int mCols, int mCells[][]) {
		used = new ArrayList<>();
		visited = new boolean[mRows][mCols];

		createMap(mRows, mCols, mCells);

		int blockCnt = 5;
		blocks = new Block[blockCnt];

		// -- (0)
		blocks[0] = new Block();
		blocks[0].dr = new int[]{0};
		blocks[0].dc = new int[]{1};
		blocks[0].r_range = 0;
		blocks[0].c_range = 1;

		// --- (1)
		blocks[1] = new Block();
		blocks[1].dr = new int[]{0, 0};
		blocks[1].dc = new int[]{1, 1};
		blocks[1].r_range = 0;
		blocks[1].c_range = 2;

		// |
		// |
		// | (2)
		blocks[2] = new Block();
		blocks[2].dr = new int[]{1, 1};
		blocks[2].dc = new int[]{0, 0};
		blocks[2].r_range = 2;
		blocks[2].c_range = 0;

		// --
		//  __ (3)
		blocks[3] = new Block();
		blocks[3].dr = new int[]{0, 1, 0};
		blocks[3].dc = new int[]{1, 0, 1};
		blocks[3].r_range = 1;
		blocks[3].c_range = 2;

		// |
		// |_
		//   |
		//   | (4)
		blocks[4] = new Block();
		blocks[4].dr = new int[]{1, 0, 0, 1};
		blocks[4].dc = new int[]{0, 1, 1, 0};
		blocks[4].r_range = 2;
		blocks[4].c_range = 2;


		// 블록별 맵에 대한 모든 경우의 수 매핑
		for (int i = 0; i < mRows; i++) {
			for (int j = 0; j < mCols; j++) {
				for (int k = 0; k < blockCnt; k++) {
					mapping(blocks[k], i, j);
				}
			}
		}
	}

	public Solution.Result putPuzzle(int mPuzzle[][]) {
		Solution.Result ret = new Solution.Result(-1, -1);

		int id = findBlockId(mPuzzle);
		Block b = blocks[id];
		String key = createKey(b, mPuzzle);

		if (!b.m.containsKey(key)) return ret;

		List<int[]> pos = b.m.get(key);

		for (int i = 0; i < pos.size(); i++) {
			if (checkVisited(b, pos.get(i))) {
				goVisited(b, pos.get(i));
				ret = new Solution.Result(pos.get(i)[0], pos.get(i)[1]);
				break;
			}
		}

		return ret;
	}


	public void clearPuzzles() {
		for (int[] u : used) {
			visited[u[0]][u[1]] = false;
		}
		used.clear();
	}


	////////////////////////////////////
	// 사용자 구현 함수 ////////////////////
	////////////////////////////////////
	////////////////////////////////////

	private void createMap(int mRows, int mCols, int[][] mCells) {
		map = new int[mRows][mCols];
		for (int i = 0; i < mRows; i++) {
			for (int j = 0; j < mCols; j++) {
				map[i][j] = mCells[i][j];
			}
		}
	}

	private void mapping(Block b, int r, int c) {
		int num = map[r][c];
		if (r + b.r_range >= map.length || c + b.c_range >= map[0].length) return;

		int curr_r = r;
		int curr_c = c;

		StringBuilder sb = new StringBuilder();
		for (int d = 0; d < b.dr.length; d++) {
			int nr = curr_r + b.dr[d];
			int nc = curr_c + b.dc[d];

			sb.append("/").append(map[nr][nc] - num);
			curr_r = nr;
			curr_c = nc;
		}

		if (!b.m.containsKey(sb.toString())) b.m.put(sb.toString(), new ArrayList<>());

		b.m.get(sb.toString()).add(new int[]{r, c});
	}

	private int findBlockId(int[][] mPuzzle) {
		int cnt = 0;
		for (int i = 0; i < mPuzzle.length; i++) {
			for (int j = 0; j < mPuzzle[0].length; j++) {
				if (mPuzzle[i][j] != 0) cnt++;
			}
		}

		int id = -1;
		switch (cnt) {
			case 2: {
				id = 0;
				break;
			}
			case 3: {
				if (mPuzzle[0][1] != 0) id = 1;
				else if (mPuzzle[1][0] != 0) id = 2;
				break;
			}
			case 4: {
				id = 3;
				break;
			}
			case 5: {
				id = 4;
				break;
			}
		}
		return id;
	}

	private String createKey(Block b, int[][] mPuzzle) {
		int num = mPuzzle[0][0];
		int curr_r = 0;
		int curr_c = 0;

		StringBuilder sb = new StringBuilder();
		for (int d = 0; d < b.dr.length; d++) {
			int nr = curr_r + b.dr[d];
			int nc = curr_c + b.dc[d];

			sb.append("/").append(mPuzzle[nr][nc] - num);
			curr_r = nr;
			curr_c = nc;
		}

		return sb.toString();
	}

	private boolean checkVisited(Block b, int[] pos) {
		int curr_r = pos[0];
		int curr_c = pos[1];
		for (int d = 0; d < b.dr.length; d++) {
			if (visited[curr_r][curr_c]) return false;
			curr_r += b.dr[d];
			curr_c += b.dc[d];
		}
		if (visited[curr_r][curr_c]) return false;

		return true;
	}

	private void goVisited(Block b, int[] pos) {
		int curr_r = pos[0];
		int curr_c = pos[1];

		for (int d = 0; d < b.dr.length; d++) {
			visited[curr_r][curr_c] = true;
			used.add(new int[]{curr_r, curr_c});
			curr_r += b.dr[d];
			curr_c += b.dc[d];
		}
		visited[curr_r][curr_c] = true;
		used.add(new int[]{curr_r, curr_c});
	}

	private class Block {
		int dr[], dc[], r_range, c_range;
		Map<String, List<int[]>> m = new HashMap<>();
	}


}
