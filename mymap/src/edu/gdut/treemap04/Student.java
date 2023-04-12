package edu.gdut.treemap04;

/**
 * @author Luffy
 */
public class Student implements Comparable<Student> {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        //this表示当前要添加的元素
        //o表示已经红黑树已经存在的元素
        int res = this.age-o.age;
        res= res == 0 ? this.name.compareTo(o.name):res;
        return res;
    }
}
