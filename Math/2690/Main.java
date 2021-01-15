import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        bw.write(String.valueOf(A));
        bw.write('\n');
        bw.write(String.valueOf(lcm));
        bw.flush();
        bw.close();
        br.close();
    }
}
