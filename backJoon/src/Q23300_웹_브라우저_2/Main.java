package Q23300_웹_브라우저_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// stack을 활용하 구현
// 압축은 stack에서 뽑아내서, 중복제거 후 새로운 stack으로 교환
public class Main {
    static int currPage, cnt;
    static Stack<Integer> back, forward;

    private static void goBack() {
        if (back.isEmpty()) return;
        forward.push(currPage);
        currPage = back.pop();
    }

    private static void goForward() {
        if (forward.isEmpty()) return;
        back.push(currPage);
        currPage = forward.pop();
    }

    private static void access(int page) {
        forward.clear();
        if (currPage > 0) back.push(currPage);
        currPage = page;
    }

    private static void compression() {

        if (back.size() < 2) return;

        Stack<Integer> ret = new Stack<>();

        ret.push(back.pop());
        while (!back.isEmpty()) {
            int next = back.pop();
            if (ret.peek() == next) {
                ret.pop();
            }
            ret.push(next);
        }

        while(!ret.isEmpty()) {
            back.push(ret.pop());
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        stk.nextToken();
        currPage = -1;
        cnt = Integer.parseInt(stk.nextToken());

        back = new Stack<>();
        forward = new Stack<>();

        char cmd;
        int page, stage = 0;
        while (stage < cnt) {
            stk = new StringTokenizer(br.readLine());
            cmd = stk.nextToken().charAt(0);

            if (cmd == 'B') {
                goBack();
            } else if (cmd == 'F') {
                goForward();
            } else if (cmd == 'A') {
                page = Integer.parseInt(stk.nextToken());
                access(page);
            } else if (cmd == 'C') {
                compression();
            }
            stage++;
        }

        StringBuilder sb_b = new StringBuilder();
        StringBuilder sb_f = new StringBuilder();

        if (back.isEmpty()) {
            sb_b.append(-1);
        } else {
            while (!back.isEmpty()) {
                sb_b.append(back.pop()).append(" ");
            }
        }

        if (forward.isEmpty()) {
            sb_f.append(-1);
        } else {
            while (!forward.isEmpty()) {
                sb_f.append(forward.pop()).append(" ");
            }
        }

        System.out.println(currPage);
        System.out.println(sb_b.toString());
        System.out.println(sb_f.toString());
    }
}
