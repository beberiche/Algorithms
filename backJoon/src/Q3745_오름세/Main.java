package Q3745_오름세;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// LIS
public class Main {
    private static int lowerbound(List<Integer> list, int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String line = null;

            while ((line = br.readLine()) != null) {
                int N = Integer.parseInt(line.trim());
                StringTokenizer stk = new StringTokenizer(br.readLine());
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(stk.nextToken()));
                int ans = 1;
                for (int i = 1; i < N; i++) {
                    int num = Integer.parseInt(stk.nextToken());
                    if (list.get(list.size() - 1) < num) {
                        list.add(num);
                        ans = Math.max(ans, list.size());
                    } else {
                        int idx = lowerbound(list, num);
                        list.set(idx, num);
                    }
                }
                sb.append(ans).append("\n");
            }
        } catch (Exception e) {

        } finally {
            System.out.print(sb.toString());
        }
    }
}
