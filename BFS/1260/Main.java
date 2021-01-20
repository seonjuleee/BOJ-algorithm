import java.io.*;
import java.util.*;

// 1260 DFS와 BFS
public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }
        sb = new StringBuilder();
        visit = new boolean[N+1];
        // dfs 수행
        dfs(V);
        sb.append('\n');
        visit = new boolean[N+1];
        // bfs 수행
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int v) {
        visit[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;
        while(!q.isEmpty()) {
            int p = q.poll();
            sb.append(p);
            sb.append(' ');
            for(Integer e : graph[p]) {
                if(!visit[e]) {
                    visit[e] = true;
                    q.add(e);
                }
            }
        }
    }

    private static void dfs(int v) {
        visit[v] = true;
        sb.append(v);
        sb.append(' ');
        for (Integer e : graph[v]) {
            if(!visit[e]) dfs(e);
        }
    }
}
