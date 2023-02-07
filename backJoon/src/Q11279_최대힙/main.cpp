#include <iostream>
using namespace std;
const int MAX = 1e6 + 5;

class MaxHeap {
    int pos = 0;
    int arr[MAX];

  public:
    void push(int num) {
        arr[++pos] = num;
        int idx = pos;
        while (idx / 2 >= 1) {
            int p = idx / 2;
            if (arr[p] < arr[idx])
                swap(p, idx);
            idx /= 2;
        }
    }
    int pop() {
        if (pos <= 0)
            return 0;
        int res = arr[1];
        arr[1] = arr[pos];
        arr[pos--] = 0;

        heapify();

        return res;
    }

  private:
    void heapify() {
        int idx = 1;
        while (idx * 2 <= pos) {
            int left = idx * 2;
            int right = idx * 2 + 1;

            int max = left;
            if (arr[right] > 0 && arr[left] < arr[right])
                max = right;

            if (arr[max] <= arr[idx])
                break;
            swap(idx, max);
            idx = max;
        }
    }
    void swap(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
};

void input() {
    int N, num;
    cin >> N;
    MaxHeap mh = MaxHeap();
    for (int i = 0; i < N; i++) {
        cin >> num;
        if (!num)
            cout << mh.pop() << "\n";
        else
            mh.push(num);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    return 0;
}