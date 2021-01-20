import java.io.*;
import java.util.*;

// 2178 미로 탐색
public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        check = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int ans = bfs(0, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Pair {
        int x, y, count;
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        check[y][x] = true;
        q.add(new Pair(y, x, 1));
        int count = 1;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(!check[ny][nx] && maze[ny][nx] == 1) {
                    check[ny][nx] = true;
                    count = p.count + 1;
                    // 예제 4처럼 모든 경로를 다 돌지 않아도 도착점에 도착할 수 있으므로
                    if(ny == N - 1 && nx == M - 1) return count;
                    q.add(new Pair(nx, ny, count));
                }
            }
        }
        return count;
    }
}
