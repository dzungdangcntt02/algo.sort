package Demo.src.algorithm;

public class Sort {
	public void insertionSort(int arr[]) {
		int index, value;
		for (int i = 1; i < arr.length; i++) {
			index = i;
			value = arr[i];
			while (index > 0 && arr[index - 1] > value) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = value;
		}
	}
	
	public void selectionSort(int arr[]) {
		int indexMin;
		for (int i = 0; i < arr.length - 1; i++){
			indexMin = i;
			for (int j = i + 1; j < arr.length; j++){
				if (arr[indexMin] > arr[j]){
					indexMin = j;
				}
			}
			if (i != indexMin){
				int temp = arr[i];
				arr[i] = arr[indexMin];
				arr[indexMin] = temp;
			}
		}
	}
	
	public void merge(int arr[], int l, int m, int r) {
		// Tìm kích thước của 2 mảng con để merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo mảng tạm
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
	}
	public void mergeSort(int arr[], int l, int r) {
		if (l < r) {
            // Tìm điểm chính giữa
            int m = (l + r) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
	}
}
 