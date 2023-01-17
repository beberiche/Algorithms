#include <bits/stdc++.h>
using namespace std;
int arr[28];
string str;
int main() {
    cin >> str;
    for (int i = 0; i < str.size(); i++)
        arr[str[i] - 'A']++;

    bool isSorry = false;
    bool isEven = str.size() % 2 == 0;
    bool isOne = false;
    for (int i = 0; i < 28; i++) {
        if (isEven && arr[i] % 2 != 0) {
            isSorry = true;
            break;
        } else {
            if (!isOne && arr[i] % 2 != 0) {
                isOne = true;
            } else if (isOne && arr[i] % 2 != 0) {
                isSorry = true;
                break;
            }
        }
    }
    if (isSorry) {
        cout << "I'm Sorry Hansoo";
        return 0;
    }

    char ans[str.size()];

    int l = 0, r = str.size() - 1, mid = floor(str.size() / 2);
    for (int i = 0; i < 28; i++) {
        if (str.size() > 0 && arr[i] % 2 != 0) {
            ans[mid] = i + 'A';
            arr[i]--;
        }
        bool check = true;
        while (arr[i]--) {
            if (check) {
                ans[l++] = i + 'A';
            } else {
                ans[r--] = i + 'A';
            }
            check = !check;
        }
    }
    for (int i = 0; i < str.size(); i++) {
        cout << ans[i];
    }

    return 0;
}
