import java.io.*;

// 6588 골드바흐의 추측
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] prime = new boolean[1000001]; // false면 prime
        prime[0] = true;
        prime[1] = true;
        // 에라토스테네스의 체
        for(int i=3; i<=1000000; i+=2) {
            if(!prime[i]) {
                for(int j=i*2; j<=1000000; j+=i) {
                    prime[j] = true;
                }
            }
        }
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int a = 0;
            for(int i=3; i<n; i+=2) {
                if(!prime[i] && !prime[n-i]) {
                    a = i;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if(a == 0) bw.write("Goldbach's conjecture is wrong.\n");
            else {
                sb.append(n);
                sb.append(" = ");
                sb.append(a);
                sb.append(" + ");
                sb.append(n - a);
                sb.append('\n');
                bw.write(String.valueOf(sb));
            }
            bw.flush();
        }
    }
}
