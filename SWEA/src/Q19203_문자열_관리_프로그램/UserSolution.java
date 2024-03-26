package Q19203_문자열_관리_프로그램;

import java.util.HashMap;
import java.util.Map;

class UserSolution {
	private Map<String, Integer> m[];
	private boolean isReversed;
	private StringBuilder currStr;
	private int max_len = 5;

	void init(char mStr[]) {
		m = new Map[max_len];
		isReversed = false;
		currStr = charArrToSb(mStr);

		for (int i = 1; i < max_len; i++) {
			m[i] = new HashMap<>();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append(mStr[j]);
			}
			m[i].put(sb.toString(), 1);
			for (int j = i; j < mStr.length; j++) {
				if (mStr[j] == '\0') break;

				sb.deleteCharAt(0);
				sb.append(mStr[j]);
				String str = sb.toString();

				m[i].put(str, m[i].getOrDefault(str, 0) + 1);
			}
		}
	}

	void appendWord(char mWord[]) {
		if (isReversed) appendWordReversed(mWord);
		else appendWordStraight(mWord);
	}

	void cut(int k) {
		if (isReversed) cutReversed(k);
		else cutStraight(k);
	}

	void appendWordReversed(char[] mWord) {
		StringBuilder new_sb = charArrToSb(mWord);
		for (int i = 1; i < max_len; i++) {
			StringBuilder sb = new StringBuilder(new_sb);

			for (int j = 0; j < i - 1; j++) {
				sb.append(currStr.charAt(j));
			}

			StringBuilder sb2 = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb2.append(sb.charAt(j));
			}

			m[i].put(sb2.toString(), m[i].getOrDefault(sb2.toString(), 0) + 1);

			for (int j = i; j < sb.length(); j++) {
				sb2.deleteCharAt(0);
				sb2.append(sb.charAt(j));
				String str = sb2.toString();

				m[i].put(str, m[i].getOrDefault(str, 0) + 1);
			}

		}
		currStr = new_sb.append(currStr);
	}

	void appendWordStraight(char[] mWord) {
		StringBuilder new_sb = charArrToSb(mWord);
		for (int i = 1; i < max_len; i++) {
			StringBuilder sb = new StringBuilder();

			// 현재 문자열 추가 부분
			for (int j = currStr.length() - (i - 1); j < currStr.length(); j++) {
				sb.append(currStr.charAt(j));
			}

			sb.append(new_sb.charAt(0));


			m[i].put(sb.toString(), m[i].getOrDefault(sb.toString(), 0) + 1);
			for (int j = 1; j < new_sb.length(); j++) {
				sb.deleteCharAt(0);
				sb.append(new_sb.charAt(j));
				String str = sb.toString();

				m[i].put(str, m[i].getOrDefault(str, 0) + 1);
			}
		}

		currStr.append(new_sb);
	}


	void cutStraight(int k) {
		StringBuilder cut_sb = charArrToSb(currStr.substring(currStr.length() - k, currStr.length()).toCharArray());
		int cut_size = cut_sb.length();
		for (int i = 1; i < max_len; i++) {
			StringBuilder sb = new StringBuilder();

			// 현재 문자열 추가 부분
			for (int j = currStr.length() - i - cut_size + 1; j < currStr.length() - k; j++) {
				sb.append(currStr.charAt(j));
			}

			sb.append(cut_sb.charAt(0));

			m[i].put(sb.toString(), m[i].get(sb.toString()) - 1);
			for (int j = 1; j < cut_size; j++) {
				sb.deleteCharAt(0);
				sb.append(cut_sb.charAt(j));
				String str = sb.toString();

				m[i].put(str, m[i].get(str) - 1);
			}
		}
		currStr = currStr.delete(currStr.length() - k, currStr.length());
	}

	void cutReversed(int k) {
		StringBuilder cut_sb = charArrToSb(currStr.substring(0, k).toCharArray());
		int cut_size = cut_sb.length();
		for (int i = 1; i < max_len; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < i; j++) {
				sb.append(currStr.charAt(j));
			}


			m[i].put(sb.toString(), m[i].get(sb.toString()) - 1);

			for (int j = i; j < cut_size + i - 1; j++) {
				sb.deleteCharAt(0);
				sb.append(currStr.charAt(j));
				String str = sb.toString();

				m[i].put(str, m[i].get(str) - 1);
			}
		}
		currStr = currStr.delete(0, k);
	}

	void reverse() {
		isReversed = !isReversed;
	}

	int countOccurrence(char mWord[]) {
		StringBuilder sb = charArrToSb(mWord);
		int ans = m[sb.length()].getOrDefault(sb.toString(), 0);
		return ans;
	}

	StringBuilder charArrToSb(char mWord[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mWord.length; i++) {
			if (mWord[i] == '\0') break;
			sb.append(mWord[i]);
		}
		return isReversed ? sb.reverse() : sb;
	}
}