import java.io.*;
import java.util.StringTokenizer;

// 10972 다음 순열
public class Main {
    static int N;
    static int[] perm;
    static boolean next() {
        int i, j;
        for(i=N-1; i>0; i--) {
            if(perm[i] > perm[i-1]) break;
        }
        if(i <= 0) return false;
        for(j=N-1; j>i; j--) {
            if(perm[i-1] < perm[j]) break;
        }
        // swap perm[i-1] and perm[j]
        int tmp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = tmp;
        for(j=N-1; i<j; i++, j--) {
            // swap perm[i] and perm[j]
            tmp = perm[i];
            perm[i] = perm[j];
            perm[j] = tmp;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        perm = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            perm[i] = Integer.parseInt(st.nextToken());
        }
        if(next()) {
            for(int i=0; i<N; i++) {
                bw.write(String.valueOf(perm[i]));
                bw.write(' ');
            }
        } else bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
