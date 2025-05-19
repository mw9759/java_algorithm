package java_algorithm.BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_9019_DSLR_GPT {
	
	static int[] from;

    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            from = new int[10000];
            bfs(A, B);
            printPath(A, B);
        }
    }

    static void bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == target) return;

            for (int next : new int[] {
                    (now * 2) % 10000,                             // D
                    (now == 0) ? 9999 : now - 1,                   // S
                    (now % 1000) * 10 + now / 1000,                // L
                    (now % 10) * 1000 + now / 10                   // R
            }) {
                if (!visited[next]) {
                    visited[next] = true;
                    from[next] = now;
                    queue.offer(next);
                }
            }
        }
    }

    static void printPath(int start, int end) {
        Stack<Integer> stack = new Stack<>();
        for (int cur = end; cur != start; cur = from[cur]) {
            stack.push(cur);
        }

        int now = start;
        while (!stack.isEmpty()) {
            int next = stack.pop();
            System.out.print(getOperation(now, next));
            now = next;
        }
        System.out.println();
    }

    static char getOperation(int now, int next) {
        if ((now * 2) % 10000 == next) return 'D';
        if ((now == 0 ? 9999 : now - 1) == next) return 'S';
        if (((now % 1000) * 10 + now / 1000) == next) return 'L';
        if (((now % 10) * 1000 + now / 10) == next) return 'R';
        return '?';
    }

}
