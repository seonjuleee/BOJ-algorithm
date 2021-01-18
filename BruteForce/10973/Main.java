import java.io.*;
import java.util.*;

// 10973 이전 순열
public class Main {
    static int N;
    static int[] arr;
    static boolean pre_permutation() {
        int i, j;
        for(i=N-1; i>0; i--) {
            if(arr[i] <= arr[i-1]) break;
        }
        if(i <= 0) {
            return false;
        }
        for(j=N-1; j>i; j--) {
            if(arr[j] <= arr[i-1]) break;
        }
        int tmp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = tmp;
        for(j=N-1; i<j; i++, j--) {
            tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = pre_permutation();
        if(!flag) bw.write(String.valueOf(-1));
        else {
            for(int i=0; i<N; i++) {
                bw.write(String.valueOf(arr[i]));
                bw.write( ' ');
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
