package Q13072_병사관리_unsolved;

//class Solider {
//    int id;
//    int score;
//
//    Solider(int id, int score) {
//        this.id = id;
//        this.score = score;
//    }
//}
//
//class Team {
//    // 맥스힙 만들기
//    Solider team[] = new Solider[50004];
//    int pos;
//
//    void add(int id, int score) {
//        Solider s = new Solider(id, score);
//        team[++pos] = s;
//
//        int idx = pos;
//        while (idx > 1) {
//            if (team[idx].score == team[idx / 2].score && team[idx].id > team[idx / 2].id) {
//                swap(idx, idx / 2);
//            } else if (team[idx].score > team[idx / 2].score) {
//                swap(idx, idx / 2);
//            }
//            idx /= 2;
//        }
//    }
//
//    int find(int id) {
//        for (int i = 1; i <= pos; i++) {
//            if (team[i].id == id) return i;
//        }
//        ;
//        return -1;
//    }
//
//    void poll(int idx) {
//        swap(idx, 1);
//        team[1].score = 0;
//        team[1].id = 0;
//        heapify();
//        pos--;
//    }
//
//    void swap(int s1, int s2) {
//        Solider tmp = team[s1];
//        team[s1] = team[s2];
//        team[s2] = tmp;
//    }
//
//    void updateOne(int idx, int score) {
//        team[idx].score = score;
//        heapify();
//    }
//
//    void updateAll(int score) {
//        for (int i = 1; i <= pos; i++) {
//            if (team[i].score + score > 5) team[i].score = 5;
//            else if (team[i].score + score < 1) team[i].score = 1;
//            else team[i].score += score;
//        }
//        heapify();
//    }
//
//    void heapify() {
//        int idx = 1;
//        while (idx * 2 <= pos) {
//            Solider curr = team[idx];
//            Solider left = team[idx*2];
//            Solider right = team[idx*2+1];
//
//            if(left != null && right == null) {
//                if(team[idx].score == team[idx*2].score && team[idx].id < team[idx*2].id) {
//                    swap(idx, idx*2);
//                    idx*=2;
//                } else if(curr.score < left.score) {
//                    swap(idx, idx*2);
//                    idx*=2;
//                }
//            } else if(right != null) {
//                if(left.score == right.score && left.id > right.id) {
//                    if(curr.score == left.score && curr.id > left.id) {
//                        swap(idx, idx * 2);
//                        idx *= 2;
//                    } else if(curr.score < left.score) {
//                        swap(idx, idx * 2);
//                        idx *= 2;
//                    }
//                } else if(left.score == right.score && left.id < right.id) {
//                    if(curr.score == right.score && curr.id > right.id) {
//                        swap(idx, idx * 2 + 1);
//                        idx *= 2 + 1;
//                    } else if(curr.score < right.score) {
//                        swap(idx, idx * 2 + 1);
//                        idx *= 2 + 1;
//                    }
//                }
//                else if(left.score > right.score) {
//                    if(curr.score == left.score && curr.id > left.id) {
//                        swap(idx, idx * 2);
//                        idx *= 2;
//                    } else if(curr.score < left.score) {
//                        swap(idx, idx * 2);
//                        idx *= 2;
//                    }
//                } else if(right.score > left.score) {
//                    if(curr.score == right.score && curr.id > right.id) {
//                        swap(idx, idx * 2 + 1);
//                        idx *= 2 + 1;
//                    } else if(curr.score < right.score) {
//                        swap(idx, idx * 2 + 1);
//                        idx *= 2 + 1;
//                    }
//                }
//            }
//        }
//    }
//
//    int top() {
//        return team[1].id;
//    }
//}
//
//class UserSolution {
//    Team team[];
//
//    public void init() {
//        team = new Team[6];
//        for (int i = 1; i <= 5; i++) team[i] = new Team();
//    }
//
//    public void hire(int mID, int mTeam, int mScore) {
//        team[mTeam].add(mID, mScore);
//    }
//
//    public void fire(int mID) {
//        for (int i = 1; i <= 5; i++) {
//            int idx = team[i].find(mID);
//            if (idx > 0) {
//                team[i].poll(idx);
//                break;
//            }
//        }
//    }
//
//    public void updateSoldier(int mID, int mScore) {
//        for (int i = 1; i <= 5; i++) {
//            int idx = team[i].find(mID);
//            if (idx > 0) {
//                team[i].updateOne(idx, mScore);
//                break;
//            }
//        }
//    }
//
//    public void updateTeam(int mTeam, int mChangeScore) {
//        team[mTeam].updateAll(mChangeScore);
//    }
//
//    public int bestSoldier(int mTeam) {
//        return team[mTeam].top();
//    }
//}

