#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
struct Node {
    string p;
    int money;
    vector<string> child;
};
unordered_map<string,Node> m;

void go(Node &node, int p) {
    if(node.p == "없음") {
        node.money += p/10;
        return;
    }

    if(p <= 0) return;

    node.money += (p - (p/10));
    go(m[node.p], p/10);
}

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    vector<int> answer;
    Node node;
    // center 추가
    node.p="없음";
    node.money=0;
    m["center"] = node;
    for(int i=0; i<enroll.size(); i++) {
        Node node;
        node.p = referral[i] == "-" ? "center" : referral[i];
        node.money = 0;
        m[enroll[i]] = node;
        // 자식 추가
        m[referral[i]].child.push_back(enroll[i]);
    }

    int price = 100;
    for(int i=0; i<seller.size(); i++) {
        go(m[seller[i]], amount[i]*price);
    }

    for(int i=0; i<enroll.size(); i++) {
        answer.push_back(m[enroll[i]].money);
    }
    return answer;
}