import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test thôi mà");
        ArrayList<Person> people = new ArrayList<Person>(List.of(
                new Person("Vinh", "Vietnam", 28),
                new Person("Lan", "Vietnam", 24),
                new Person("John", "USA", 27),
                new Person("Lee", "China", 67),
                new Person("Kim", "Korea", 22),
                new Person("Long", "Vietnam", 18),
                new Person("Jungho", "Korea", 19),
                new Person("Tian", "China", 20),
                new Person("Clara", "USA", 40),
                new Person("Mikura", "Japan", 27),
                new Person("Sony", "Japan", 29),
                new Person("Xiang", "China", 78),
                new Person("Peter", "France", 18),
                new Person("Haloy", "Malaysia", 20),
                new Person("Magie", "Malaysia", 32)
        ));

        Map<String, Long> mapnationality = people.stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));

        System.out.println("Đếm số người theo từng quốc tịch: ");
        Set<String> set = mapnationality.keySet();
        for (String key : set) {
            System.out.println(key + " - " + mapnationality.get(key));
        }
        System.out.println();
        System.out.println("Sắp xếp theo tên những người trên 25 tuổi: ");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).age > 25) {
                System.out.println(people.get(i).toString());
            }
        }
        System.out.printf("");
        System.out.println("Tính trung bình tuổi của người theo từng quốc gia:");
        Map<String, Double> maptuoi = people.stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.averagingLong(Person::getAge)));
        Set<String> set2 = maptuoi.keySet();
        for (String key2 : set2) {
            System.out.println(key2 + " - " + maptuoi.get(key2));
        }
        System.out.println("Đánh giá tuổi mỗi người:");
      for (int i = 0; i<people.size();i++ ){
          System.out.print(people.get(i).toString()+" - ");
         System.out.println(DanhGiaTuoi(people.get(i).age));
      }
    }

    static String DanhGiaTuoi(int tuoi) {
        if (tuoi < 20) {
            return "Nổi loạn";
        } else if (tuoi >= 20 && tuoi <= 30) {
            return "Việc làm";
        } else if (tuoi >= 30 && tuoi <= 40) {
            return "Sự nghiệp";
        } else return "Hưởng thụ";
    }
}


