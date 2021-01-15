import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i=0; i<n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == 1) continue;
            boolean flag = true;
            for(int j=2; j*j<=p; j++) {
                if(p % j == 0) {
                    flag = false;
                    break;
                }
            }
            count += flag ? 1 : 0;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
