package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class JusticeLeague {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/justiceleague.dat"));

        int candidates = file.nextInt();
        file.nextLine();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < candidates; i++) {
            heroes.add(new Hero(file.nextLine(), file.nextInt(), file.nextInt(), file.nextInt()));
            file.nextLine();
        }
        List<Hero> strength = new ArrayList<>();
        List<Hero> speed = new ArrayList<>();
        List<Hero> wealth = new ArrayList<>();
        for (Hero h : heroes) {
            strength.add(h);
            speed.add(h);
            wealth.add(h);
        }

        strength.sort((o1, o2) -> o2.strength - o1.strength);
        speed.sort((o1, o2) -> o2.speed - o1.speed);
        wealth.sort((o1, o2) -> o2.wealth - o1.wealth);

        System.out.println("Strength:");
        strength.forEach(System.out::println);
        System.out.println();

        System.out.println("Speed:");
        speed.forEach(System.out::println);
        System.out.println();

        System.out.println("Wealth:");
        wealth.forEach(System.out::println);
        System.out.println();

        TreeSet<Hero> team = new TreeSet<>();
        team.add(strength.get(0));
        team.add(strength.get(1));
        team.add(speed.get(0));
        team.add(speed.get(1));
        team.add(wealth.get(0));
        team.add(wealth.get(1));

        System.out.println("New Justice League:");
        team.forEach(System.out::println);


    }

    static class Hero implements Comparable<Hero> {
        String name;
        int strength, speed, wealth;

        Hero(String name, int strength, int speed, int wealth) {
            this.name = name;
            this.strength = strength;
            this.speed = speed;
            this.wealth = wealth;
        }

        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Hero o) {
            return name.compareTo(o.name);
        }
    }
}
