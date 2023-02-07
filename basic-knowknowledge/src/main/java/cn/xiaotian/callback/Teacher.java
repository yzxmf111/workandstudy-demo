package cn.xiaotian.callback;

/**
 * @author xiaotian
 * @description
 * @date 2022-12-01 09:50
 */
public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}