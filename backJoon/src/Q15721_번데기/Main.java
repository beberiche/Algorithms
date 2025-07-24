package Q15721_번데기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int val = Integer.parseInt(br.readLine());

        int bb = 0; // 번
        int dg = 0; // 데기

        int[] init = new int[]{0, 1, 0, 1};
        List<Integer> bbList = new ArrayList<>();
        bbList.add(init[0]);
        bbList.add(init[2]);
        List<Integer> dgList = new ArrayList<>();
        dgList.add(init[1]);
        dgList.add(init[3]);

        int vect = 0;
        int initIdx = 0;
        int bbIdx = 0;
        int dgIdx = 0;
        int[] a = new int[A];
        for (int i = 0; i < 10000; i++) {
            int aIdx = i % A;
            if (vect == 0) {
                a[aIdx] = init[initIdx];
                initIdx = initIdx == init.length - 1 ? 0 : initIdx + 1;
                if (initIdx == 0) {
                    vect = 1;
                }
            } else if (vect == 1) {
                a[aIdx] = bbList.get(bbIdx);
                bbIdx = bbIdx == bbList.size() - 1 ? 0 : bbIdx + 1;
                if (bbIdx == 0) {
                    bbList.add(init[0]);
                    vect = 2;
                }
            } else if (vect == 2) {
                a[aIdx] = dgList.get(dgIdx);
                dgIdx = dgIdx == dgList.size() - 1 ? 0 : dgIdx + 1;
                if (dgIdx == 0) {
                    dgList.add(init[1]);
                    vect = 0;
                }
            }

            if (a[aIdx] == 0) {
                bb++;
            } else {
                dg++;
            }

            if ((val == 0 && bb == T) || (val == 1 && dg == T)) {
                System.out.println(aIdx);
                return;
            }
        }
    }
}
