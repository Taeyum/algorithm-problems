import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 사진 틀 개수 N, 전체 학생 추천 횟수 C
// 학생 추천 -> 사진 틀에 들어감
// 비어있는 틀 x -> 가장 작은 추천 수 삭제 후 그 자리에 추가[작은 추천수 가 여려명 일 경우 오래된 놈 제거]
// 이미 틀에 있는 학생 추천 시 -> 추천 횟수 증가
// 가장 적은 추천 수 학생이 삭제 되는 경우 그 학생의 추천 수는 0이 됨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            int student = Integer.parseInt(st.nextToken());

            boolean isCheck = false;
            for (Student s : list) {
                if(s.student == student) {
                    s.count++;
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck) {
                if(list.size() == N) {
                    Collections.sort(list);
                    list.remove(0);
                }
                list.add(new Student(student, 1, i));
            }
        }

//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.student - s2.student;
//            }
//        });

        list.sort((s1,s2) -> s1.student - s2.student);

        for (Student s : list) {
            System.out.print(s.student + " ");
        }
    }

    static class Student implements Comparable<Student> {
        int student, count, time;

        public Student(int student, int count, int time) {
            this.student = student;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if(this.count == o.count) return this.time - o.time;
            return this.count - o.count;
        }
    }
}
