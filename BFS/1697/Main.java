import java.io.*;
import java.util.*;

// 1697 숨바꼭질
public class Main {
    static int N, K;
    static int[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        loc = new int[100001];
        bfs(N);
        bw.write(String.valueOf(loc[K] - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        loc[n] = 1;
        q.add(n);
        while(!q.isEmpty()) {
            int x = q.poll();
            int next = x + 1;
            if(next >= 0 && next <= 100000) {
                if (loc[next] == 0) {
                    loc[next] = loc[x] + 1;
                    q.add(next);
                }
            }
            next = x - 1;
            if(next >= 0 && next <= 100000) {
                if (loc[next] == 0) {
                    loc[next] = loc[x] + 1;
                    q.add(next);
                }
            }
            next = x * 2;
            if(next >= 0 && next <= 100000) {
                if (loc[next] == 0) {
                    loc[next] = loc[x] + 1;
                    q.add(next);
                }
            }
        }
    }
}
