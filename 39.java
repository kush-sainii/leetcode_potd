import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        solver(0, candidates, target, new ArrayList<>(), finalList);
        return finalList;
    }

    public void solver(int index, int[] candidates, int target, List<Integer> list,
    List<List<Integer>> finalList) {

        if (target == 0) {
            finalList.add(new ArrayList<>(list)); // Store a copy of the list
            return;
        }

        if (index >= candidates.length || target < 0) {
            return; // Stop when out of bounds or sum exceeds target
        }


        list.add(candidates[index]);
        solver(index, candidates, target - candidates[index], list, finalList);

        list.remove(list.size() - 1);
        solver(index + 1, candidates, target, list, finalList);
    }
}