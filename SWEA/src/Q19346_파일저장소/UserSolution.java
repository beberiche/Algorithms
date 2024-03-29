package Q19346_파일저장소;

import java.util.*;

class UserSolution {
	private PriorityQueue<int[]> pq; // 삭제된 파일 공간들
	private Map<Integer, List<int[]>> m1; // 현재 파일이 차지하고 있는 공간
	private Map<Integer, Integer> m2; // 각 인덱스 당 가지고 있는 mId;
	private int size;

	public void init(int N) {
		size = N;
		pq = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
		m1 = new HashMap<>();
		m2 = new TreeMap<>((n1, n2) -> n2 - n1);
	}

	public int add(int mId, int mSize) {
		List<int[]> batch = new ArrayList<>();
		int curr_size = mSize;
		m1.put(mId, new ArrayList<>());
		Iterator<Integer> iter = m2.keySet().iterator();
		int MAX = (!iter.hasNext() ? 0 : m2.get(iter.next())) + 1;
		while (!pq.isEmpty() && curr_size != 0) {
			int[] curr = pq.poll();
			if (curr[0] >= MAX) {
				pq.clear();
				break;
			}
			int diff = curr[1] - curr[0] + 1;
			if (curr_size >= diff) {
				batch.add(curr);
				curr_size -= diff;
			} else {
				int st = curr[0];
				int ed = st + curr_size - 1;
				batch.add(new int[]{st, ed});
				pq.add(new int[]{ed + 1, curr[1]});
				curr_size = 0;
			}
		}


		if (curr_size > 0) {
			int st = MAX;
			int ed = st + curr_size - 1;
			if (ed > size) {
				pq.addAll(batch);
				return -1;
			}

			batch.add(new int[]{st, ed});
		}

		m1.get(mId).addAll(batch);
		for (int[] pos : batch) {
			m2.put(pos[0], pos[1]);
		}
		int ret = m1.get(mId).get(0)[0];
		return ret;
	}


	public int remove(int mId) {
		List<int[]> list = m1.get(mId);
		int size = list.size();
		pq.addAll(list);

		int prev = -1;
		for (int i = 0; i < list.size(); i++) {
			int st = list.get(i)[0];
			int ed = list.get(i)[1];
			if (prev + 1 == st) size--;
			m2.remove(st);

			prev = ed;
		}
		m1.remove(mId);

		return size;
	}


	public int count(int mStart, int mEnd) {

		int ret = 0;
		for (Integer key : m1.keySet()) {
			List<int[]> list = m1.get(key);
			boolean check = upperBound(list, mStart, mEnd);
			if (check) ret++;
		}

		return ret;
	}


	private boolean upperBound(List<int[]> list, int mStart, int mEnd) {
		int l = 0;
		int r = list.size();

		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid)[0] > mStart) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		if (r != list.size() && list.get(r)[0] <= mEnd) return true;
		else if(r != 0 && list.get(r-1)[1] >= mStart) return true;

		return false;
	}
}