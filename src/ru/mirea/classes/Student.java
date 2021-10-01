package ru.mirea.classes;

import java.util.Comparator;

public class Student implements Comparator<Student>, Comparable<Student> {
  private int id;
  private double gpa;
  private String name;

  /**
   * Конструктор не по умолчанию
   * @param id            id студента
   * @param gpa           итоговый балл
   * @param name          имя студента
   */
  public Student(int id, double gpa, String name) {
    this.id = id;
    this.gpa = gpa;
    this.name = name;
  }

  /**
   * Геттер для поля id
   * @return        id студента
   */
  public int getId() {
    return this.id;
  }

  /**
   * Геттер для поля gpa
   * @return      итоговый балл
   */
  public double getGpa() {
    return this.gpa;
  }

  /**
   * Геттер для поля name
   * @return        имя студента
   */
  public String getName() {
    return this.name;
  }

  /**
   * Возвращает число < 0, если id студента меньше id другого студента
   *            число = 0, если id студента равно id другого студента
   *            число > 0, если id студента больше id другого студента
   * @param o1         первый студент
   * @param o2         другой студент
   */
  public int compare(Student o1, Student o2) {
    double res = o1.getGpa() - o2.getGpa();
    return Double.compare(res, 0.0);

  }

  /**
   * Возвращает число < 0, если id студента меньше id другого студента
   *            число = 0, если id студента равно id другого студента
   *            число > 0, если id студента больше id другого студента
   * @param other         другой студент
   */
  public int compareTo(Student other) {
    return this.id - other.getId();
  }
}
