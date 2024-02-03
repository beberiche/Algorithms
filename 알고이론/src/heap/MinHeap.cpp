#include <cstring>
#include <iostream>
using namespace std;
const int MAX = 1e6 + 1;

class MinHeap {
  private:
    int pos;
    int arr[MAX];

  public:
    MinHeap() {
        pos = 0;
        memset(arr, -1, sizeof(arr));
    };
    void push(int num) {
        arr[++pos] = num;
        int idx = pos;
        while (idx / 2 >= 1) {
            if (arr[idx] < arr[idx / 2])
                swap(idx, idx / 2);
            else
                break;
            idx /= 2;
        }
    };

    int pop() {
        if (pos == 0)
            return 0;
        int res = arr[1];
        arr[1] = arr[pos];
        arr[pos--] = -1;
        heapify();
        return res;
    };

    void heapify() {
        int idx = 1;
        while (idx * 2 <= pos) {
            int left = idx * 2;
            int right = idx * 2 + 1;

            int min = left;
            if (right <= pos && arr[right] < arr[left]) {
                min = right;
            }
            if (arr[idx] <= arr[min])
                break;
            swap(idx, min);
            idx = min;
        }
    }

    void swap(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
};

void input() {
    int n, num;
    cin >> n;
    MinHeap heap = MinHeap();
    for (int i = 0; i < n; i++) {
        cin >> num;
        if (num == 0) {
            cout << heap.pop() << "\n";
        } else {
            heap.push(num);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    return 0;
}