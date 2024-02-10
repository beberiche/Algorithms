package Q9416_Social_Media;

import java.util.*;

class Node {
	int pID;
	int like;
	int timestamp;

	Node(int pID, int timestamp) {
		this.pID = pID;
		this.like = 0;
		this.timestamp = timestamp;
	}
}

class UserSolution {
	// 게시물 -> Map {pID, Node}
	Map<Integer, Node> posts;
	// 임의의 사용자가 쓴 게시물 -> Map {uID, List<Node>}
	Map<Integer, List<Node>> postsByUser;
	// 팔로워 -> List<Integer>[];
	List<Integer> followers[];


	public void init(int N) {
		posts = new HashMap<>();
		postsByUser = new HashMap<>();
		followers = new ArrayList[N + 1];
	}

	public void follow(int uID1, int uID2, int timestamp) {
		if (followers[uID1] == null) followers[uID1] = new ArrayList<>();
		followers[uID1].add(uID2);
	}

	public void makePost(int uID, int pID, int timestamp) {
		posts.put(pID, new Node(pID, timestamp));
		if (!postsByUser.containsKey(uID)) postsByUser.put(uID, new ArrayList<>());
		postsByUser.get(uID).add(posts.get(pID));
	}

	public void like(int pID, int timestamp) {
		posts.get(pID).like++;
	}

	public void getFeed(int uID, int timestamp, int pIDList[]) {
		// 1000초 이하
		PriorityQueue<Node> pq1 = new PriorityQueue<>((n1, n2) -> {
			if (n1.like == n2.like) return n2.timestamp - n1.timestamp;
			return n2.like - n1.like;
		});
		// 1000초 초과
		PriorityQueue<Node> pq2 = new PriorityQueue<>((n1, n2) -> n2.timestamp - n1.timestamp);

		List<List<Node>> feeds = new ArrayList<>();
		List<Integer> postCnt = new ArrayList<>();

		List<Node> post = postsByUser.get(uID);
		if (post != null) {
			feeds.add(post);
			postCnt.add(post.size());
		}
		int len = followers[uID] == null ? 0 : followers[uID].size();
		for (int i = 0; i < len; i++) {
			post = postsByUser.get(followers[uID].get(i));
			if (post == null) continue;

			feeds.add(post);
			postCnt.add(post.size());
		}


		int curr = -1;
		while (pq1.size() <= 100) {
			curr++;
			// 더이상 반영할 게시물이 없는 경우
			int test = 0;
			for (int i = 0; i < feeds.size(); i++) {
				int idx = postCnt.get(i) - 1 - curr;
				// 현재 사용자의 게시물을 모두 짚어넣음.
				if (idx < 0) {
					test++;
					continue;
				}
				int time = timestamp - feeds.get(i).get(idx).timestamp;
				if (time > 1000) {
					pq2.add(feeds.get(i).get(idx));
				} else {
					pq1.add(feeds.get(i).get(idx));
				}
			}

			if (test == feeds.size()) break;
		}

		for (int i = 0; i < pIDList.length; i++) {
			if (!pq1.isEmpty()) {
				Node p = pq1.poll();
				pIDList[i] = p.pID;
			} else if (!pq2.isEmpty()) {
				Node p = pq2.poll();
				pIDList[i] = p.pID;
			} else {
				break;
			}
		}
	}
}
