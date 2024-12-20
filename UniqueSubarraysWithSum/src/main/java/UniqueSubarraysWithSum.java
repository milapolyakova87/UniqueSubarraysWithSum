import java.util.*;

public class UniqueSubarraysWithSum {

    // Метод для подсчета уникальных подмассивов с заданной суммой
    public static int countUniqueSubarraysWithSum(int[] nums, int targetSum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Используем множество для хранения уникальных подмассивов
        Set<List<Integer>> uniqueSubarrays = new HashSet<>();

        // Для каждого элемента массива ищем подмассивы, начиная с этого элемента
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            List<Integer> subarray = new ArrayList<>();

            // Начинаем с текущего элемента и добавляем элементы, пока сумма не достигнет targetSum
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                subarray.add(nums[j]);

                // Если сумма равна targetSum, добавляем подмассив в множество
                if (currentSum == targetSum) {
                    uniqueSubarrays.add(new ArrayList<>(subarray));
                }

                // Если сумма превысила targetSum, прекращаем поиск для текущего начала
                if (currentSum >= targetSum) {
                    break;
                }
            }
        }

        // Возвращаем количество уникальных подмассивов
        return uniqueSubarrays.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи массив целых чисел через пробел:");
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");

        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println("Введи целевую сумму:");
        int targetSum = scanner.nextInt();

        // Вычисляем количество уникальных подмассивов
        int result = countUniqueSubarraysWithSum(nums, targetSum);

        // Выводим результат
        System.out.println("Количество уникальных подмассивов с суммой " + targetSum + ": " + result);

        scanner.close();
    }
}