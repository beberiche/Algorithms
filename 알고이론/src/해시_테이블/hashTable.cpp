#include <cstring>
#include <iostream>

// 해시함수
size_t djb2(const char *str) {
    // int (2바이트) : 양수와 음수로 표현할 수 있다. 최소 -2,147,483,648에서
    // 최대 2,147,483,647까지 표현 unsigned int (2바이트) : 양수로만 표현한다.
    // 최소 0부터 최대 4,294,967,295까지 표현 (운영체제 마다 가변적)
    // size_t : size_t는 a.k.a. 'long unsigned int'(별칭)로서 '이론상
    // 가장 큰 사이즈를 담을 수 있는 unsigned 데이터 타입'으로 정의된다.(고정적)
    size_t hash = 5381;

    for (; *str; ++str) {
        hash = ((hash << 5) + hash) + *str;
    }
    return hash;
}

// C++ 11 부터 constexpr을 사용할 수 있다.
// const 는 값이 컴파일 시점에서 정해질 수도 런타임 시점에서 정해질 수도 있다.
// 따라서 컴파일 시점에 값이 없어도 에러가 나지 않는다. constexpr 은 컴파일
// 시점에서 값이 있음을 보장한다. 따라서 값이 없다면 컴파일 시점에 무조건 에러가
// 난다.
constexpr size_t MAX_N = 10000;
constexpr size_t MAX_LEN = 10;

// class와 struct의 차이
// 1. class 는 reference-type, struct 는 value-type
// 2. class 는 상속 가능, struct 는 상속 불가능
// 3. class 는 인스턴스 메서드 내에서 변수 수정 가능
// 4. struct 는 AnyObject 로 타입 캐스팅 안됨
// 5. struct 는 생성자를 자유롭게 호출하는 것이 가능
// 메모리 절약하자면 class, 속도는 구조체가 좋다.
// 변수의 크기가 작거나, 수명이 짧고, 자주 할당되는 객체는 구조체를 사용하자.
struct Node {
    char str[MAX_LEN + 1];
    int data;
    Node *next;
};

int node_count = 0;
Node nodes[MAX_N];

Node *new_node(const char str[MAX_LEN + 1], int data) {
    std::strcpy(nodes[node_count].str, str);
    nodes[node_count].data = data;

    // NULL : NULL 은 포인터가 아니라 매크로에서 정의된 상수 0 이다.
    // nullptr : nullptr은 포인터이다.
    nodes[node_count].next = nullptr;

    return &nodes[node_count++];
}

class HashMap {
    static constexpr size_t TABLE_SIZE = 1 << 12;
    static constexpr size_t DIV = TABLE_SIZE - 1;
    Node hash_table[TABLE_SIZE];

  public:
    HashMap() = default;

    void init() {
        std::memset(hash_table, 0, sizeof(hash_table));
        node_count = 0;
    }

    void insert(const char str[MAX_LEN + 1], int data) {
        Node *const prev_node = get_prev_node(str);
        if (prev_node->next == nullptr)
            prev_node->next = new_node(str, data);
        else
            prev_node->next->data = data;
    }

    void remove(const char str[MAX_LEN + 1]) {
        Node *const prev_node = get_prev_node(str);
        if (prev_node->next != nullptr) {
            prev_node->next = prev_node->next->next;
        }
    }

    Node *get(const char str[MAX_LEN + 1]) { return get_prev_node(str)->next; }

  private:
    Node *get_prev_node(const char str[MAX_LEN + 1]) {
        Node *prev_ptr = &hash_table[djb2(str) & DIV];
        while (prev_ptr->next != nullptr &&
               std::strcmp(prev_ptr->next->str, str) != 0) {
            prev_ptr = prev_ptr->next;
        }
        return prev_ptr;
    }
};

// test
int main() {
    HashMap hash_map{};
    // 0   : 초기화
    // 1 str x : (str, x) 삽입 (이미 str이 있는 경우 data를 x로 교체)
    // 2 str   : str 삭제 (str이 없는 경우 무시)
    // 3 str   : str 검색
    int cmd, x;
    char str[MAX_LEN + 1];
    Node *ptr;
    for (;;) {
        std::cin >> cmd;
        switch (cmd) {
        case 0:
            hash_map.init();
            break;
        case 1:
            std::cin >> str >> x;
            if (std::strlen(str) > MAX_LEN)
                return std::cout << "invalid key length", 0;
            hash_map.insert(str, x);
            break;
        case 2:
            std::cin >> str;
            if (std::strlen(str) > MAX_LEN)
                return std::cout << "invalid key length", 0;
            hash_map.remove(str);
            break;
        case 3:
            std::cin >> str;
            if (std::strlen(str) > MAX_LEN)
                return std::cout << "invalid key length", 0;
            ptr = hash_map.get(str);
            if (ptr == nullptr) {
                std::cout << "not found\n";
            } else {
                std::cout << str << ": " << ptr->data << '\n';
            }
            break;
        default:
            return std::cout << "invalid command\n", 0;
        }
    }
}
