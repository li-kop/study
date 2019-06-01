package deepcopy;

import java.io.*;

public class DeepCopy {
    public static void main(String[] args) throws Exception {
        Age age = new Age(10);

        Student student = new Student("李哥", age, 170);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(student);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student student1 = (Student) ois.readObject();

        System.out.println(student1.toString());

        age.setAge(20);
        student.setName("小李");
        student.setHeight(100);
        System.out.println("------------------");
        System.out.println(student);
        System.out.println(student1);
    }


}
