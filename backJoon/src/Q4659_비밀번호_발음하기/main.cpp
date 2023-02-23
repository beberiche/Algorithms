//
// Created by 김종현 on 2023/02/23.
//
#include <iostream>

using namespace std;
string str;

// 해당 알파벳이 자음인지 모음인지 확인
bool check(int i) {
    return str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u';
}

// 모음이 있는지 확인
bool check1() {
    for (int i = 0; i < str.length(); i++) {
        if (check(i)) return true;
    }
    return false;
}

// 모음 3개 혹은 자음 3개가 연속으로 나오는지 확인
bool check2() {
    int v = 0, s = 0, vc = 0, sc = 0;
    for (int i = 0; i < str.length(); i++) {
        if (check(i)) {
            v = max(v, ++vc);
            sc = 0;
        } else {
            s = max(s, ++sc);
            vc = 0;
        }
    }
    if (v >= 3 || s >= 3) return false;
    return true;
}

// 같은 글자 2개 확인, 단 ee, oo 는 허용
bool check3() {
    char prev = str[0];
    for (int i = 1; i < str.length(); i++) {
        if (prev == str[i] && prev != 'e' && prev != 'o') {
            return false;
        }
        prev = str[i];
    }
    return true;
}

int main() {
    while (true) {
        cin >> str;
        if (str == "end") break;
        else if (check1() && check2() && check3()) {
            cout << "<" << str << ">" << " is acceptable." << "\n";
        } else {
            cout << "<" << str << ">" << " is not acceptable." << "\n";
        }
    }
}