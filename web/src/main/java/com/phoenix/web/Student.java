package com.phoenix.web;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Auther: tianfeng
 * @Date: 2020-08-17 20:12
 */
class Student{
    int stuId;
    int stuAge;
    String stuName;

    List<String> boxCodes;

    public Student() {
    }

    Student(int id, int age, String name){
        this.stuId = id;
        this.stuAge = age;
        this.stuName = name;
    }
    public int getStuId() {
        return stuId;
    }
    public int getStuAge() {
        return stuAge;
    }
    public String getStuName() {
        return stuName;
    }
    public static List<Student> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(11, 28, "Lucy"));
        //list.add(new Student(28, 27, "Kiku"));
        //list.add(new Student(32, 30, "Dani"));
        //list.add(new Student(49, 27, "Steve"));
        return list;
    }

    public List<String> getBoxCodes() {
        return boxCodes;
    }

    public void setBoxCodes(List<String> boxCodes) {
        this.boxCodes = boxCodes;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
class Example {
    public static void main(String[] args) {


        Student student = new Student();
        student.setStuName("123");
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("efg");
        student.setBoxCodes(stringList);
        System.out.println(JSON.toJSONString(student));






        Predicate<Student> p1 = s -> s.stuName.startsWith("L");
        //Predicate<Student> p2 = s -> s.stuAge < 28 && s.stuName.startsWith("P");
        List<Student> list = Student.getStudents();

        /* noneMatch() method returns true if none of the stream elements matches
         * the given predicate
         */
        /* This will return false because there is a element in the stream that
         * matches the condition specified in the predicate p1.
         * Condition: Student Name should start with letter "L"
         * Stream element matched: Lucy
         */
        boolean b1 = list.stream().noneMatch(s -> judge(s,"L"));
        System.out.println("list.stream().noneMatch(p1): "+b1);

        /* This will return true because none of the elements
         * matches the condition specified in the predicate p2.
         * Condition: Student Name should start with letter "P" and age must be <28
         * Stream element matched: none
         */
        //boolean b2 = list.stream().noneMatch(p2);
        //System.out.println("list.stream().noneMatch(p2): "+b2);
    }

    private static boolean judge(Student s, String l) {
        String name = s.getStuName();
        return name.startsWith(l);
    }
}
