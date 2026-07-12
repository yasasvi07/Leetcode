class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] a = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            a[i] = arr[i];
        }
        Arrays.sort(a);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int k = 0;
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(a[i]);
            if(!hm.containsKey(a[i]))
            {
                k = k+1;
                hm.put(a[i],k);
            }
            
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = hm.get(arr[i]);
        }
        return arr;
    }
}