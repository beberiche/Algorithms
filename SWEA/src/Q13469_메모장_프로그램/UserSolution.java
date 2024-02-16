package Q13469_메모장_프로그램;

import java.util.LinkedList;


class Line {
	int cnt[];
	LinkedList<Character> list;

	Line() {
		list = new LinkedList<>();
		this.cnt = new int[26];
	}
}

class UserSolution {
	private int cursor[];
	private Line lines[];
	private int length;
	private int H, W;

	void init(int H, int W, char mStr[]) {
		cursor = new int[]{0, 0};
		this.H = H;
		this.W = W;
		lines = new Line[H];
		length = 0;
		for (int i = 0; i < H; i++) {
			lines[i] = new Line();
		}

		for (int i = 0; i < mStr.length; i++) {
			if (mStr[i] == '\0') break;
			Character ch = mStr[i];
			int r = i / W;
			Line curr = lines[r];
			curr.cnt[mStr[i] - 'a']++;
			curr.list.add(ch);
			length++;
		}
	}

	void insert(char mChar) {
		int r = cursor[0];
		int c = cursor[1];

		lines[r].list.add(c, mChar);
		lines[r].cnt[mChar - 'a']++;
		int idx = r;
		while (idx < H && lines[idx].list.size() > W) {
			char ch = lines[idx].list.pollLast();
			lines[idx].cnt[ch - 'a']--;
			lines[++idx].list.addFirst(ch);
			lines[idx].cnt[ch - 'a']++;
		}
		cursor[1]++;
		if (cursor[1] == W) {
			cursor[0]++;
			cursor[1] = 0;
		}
		length++;
	}


	char moveCursor(int mRow, int mCol) {
		if ((mRow - 1) * W + mCol - 1 >= length) {
			cursor[0] = length / W;
			cursor[1] = length % W;
			return '$';
		} else {
			cursor[0] = mRow - 1;
			cursor[1] = mCol - 1;
			return lines[cursor[0]].list.get(cursor[1]);
		}
	}

	int countCharacter(char mChar) {
		int ret = 0;
		int lastLine = length / W;
		if (cursor[1] != 0) {
			for (int c = 0; c < cursor[1]; c++) {
				if (lines[cursor[0]].list.get(c) == mChar) ret--;
			}
		}

		for (int r = cursor[0]; r <= lastLine && r < H; r++) {
			ret += lines[r].cnt[mChar - 'a'];
		}

		return ret <= 0 ? 0 : ret;
	}
}