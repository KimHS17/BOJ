class Solution {
    public void mergeSort(int[] arr, int left, int right) {
        if(left >= right)
            return;
        
        int mid = (left + right) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }
    
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j] )
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i<=mid) temp[k++] = arr[i++];

        while (j<=right) temp[k++] = arr[j++];

        for(i=left; i<=right; i++){
            arr[i] = temp[i];
        }
    }
    
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] arr;

        for(int i = 0; i < commands.length; i++) {
            arr = array.clone();
            mergeSort(arr, commands[i][0] - 1, commands[i][1] - 1);
            answer[i] = arr[commands[i][0] + commands[i][2] - 2];
        }
        
        return answer;
    }
}