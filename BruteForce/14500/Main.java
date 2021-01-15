import java.io.*;
import java.util.StringTokenizer;

// 14500 테트로미노
public class Main {
    static int[][][] block = {
            // y, x
            // -자 블록 -> 2가지
            {{0,1}, {0,2}, {0,3}},
            {{1,0}, {2,0}, {3,0}},
            // ㄴ자 블록 -> 8가지
            {{1,0}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {2,0}},
            {{0,1}, {0,2}, {1,2}},
            {{1,0}, {2,0}, {2,-1}},
            {{0,1}, {0,2}, {-1,2}},
            {{1,0}, {2,0}, {2,1}},
            {{0,1}, {0,2}, {1,0}},
            {{0,1}, {1,1}, {2,1}},
            // ㅁ자 블록 -> 1가지
            {{0,1}, {1,0}, {1,1}},
            // ㄱㄴ자 블록 -> 4가지
            {{0,1}, {-1,1}, {-1,2}},
            {{1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,2}},
            {{1,0}, {1,-1}, {2,-1}},
            // ㅏ자 블록 -> 4가지
            {{0,1}, {0,2}, {-1,1}},
            {{0,1}, {0,2}, {1,1}},
            {{1,0}, {2,0}, {1,1}},
            {{1,0}, {2,0}, {1,-1}},
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<19; k++) {
                    boolean flag = true;
                    int sum = paper[i][j];
                    for(int l=0; l<3; l++) {
                        int y = i + block[k][l][0];
                        int x = j + block[k][l][1];
                        if(x >= 0 && x < M && y >= 0 && y < N) {
                            sum += paper[y][x];
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag && ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
