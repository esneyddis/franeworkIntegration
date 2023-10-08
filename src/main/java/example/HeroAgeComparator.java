package example;

import java.util.Comparator;

public class HeroAgeComparator implements Comparator<Hero> {
    @Override
    public int compare(Hero o1, Hero o2) {
        return o1.getAge() - o2.getAge();
    }
}
