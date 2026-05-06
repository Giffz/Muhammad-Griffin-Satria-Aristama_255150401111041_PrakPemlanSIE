//Sort.java
import java.util.Arrays;

public class Sort {
    
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;
                }
            }
        }
        System.out.println("Total tukar/geser Bubble Sort: " + tukarAtauGeser);
        return list;
    }

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++;
            }
            list[k + 1] = key;
        }
        System.out.println("Total tukar/geser Insertion Sort: " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0; 
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                    minIndex = k;
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++; 
        }
        System.out.println("Total tukar/geser Selection Sort: " + tukarAtauGeser);
        return list;
    }

    public static void main(String[] args) {

        int[] arr = new int[30];
        int count = 0;

        while (count < 30) {
            int randomNum = (int) (Math.random() * 100) + 1;
            boolean isDuplicate = false;

            for (int i = 0; i < count; i++) {
                if (arr[i] == randomNum) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                arr[count] = randomNum;
                count++;
            }
        }

        System.out.println("Nilai Array arr[] (Belum Terurut):");
        System.out.println(Arrays.toString(arr));
        
        System.out.println("\n------------------------------------------------\n");
        
        int[] arrBubble = arr.clone();
        int[] sortedBubble = bubble(arrBubble);
        System.out.println("1. Hasil pengurutan dengan Bubble Sort:");
        System.out.println(Arrays.toString(sortedBubble));
        System.out.println();

        int[] arrInsertion = arr.clone();
        int[] sortedInsertion = insertion(arrInsertion);
        System.out.println("2. Hasil pengurutan dengan Insertion Sort:");
        System.out.println(Arrays.toString(sortedInsertion));
        System.out.println();

        int[] arrSelection = arr.clone();
        int[] sortedSelection = selection(arrSelection);
        System.out.println("3. Hasil pengurutan dengan Selection Sort:");
        System.out.println(Arrays.toString(sortedSelection));
    }
}

//Searching.java
import java.util.Arrays;

public class Search {
    public static int linearSearch(int[] arr, int search) {
        int check = 0; // Deklarasi variabel lokal
        for (int i = 0; i < arr.length; i++) {
            check++; // Mencatat setiap kali elemen diperiksa
            if (arr[i] == search) {
                System.out.println("Jumlah pemeriksaan Linear Search: " + check + " kali");
                return i;
            }
        }
        System.out.println("Jumlah pemeriksaan Linear Search: " + check + " kali");
        return -1;
    }

    public static int binarySearch(int[] arr, int search) {
        int check = 0; // Deklarasi variabel lokal
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            check++; // Mencatat setiap kali membelah interval
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) {
                System.out.println("Jumlah pemeriksaan Binary Search: " + check + " kali");
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Jumlah pemeriksaan Binary Search: " + check + " kali");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[30];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }

        arr[29] = 88;

        Arrays.sort(arr);

        System.out.println("Data Array (Sudah Terurut secara Ascending):");
        System.out.println(Arrays.toString(arr));
        
        System.out.println("\n------------------------------------------------\n");

        int hasilLinearSearch = linearSearch(arr, 88);
        
        System.out.println("Pencarian Linear (Linear Search)");
        System.out.println("Angka 88 ditemukan pada indeks ke-: " + hasilLinearSearch);

        int hasilLinearGaib = linearSearch(arr, 999);
        
        System.out.println("Pencarian Linear untuk angka 999:");
        System.out.println("Hasil kembalian fungsi: " + hasilLinearGaib);

        int hasilBinarySearch = binarySearch(arr, 88);
        
        System.out.println("Pencarian Biner (Binary Search)");
        System.out.println("Angka 88 ditemukan pada indeks ke-: " + hasilBinarySearch);

        int hasilBinaryGaib = binarySearch(arr, 999);
        
        System.out.println("Pencarian Biner untuk angka 999:");
        System.out.println("Hasil kembalian fungsi: " + hasilBinaryGaib);
    }
}
