package ru.mirea;

import java.util.Comparator;
import ru.mirea.classes.*;

public class QuickSort {
  public static void main(String[] args) {
    Student[] studs = new Student[5];

    studs[0] = new Student(5, 4.5, "Student #5");
    studs[1] = new Student(2, 4.0, "Student #2");
    studs[2] = new Student(3, 3.0, "Student #3");
    studs[3] = new Student(1, 3.5, "Student #1");
    studs[4] = new Student(4, 3.6, "Student #4");

    System.out.println("Список студентов:");
    for (Student stud : studs) {
      System.out.println("  * " + stud.getName() + ": " + stud.getGpa());
    }

    sort(studs);

    System.out.println("Список студентов:");
    for (Student stud : studs) {
      System.out.println("  * " + stud.getName() + ": " + stud.getGpa());
    }
  }

  /**
   * Определяет, меньше ли val1, чем val2
   * @param val1          значение 1
   * @param val2          значение 2
   */
  private static boolean less(Comparator val1, Comparator val2) {
    return val1.compare(val1, val2) < 0;
  }

  /**
   * Меняет местами заданные элементы массива
   * @param array         массив
   * @param i             индекс одного из элементов
   * @param j             индекс другого элемента
   */
  private static void swap(Comparator[] array, int i, int j) {
    Comparator temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /**
   * Выполняет разбиение массива
   */
  private static int divide(Comparator[] array, int low, int high) {
    int i = low;
    int j = high + 1;

    Comparator pivot = array[low];

    while (true) {
      while (less(array[++i], pivot)) {
        if (i == high)
          break;
      }

      while (less(pivot, array[--j])) {
        if (j == low)
          break;
      }

      if (i >= j)
        break;

      swap(array, i, j);
    }

    swap(array, low, j);
    return j;
  }

  private static void sort(Comparator[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(Comparator[] array, int low, int high) {
    if (high <= low)
      return;

    int j = divide(array, low, high);

    sort(array, low, j - 1);
    sort(array, j + 1, high);
  }
}
