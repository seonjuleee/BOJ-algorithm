import java.io.*;
import java.util.*;

// 11724 연결 요소의 개수
public class Main {
    static int N, M;
    static List<Integer>[] lists;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new List[N + 1];
        check = new boolean[N + 1];
        for(int i=1; i<=N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        int count = 0; // 연결 요소의 개수
        for(int i=1; i<=N; i++) {
            if(!check[i]) {
                count++;
                bfs(i);
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    // bfs
    private static void bfs(int i) {
        q.add(i);
        while(!q.isEmpty()) {
            int p = q.poll();
            for(Integer e : lists[p]) {
                if(!check[e]) {
                    check[e] = true;
                    q.add(e);
                }
            }
        }
    }
}
