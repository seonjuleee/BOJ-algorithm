import java.io.*;
import java.util.StringTokenizer;

// 1476 날짜 계산
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 범위가 1부터 15*28*19까지이다.
        int last = 15 * 28 * 19;
        /*
        modulo 계산은 15로 나누어 떨어질 때 0으로 계산하지만
        문제에서는 15로 나누어 떨어질 때 15를 요구하므로
        i를 1을 빼고 modulo 계산한 값에 1을 더해주면 됨
        범위를 i를 1부터 last까지가 아닌 이미 1을 빼준 0부터 last-1까지로 설정함
         */
        for(int i=0; i<=last-1; i++) {
            if(i % 15 + 1 == E && i % 28 + 1 == S && i % 19 + 1 == M) {
                bw.write(String.valueOf(i+1)); // 지금까지 i에서 1을 뺀 값이니 정답은 1을 더해야 함
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
