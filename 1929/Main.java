import java.io.*;
import java.util.StringTokenizer;

// 1929 소수 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] checkPrime = new boolean[N + 1]; // false면 prime
        checkPrime[0] = true;
        checkPrime[1] = true;
        // 에라토스테네스의 체 이용
        for(int i = 2; i <= N; i++) {
            for(int j = i*2; j <= N; j += i) {
                checkPrime[j] = true;
            }
        }
        for(int i = M; i <= N; i++) {
            if(!checkPrime[i]) {
                bw.write(String.valueOf(i));
                bw.write('\n');
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
