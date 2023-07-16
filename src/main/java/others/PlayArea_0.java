package others;

import com.sun.source.tree.Tree;
import org.leetcode.common.ListNode;
import org.leetcode.common.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class PlayArea_0 {


    public static void main(String[] args) {
    }


    // 1
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }


    // 2
    public static int removeDuplicates(int[] nums) {
        int L = 1;

        for (int R = 1; R < nums.length; R++) {
            if (nums[R] != nums[R-1]) {
                nums[L] = nums[R];
                L++;
            }
        }

        return L;

    }

    // 3
    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i > 0; i--) {


            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }


    // 4 sell shares
    public int maxProfit(int[] prices) {
        int min_value = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < min_value) {
                min_value = prices[i];
            } else if (prices[i] - min_value > max_profit) {
                max_profit = prices[i] - min_value;
            }
        }

        return max_profit;
    }


    // 5
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length-1; i += 2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }

    // 6
    public int[] twoSumII(int[] numbers, int target) {

        int L = 0;
        int R = numbers.length - 1;

        while (L <= R) {

            int sum = numbers[L] + numbers[R];
            if (sum > target) {
                R--;
            } else if (sum < target) {
                L++;
            } else {
                return new int[]{L, R};
            }
        }


        return new int[] {L, R};
    }

    // 7
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length-1);

    }

    private static int[] reverse(int[] numbers, int sIndex, int eIndex) {

        while (sIndex <= eIndex) {
            int tmp = numbers[sIndex];
            numbers[sIndex] = numbers[eIndex];
            numbers[eIndex] = numbers[tmp];

            sIndex++;
            eIndex--;
        }

        return numbers;
    }

    // 8
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // 9
    public void moveZeroes(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        for (int L = 0, R = 0; R < nums.length-1; R++) {
            if (nums[R] != 0) {
                swap(nums, L, R);
                L++;
            }
        }

    }

    private static int[] swap(int[] numbers, int a_index, int b_index) {
        int tmp = numbers[a_index];
        numbers[a_index] = numbers[b_index];
        numbers[b_index] = tmp;
        return numbers;
    }


    // 10
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> map1 = new HashSet<>();
        for (int num: nums1) {
            map1.add(num);
        }

        Set<Integer> map2 = new HashSet<>();
        for (int num: nums2) {
            if (map1.contains(num)) {
                map2.add(num);
            }
        }

        int[] result = new int[map2.size()];
        int index = 0;
        for(int i : map2) {
            result[index++] = i;
        }

        return result;
    }


    // 11
    public int[] intersectionII(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = frequencyMap(nums1);
        Map<Integer, Integer> map2 = frequencyMap(nums2);

        List<Integer> results = new ArrayList<>();
        for(Map.Entry<Integer, Integer> map : map1.entrySet() ) {

            if (map2.containsKey(map.getKey())) {

                int maxCount = Math.max(map1.get(map.getKey()), map2.get(map.getKey()));
                while (maxCount > 0) {
                    results.add(map.getKey());
                    maxCount--;
                }
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    public static Map<Integer, Integer> frequencyMap(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }

            map.put(num, 1);
        }

        return map;
    }

    // 12
    public int[] sortedSquares(int[] num) {

        if (num.length == 0) {
            return num;
        }

        int L = 0;
        int R = num.length - 1;
        int i = num.length - 1;

        int[] results = new int[num.length - 1];
        while (L <= R ) {

            if ( sqr(num[L])  > sqr(num[R]) ) {
                results[i] = sqr(num[L]);
                L++;
            }else {
                results[i] = sqr(num[R]);
                R--;
            }
            i--;
        }

        return results;
    }

    private static int sqr(int num) {
        return (int) Math.pow(num, 2);
    }


    // 13
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {

        int carry = 0;
        int rem = 0;

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while ( L1 != null || L2 != null) {

            int x = L1 != null ? L1.val : 0;
            int y = L1 != null ? L2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            rem = sum % 10;

            cur.next = new ListNode(rem);
            cur = cur.next;

            if(L1 != null) L1 = L1.next;
            if(L2 != null) L2 = L2.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }



        return dummyHead.next;
    }


    // 14
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;


        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    // 15
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;

                curr = curr.next;
                list1 = list2.next;
            } else {
                curr.next = list2;

                curr = curr.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
        }

        if (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
        }

        return dummy.next;
    }


    // 16
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (slow == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    // 17
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode curr = head.next;
            head.next = prev;

            prev = head;
            head = curr;
        }

        return prev;
    }


    // 18
    public boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        // traverse to mid element
        while ( right != null && right.next != null ) {
            right = right.next.next;
            left = left.next;
        }

        right = left; // point to mid element
        right = reverseList(right);
        left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // 19
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }



    // 20
    public int searchInsert(int[] nums, int target) {

        if (target > nums[nums.length-1]) return nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                left = mid  + 1;
            }else {
                right = mid - 1;
            }

        }

        return left;
    }

    // 21
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

        return list;
    }

    // 22
    public int binarySearch(int[] nums, int target) {

        int L = 0;
        int R = nums.length - 1;

        while ( L <= R ) {
            int mid = (L + R) / 2;

            if (nums[mid] == target) return mid;

            if (target > nums[mid]) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }

        return -1;
    }

    // 23
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, p.right);
    }

    // 24
    public static boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);


        return Math.max(left, right) + 1;

    }

    public int lengthOfLongestSubstring(String s) {

        int winSize = 0;
        int L = 0;
        int R = 0;

        HashSet<Character> set = new HashSet<>();
        while (R < s.length()) {
            char ch = s.charAt(R);

            if (!set.contains(ch)) {
                set.add(ch);
                R++;

                winSize = Math.max(set.size(), winSize);
            }

            set.remove(ch);
            L++;
        }

        return winSize;
    }

    public static String longestCommonPrefix(String[] str) {

        if (str.length == 0) return "";

        String prefix = str[0];

        for (int i = 0; i < str.length; i++) {

            if (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }

        }
        return prefix;
    }

    public int strStr(String haystack, String needle) {

        if (haystack.length() == 1) return 0;

        // window size
        int winSize = needle.length();

        for (int L = 0, R = winSize; R <= haystack.length(); L++, R++) {

            if (haystack.substring(L, R).equals(needle)) {
                return L;
            }
        }
        return -1;
    }

    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() -1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            j++;
            i--;

        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] char_counts = new int[26];

        for (int i = 0; i < s.length(); i++) {

            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;

        }

        for (int count : char_counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;


    }

    public static int longestPalindrome(String s) {

        int[] counts = new int[128];
        for (char c: s.toCharArray()) {
            counts[c]++;
        }

        int result = 0;
        for (int count : counts) {

            result += count / 2 * 2;

            if (result % 2 == 0 && count % 2 == 1) {
                result++;
            }

        }

        return result;
    }


}
