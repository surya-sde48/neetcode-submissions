class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, path, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> path, int total) {
        if(target == total) {
            res.add(new ArrayList<>(path));
            return;
        }

        if(target < total || i == candidates.length) {
            return;
        }

        //include 
        path.add(candidates[i]);
        backtrack(candidates, target, i + 1, path, total + candidates[i]);

        //Exclude
        path.remove(path.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1,path, total);
    }
}
