package Q9437_사라진_페이지_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalPage = Integer.parseInt(st.nextToken());

            if (totalPage == 0) {
                break;
            }

            int choicePage = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> pages = new ArrayList<>();

            int front = 1;
            int back = totalPage;

            for (int i = 0; i < (totalPage / 4); i++) {
                ArrayList<Integer> pageSet = new ArrayList<>();
                pageSet.add(front++);
                pageSet.add(back--);
                pageSet.add(front++);
                pageSet.add(back--);
                pages.add(pageSet);
            }

            for (ArrayList<Integer> page : pages) {
                if (page.contains(choicePage)) {
                    Collections.sort(page);
                    page.remove(Integer.valueOf(choicePage));
                    for (Integer i : page) {
                        sb.append(i).append(" ");
                    }
                    sb.append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}

