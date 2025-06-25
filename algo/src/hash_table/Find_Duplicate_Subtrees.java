package hash_table;

import java.util.*;

public class Find_Duplicate_Subtrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 노드 구조 자체를 문자열로 표현 한다는 생각을 하지는 못했는데
     * 문자열 비교 하면 되겠다 까지는 생각했어도.. 굉장히 유용한 도구? 느낌이다
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Set<TreeNode> result = new HashSet<>();
        dfs(root, map, result);
        return new ArrayList<>(result);
    }

    public String dfs(TreeNode node, Map<String, Integer> map, Set<TreeNode> result) {
        if (node == null) return "#";

        String serial = node.val + "," + dfs(node.left, map, result) + "," + dfs(node.right, map, result);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            result.add(node);
        }
        return serial;
    }
}
