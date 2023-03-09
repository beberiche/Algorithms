//
// Created by 김종현 on 2023/03/04.
//
#include <iostream>
#include <vector>
#include <string>

using namespace std;
int N, A = 0, B = 0, A_win = 0, B_win = 0;;

vector<string> split(string str, string deli) {
    vector<string> ret;
    int pos = 0;
    while ((pos = str.find(deli)) != string::npos) {
        ret.push_back(str.substr(0, pos));
        str.erase(0, pos + deli.length());
    }
    ret.push_back(str);
    return ret;
}

void solve() {
    cin >> N;
    int team;
    string time;

    int prev_time = 0;
    for (int i = 0; i < N; i++) {
        cin >> team >> time;
        vector<string> temp = split(time, ":");
        int curr_time = stoi(temp[0]) * 60 + stoi(temp[1]);
        if (A > B) {
            A_win += curr_time - prev_time;
        } else if (A < B) {
            B_win += curr_time - prev_time;
        }
        team == 1 ? A++ : B++;
        prev_time = curr_time;
    }
    if (A > B) {
        A_win += 48 * 60 - prev_time;
    } else if (B > A) {
        B_win += 48 * 60 - prev_time;
    }

    string result_A_min =
            to_string(A_win / 60) == "0" ? "00" : A_win / 60 < 10 ? ("0" + to_string(A_win / 60)) : to_string(
                    A_win / 60);
    string result_B_min =
            to_string(B_win / 60) == "0" ? "00" : B_win / 60 < 10 ? ("0" + to_string(B_win / 60)) : to_string(
                    B_win / 60);
    string result_A_sec =
            to_string(A_win % 60) == "0" ? "00" : A_win % 60 < 10 ? ("0" + to_string(A_win % 60)) : to_string(
                    A_win % 60);
    string result_B_sec =
            to_string(B_win % 60) == "0" ? "00" : B_win % 60 < 10 ? ("0" + to_string(B_win % 60)) : to_string(
                    B_win % 60);
    string result_A = result_A_min + ":" + result_A_sec;
    string result_B = result_B_min + ":" + result_B_sec;
    cout << result_A << "\n" << result_B;
//    printf("%02d:%02d\n", A_win / 60, A_win % 60);
//    printf("%02d:%02d", B_win / 60, B_win % 60);
}


int main() {
    solve();
}