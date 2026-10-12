import java.util.Arrays;
import java.util.Scanner;

public class Question2 {

    static int insert(int[] arr, int n, int position, int value) {
        if (n == arr.length) {
            System.out.println("Array is full. Insertion is not possible.");
            return n;
        }
        if (position < 0 || position > n) {
            System.out.println("Invalid position.");
            return n;
        }

        for (int i = n; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = value;
        return n + 1;
    }

    static int delete(int[] arr, int n, int position) {
        if (position < 0 || position >= n) {
            System.out.println("Invalid position.");
            return n;
        }

        for (int i = position; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array capacity: ");
        int capacity = sc.nextInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be positive.");
            sc.close();
            return;
        }

        int[] arr = new int[capacity];

        System.out.print("Enter number of initial elements: ");
        int n = sc.nextInt();

        if (n < 0 || n > capacity) {
            System.out.println("Invalid number of elements.");
            sc.close();
            return;
        }

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\\n--- ARRAY OPERATIONS MENU ---");
            System.out.println("1. Display array");
            System.out.println("2. Insert element");
            System.out.println("3. Delete element");
            System.out.println("4. Linear search");
            System.out.println("5. Binary search");
            System.out.println("6. Find maximum value");
            System.out.println("7. Count even and odd elements");
            System.out.println("8. Insertion sort");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Array: "
                            + Arrays.toString(Arrays.copyOf(arr, n)));
                    break;

                case 2:
                    System.out.print("Enter position (0 to " + n + "): ");
                    int position = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    n = insert(arr, n, position, value);
                    break;

                case 3:
                    if (n == 0) {
                        System.out.println("Array is empty.");
                        break;
                    }
                    System.out.print("Enter position (0 to " + (n - 1) + "): ");
                    position = sc.nextInt();
                    n = delete(arr, n, position);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    int index = linearSearch(arr, n, key);
                    System.out.println(index == -1
                            ? "Element not found."
                            : "Element found at index " + index);
                    break;

                case 5:
                    System.out.print("Enter value to search: ");
                    key = sc.nextInt();
                    int[] sortedCopy = Arrays.copyOf(arr, n);
                    Arrays.sort(sortedCopy);
                    index = binarySearch(sortedCopy, n, key);
                    System.out.println("Sorted array: "
                            + Arrays.toString(sortedCopy));
                    System.out.println(index == -1
                            ? "Element not found."
                            : "Element found at index " + index
                              + " in the sorted array");
                    break;

                case 6:
                    if (n == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        int max = arr[0];
                        for (int i = 1; i < n; i++) {
                            if (arr[i] > max) {
                                max = arr[i];
                            }
                        }
                        System.out.println("Maximum value = " + max);
                    }
                    break;

                case 7:
                    int even = 0;
                    int odd = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0) {
                            even++;
                        } else {
                            odd++;
                        }
                    }
                    System.out.println("Even elements = " + even);
                    System.out.println("Odd elements = " + odd);
                    break;

                case 8:
                    insertionSort(arr, n);
                    System.out.println("Sorted array: "
                            + Arrays.toString(Arrays.copyOf(arr, n)));
                    break;

                case 9:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}
