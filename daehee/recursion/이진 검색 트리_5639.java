import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 전위 순회(루트-> 왼쪽-> 오른쪽)이므로 첫번째 값은 무조건 루트노드
    Node rootNode = new Node(Integer.parseInt(br.readLine()));

    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      insertNode(rootNode, Integer.parseInt(line));
    }

    // 후위 순회로 트리 출력
    postOrderTraversal(rootNode, bw);

    bw.flush();
  }

  // 노드를 트리에 삽입하는 메서드
  private static void insertNode(Node currentNode, int data) {
    if (data < currentNode.data) {
      if (currentNode.left == null) {
        currentNode.left = new Node(data);
      } else {
        // 더 작은 값이 왼쪽에 오는 것이므로 왼쪽 노드로 이동
        insertNode(currentNode.left, data);
      }
    } else {
      if (currentNode.right == null) {
        currentNode.right = new Node(data);
      } else {
        // 더 큰 값이 오른쪽에 오는 것이므로 오른쪽 노드로 이동
        insertNode(currentNode.right, data);
      }
    }
  }

  // 후위 순회로 트리 출력하는 메서드
  private static void postOrderTraversal(Node node, BufferedWriter bw) throws IOException {
    if (node == null) {
      return;
    }
    postOrderTraversal(node.left, bw);
    postOrderTraversal(node.right, bw);
    bw.write(node.data + "\n");
  }
}