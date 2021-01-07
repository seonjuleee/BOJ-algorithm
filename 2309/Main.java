import java.io.*;
import java.util.Arrays;

// 2309 일곱 난쟁이
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dwarves;
    static void selectDwarves(int sum) throws IOException {
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                // 일곱 난쟁이의 키의 합이 100이 되는 경우
                if(dwarves[i] + dwarves[j] == sum - 100) {
                    for(int k=0; k<9; k++) {
                        if(k == i || k == j) continue;
                        bw.write(String.valueOf(dwarves[k]));
                        bw.write('\n');
                    }
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0; // 모든 난쟁이들의 키의 합
        dwarves = new int[9]; // 난쟁이들이 키의 배열
        for(int i=0; i<9; i++) {
            dwarves[i] = Integer.parseInt(br.readLine());
            sum += dwarves[i];
        }
        Arrays.sort(dwarves); // 나중에 오름차순으로 출력하기 위해 정렬
        selectDwarves(sum);
        bw.flush();
        bw.close();
        br.close();
    }
}
