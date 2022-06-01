package lecture_16.task1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {

        final Statistic statistic = new Statistic();

        List<Family> families = Arrays.asList(
                new Family("First", 3, Arrays.asList(
                        new Member("member11", 30, Member.SEX.MAN, true),
                        new Member("member12", 30, Member.SEX.WOMAN, true),
                        new Member("member13", 2, Member.SEX.MAN, false)
                )),
                new Family("Second", 5, Arrays.asList(
                        new Member("member21", 30, Member.SEX.MAN, true),
                        new Member("member22", 30, Member.SEX.WOMAN, true),
                        new Member("membe23", 2, Member.SEX.MAN, false)
                )),
                new Family("Third", 30, Arrays.asList(
                        new Member("member31", 50, Member.SEX.MAN, true),
                        new Member("member32", 52, Member.SEX.WOMAN, true),
                        new Member("member33", 20, Member.SEX.MAN, true),
                        new Member("member33", 20, Member.SEX.WOMAN, false)
                ))
        );

        List<String> familyNames = families.stream()
                .filter(fam -> fam.getAge() > 4)
                .map(Family::getSname)
                .collect(Collectors.toList());

        System.out.println(familyNames);

        List<Member> adultMembers = families.stream()
                .flatMap(fam -> fam.getMembers().stream())
                .filter(Member::isAdult)
                .collect(Collectors.toList());
        System.out.println(adultMembers);

        Map<String, Integer> members = families.stream()
                .flatMap(fam -> fam.getMembers().stream())
                .filter(Member::isAdult)
                .collect(Collectors.toMap(Member::getName, Member::getAge));
        System.out.println(members);

        Stream<Integer> integerStream = families.stream()
                .flatMap(fam -> fam.getMembers().stream())
                .filter(Member::isAdult)
                .map(Member::getAge);

        System.out.println(integerStream);

        int asInt = IntStream.of(1, 2, 3, 4, 5, 6)
                .max().getAsInt();

        System.out.println(asInt);


        System.out.println("-------------------------------");
        List<String> lists = Arrays.asList("first", "first", "second", "third", "last");
        List<Integer> collect = lists.stream()
                .skip(1)
                .sorted((el1, el2) -> Integer.compare(el1.length(), el2.length()))
                .distinct()
                .filter(el -> el.length() >= 5)
                //.filter(el -> el.endsWith("t"))
                .peek(System.out::println)
                .map(String::length)
                //  .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("------------------");
        List<String> lists1 = new ArrayList<>();
        lists1.add("text1");
        lists1.add("text2");

        Stream<String> stream = lists1.stream();
        lists1.add("text3");

        List<String> collectList = stream.collect(Collectors.toList());
        Set<String> collectSet = lists1.stream().collect(Collectors.toSet());
        System.out.println(collectList);
        System.out.println(collectSet);

        families.stream().forEach(family -> statistic.result =statistic.result + 1);
        System.out.println(statistic.result);

        long count = families.stream().count();
        System.out.println(count);

    }
}
