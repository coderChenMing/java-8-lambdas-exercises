package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {
    /*
     * reduce 求和
     * @param numbers
     * @return int
     * @author charmFlightChen@gmail.com
     * @date 2022/4/12
     **/
    public static int addUp(Stream<Integer> numbers) {

        Integer reduce = numbers.reduce(0, (acc, x) -> acc + x);
        System.out.println(reduce);
        return reduce;
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
            .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
            .collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
            .filter(album -> album.getTrackList().size() <= 3)
            .collect(toList());
    }

    public static void main(String[] args) {
        addUp(Stream.of(1, 2, 3, 4));
        List<Artist> old = Arrays.asList(
            new Artist("zhangsan", "中国"),
            new Artist("lisi", "泰国"),
            new Artist("wangwu", "缅甸 "),
            new Artist("liulda", "中国 ")

        );
        List<String> namesAndOrigins = getNamesAndOrigins(old);
        namesAndOrigins.forEach(System.out::println);
    }
}
