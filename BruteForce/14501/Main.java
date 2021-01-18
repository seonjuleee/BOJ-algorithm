import java.io.*;
import java.util.StringTokenizer;

// 14501 퇴사
public class Main {
    static int N, max = 0;
    static int[] T, P;
    static void consult(int index, int sum) {
        if(index == N + 1) {
            max = Math.max(max, sum);
            return;
        } else if(index > N + 1) return;
        consult(index + T[index], sum + P[index]); // 선택
        consult(index + 1, sum); // 선택 X
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        consult(1, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
