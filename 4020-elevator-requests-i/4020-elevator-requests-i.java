class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int cnt = requests[0];
        for(int i=1;i<requests.length;i++)
        {
            cnt+=Math.abs(requests[i]-requests[i-1]);
        }
        return cnt;
    }
}