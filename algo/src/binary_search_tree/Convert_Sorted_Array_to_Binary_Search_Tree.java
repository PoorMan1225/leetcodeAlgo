package binary_search_tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]); // ✅ 현재 노드 먼저 생성
        node.left = buildBST(nums, start, mid - 1); // ✅ 왼쪽 서브트리 생성
        node.right = buildBST(nums, mid + 1, end);  // ✅ 오른쪽 서브트리 생성
        return node;
    }
}
