package Q2160_그림_비교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int getBitCount(long diff){
        int ret = 0;
        while(diff>0){
            if(diff%2==1) ret++;
            diff/=2;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(br.readLine());

        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            long number=0;
            for(int x=0;x<5;x++){
                String line = br.readLine();
                for(char c : line.toCharArray()){
                    number<<=1;
                    if(c=='.'){
                        number+=1;
                    }
                }
            }
            arr[i]=number;
        }

        int diffCount = Integer.MAX_VALUE;
        int answer1=0;
        int answer2=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long diff = arr[i]^arr[j];
                int bitCount = getBitCount(diff);
                if(bitCount < diffCount){
                    diffCount=bitCount;

                    answer1 = i+1;
                    answer2 = j+1;
                }
            }
        }

        sb.append(answer1+" "+answer2);
        System.out.println(sb);
    }
}