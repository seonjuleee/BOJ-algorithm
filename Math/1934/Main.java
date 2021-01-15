import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int lcm = A * B;
            while(B != 0) {
                int r = A % B;
                A = B;
                B = r;
            }
            lcm /= A;
            bw.write(String.valueOf(lcm));
            bw.write('\n');
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
