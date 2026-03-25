import java.util.ArrayList;

class Solution {
    public int[] sortByBits(int[] arr) {
  
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int a : arr){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(Integer.bitCount(a));
            al.add(a);
            ans.add(al);
        }
        ans.sort((row1, row2) -> {
            if (!row1.get(0).equals(row2.get(0))) {
                return Integer.compare(row1.get(0), row2.get(0));
            }
            return Integer.compare(row1.get(1), row2.get(1));
        });
        ArrayList<Integer> final_ans = new ArrayList<>();
        for(int i = 0; i<ans.size(); i++) {
            final_ans.add(ans.get(i).get(1));
        }
        int[] streamArray = final_ans.stream().mapToInt(Integer::intValue).toArray();
        return streamArray;
    }
}