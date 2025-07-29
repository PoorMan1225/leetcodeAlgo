package recursion_1;

import binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_2 {
    public static void main(String[] args) {
        generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    /**
     * 루트를 처음반복 즉 1 ~ n 까지 모두 루트가 되는데 예를들어 n 이 3이라면
     * 1부터 루트가 되어서 왼쪽 에서 만들 수 있는 모든 경우와 오른쪽에서 만들 수 있는 모든 경우를 합쳐서 붙이게 된다.
     * 베이스 케이스는 시작 이 끝보다 작은 경우  null 이 되어야 한다.
     *
     * 1이 루트인 경우 먼저 보게 되면 1에서(1,0) 은 왼쪽 트리는 없기 때문에 제외하고
     * (2, 3) -> [(2, 2), (3, 3)] -> (2, 2) -> [(2, 1), (3, 2)] 이런식으로 왼쪽 트리와 오른쪽 트리를 만들어서
     * 붙이게 되고 그게 최종 결과에 쓰이게 된다.
     */
    private static List<TreeNode> build(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            // i를 루트로 선택
            List<TreeNode> leftTrees = build(start, i - 1);
            List<TreeNode> rightTrees = build(i + 1, end);

            // 모든 조합 붙이기
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
