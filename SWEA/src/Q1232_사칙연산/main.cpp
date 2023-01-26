#include <bits/stdc++.h>
using namespace std;
struct Node {
    int num;
    string op;
    struct Node *left;
    struct Node *right;
};
int N, T;
int idx, l, r;
string op;
Node nodeArr[1004];

int postOrder(Node node) {
    if (!node.left || !node.right)
        return node.num;

    int left = postOrder(*node.left);
    int right = postOrder(*node.right);
    if (node.op == "-")
        return left - right;
    else if (node.op == "+")
        return left + right;
    else if (node.op == "*")
        return left * right;
    else
        return left / right;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    T = 10;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        memset(nodeArr, 0, sizeof(nodeArr));
        for (int i = 0; i < N; i++) {
            cin >> idx >> op;
            if (cin.get() != '\n') {
                cin >> l >> r;
                nodeArr[idx].op = op;
                nodeArr[idx].left = &nodeArr[l];
                nodeArr[idx].right = &nodeArr[r];
            } else {
                nodeArr[idx].num = stoi(op);
            }
        }
        cout << "#" << t << " " << postOrder(nodeArr[1]) << "\n";
    }

    return 0;
}