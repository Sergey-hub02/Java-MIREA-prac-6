package ru.mirea;

import ru.mirea.classes.*;

public class InsertSort {
  public static void main(String[] args) {
    Student[] studs = new Student[5];

    studs[0] = new Student(5, 4.5, "Student #5");
    studs[1] = new Student(2, 4.0, "Student #2");
    studs[2] = new Student(3, 3.0, "Student #3");
    studs[3] = new Student(1, 3.5, "Student #1");
    studs[4] = new Student(4, 3.6, "Student #4");

    System.out.println("Список студентов:");
    for (Student stud : studs) {
      System.out.println("  * " + stud.getName());
    }

    insertSort(studs);

    System.out.println("Список студентов:");
    for (Student stud : studs) {
      System.out.println("  * " + stud.getName());
    }
  }

  /**
   * Реализует сортировку вставками
   * @param array         сортируемый массив
   */
  private static void insertSort(Comparable[] array) {
    for (int i = 1; i < array.length; ++i) {
      for (int j = i; j > 0 && less(array[j], array[j - 1]); --j) {
        swap(array, j, j - 1);
      }
    }
  }

  /**
   * Определяет, меньше ли val1, чем val2
   * @param val1          значение 1
   * @param val2          значение 2
   */
  private static boolean less(Comparable val1, Comparable val2) {
    return val1.compareTo(val2) < 0;
  }

  /**
   * Меняет местами заданные элементы массива
   * @param array         массив
   * @param i             индекс одного из элементов
   * @param j             индекс другого элемента
   */
  private static void swap(Comparable[] array, int i, int j) {
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
