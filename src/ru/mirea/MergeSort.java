package ru.mirea;

import java.util.*;

public class MergeSort {
  private static final Scanner IN = new Scanner(System.in);

  private static String[] helper;

  public static void main(String[] args) {
    String[] list1 = new String[5];       // первый список имён студентов
    String[] list2 = new String[5];       // второй список имён студентов

    System.out.print("Введите 5 имён студентов: ");
    for (int i = 0; i < list1.length; ++i) {
      list1[i] = IN.next();
    }

    System.out.print("Введите ещё 5 имён студентов: ");
    for (int i = 0; i < list2.length; ++i) {
      list2[i] = IN.next();
    }

    String[] list = new String[list1.length + list2.length];

    System.arraycopy(list1, 0, list, 0, list1.length);
    System.arraycopy(list2, 0, list, list1.length, list2.length);

    sort(list);

    System.out.println();
    System.out.println("Список студентов:");

    for (String stud : list) {
      System.out.println("    " + stud);
    }
  }

  /**
   * Сравнивает лексикографически 2 строки
   * @param val1          первая сравниваемая строка
   * @param val2          вторая сравниваемая строка
   */
  private static boolean less(String val1, String val2) {
    return val1.compareTo(val2) < 0;
  }

  /**
   * Объединяет подмассивы array[low...mid], array[mid+1...high]
   * @param array           массив
   * @param low             наименьший индекс
   * @param mid             индекс среднего элемента
   * @param high            наибольший индекс
   */
  private static void merge(String[] array, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;

    helper = array.clone();

    for (int k = low; k <= high; ++k) {
      if (i > mid) {
        array[k] = helper[j++];
      }
      else if (j > high) {
        array[k] = helper[i++];
      }
      else if (less(helper[j], helper[i])) {
        array[k] = helper[j++];
      }
      else {
        array[k] = helper[i++];
      }
    }
  }

  /**
   * Проводит сортировку слиянием
   * @param array       сортируемый массив
   */
  private static void sort(String[] array) {
    helper = new String[array.length];
    sort(array, 0, array.length - 1);
  }

  /**
   * Проводит сортировку слиянием
   * @param array         сортируемый массив
   * @param low           наименьший индекс массива
   * @param high          наибольший индекс массива
   */
  private static void sort(String[] array, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high - low) / 2;

    sort(array, low, mid);
    sort(array, mid + 1, high);
    merge(array, low, mid, high);
  }
}
