package Q6679_싱기한_네자리_숫자;

public class Main {
    public static void main(String[] args) {
        int start = 1000;

        StringBuilder sb = new StringBuilder();
        while (start <= 9999) {
            int base10Sum = sumOfDigits(start, 10);
            int base12Sum = sumOfDigits(start, 12);
            int base16Sum = sumOfDigits(start, 16);

            if (base10Sum == base12Sum && base12Sum == base16Sum) {
                sb.append(start).append("\n");
            }
            start++;
        }

        System.out.print(sb);
    }

    public static int sumOfDigits(int number, int base) {
        int sum = 0;
        while (number > 0) {
            sum += number % base; // 각 자리의 값을 더함
            number /= base; // 다음 자리로 이동
        }
        return sum;
    }
}
