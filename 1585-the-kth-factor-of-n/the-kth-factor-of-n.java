class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int root = (int)Math.sqrt(n);
        System.out.println(root);
        for(int i = 1; i <= root; i++){
            if(n % i == 0){
                if(i == n / i){

                    arr.add(i);
                }else{
                    arr.add(i);

                    arr2.add(0, n / i);
                }
            }
        }

        arr.addAll(arr2);
        if(arr.size() < k){
            return -1;
        }
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        return arr.get(k-1);
    }
}