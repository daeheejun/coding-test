import java.io.*;

public class Main {
    /*
     *    이진 트리
     *    전위 탐색 정보를 이용 -> 후위 탐색 정보를 출력
     *    전위 순회: 뿌리 -> 왼쪽 -> 오른쪽
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node node = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String read = br.readLine();
            if(read == null ||read.equals("")) break;

            int input = Integer.parseInt(read);
            node.insert(input);
        }
        post(node, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    /*
     *   후위 순회:
     *   왼쪽 -> 오른쪽 -> 뿌리
     */
    private static void post(Node node, BufferedWriter bw) throws IOException {
        if(node.left != null) post(node.left, bw);
        if(node.right != null) post(node.right, bw);
        bw.write(node.number + System.lineSeparator());
    }

    private static class Node {
        int number;
        Node left, right;

        public Node(int number) {
            this.number = number;
        }

        void insert(int input) {
            if(this.number > input)
            {
                if(isNull(this.left)) {
                    this.left = new Node(input);
                } else {
                    this.left.insert(input);
                }
            }
            else
            {
                if(isNull(this.right)) {
                    this.right = new Node(input);
                } else {
                    this.right.insert(input);
                }
            }
        }

        boolean isNull(Node node) {
            return node == null;
        }
    }
}
