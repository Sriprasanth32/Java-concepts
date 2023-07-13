class Student {
    private String stdName;
    private int stdRollNo;
    private int stdMob;

    public String getStdName() {

        return stdName;
    }

    public int getStdRollNo() {
        return stdRollNo;
    }

    public int getStdMob() {
        return stdMob;
    }

    public void setStdName(String name) {
        stdName = name;
    }

    public void setStdRollNo(int rollNo) {
        stdRollNo = rollNo;
    }

    public void setStdMob(int mob) {
        stdMob = mob;
    }
}

public class Encaps {
    public static void main(String[] args) {
        Student obj = new Student();
        obj.setStdName("Sriprasanth");
        obj.setStdRollNo(4);
        obj.setStdMob(99999);
        System.out.println("Student's Name: " + obj.getStdName());
        System.out.println("Student's Roll no.: " + obj.getStdRollNo());
        System.out.println("Student's Mobile: " + obj.getStdMob());
    }
}