package example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
      /*  Vehiculo mercedes = new Automovil("mercedes", "gl", 2020);
        int velocidad = mercedes.calcularVelocidad(10);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(1000000000);
        System.out.println("velocidad = " + velocidad);
        assert velocidad == 20; */

        List<Hero> heroes = Arrays.asList(
                new Hero("Superman", "Super strength", 35),
                new Hero("Batman", "Intelligence", 40),
                new Hero("Wonder Woman", "Lasso of Truth", 28),
                new Hero("The Flash", "Intelligence", 25),
                new Hero("Aquaman", "Control of the seas", 30),
                new Hero("Green Lantern", "Power ring", 32),
                new Hero("Spider-Man", "Web-slinging", 26),
                new Hero("Iron Man", "Powered suit", 38)
        );

        //filter heroes by power
       List<String> heroesName = heroes.stream().filter(hero -> "Intelligence".equals(hero.getPower()))
                .map(Hero::getName).toList();
        System.out.println("heroesName = " + heroesName);

        //sorted heroes by name
        Stream<Hero> sortedList = heroes.stream().sorted(Comparator.comparing(Hero::getName));
        sortedList.forEach(hero -> {
            System.out.println("hero.getName() = " + hero.getName());
        });


        //find the youngest hero
        Optional<Hero> youngestHero = heroes.stream().min(Comparator.comparing(Hero::getAge));
        System.out.println("youngest hero = " + youngestHero.get().getName());

        // category of power number of times
        List<String> power = heroes.stream().map(Hero::getPower).toList();
        Set<String> powerHero = new HashSet<>(power);
        for (String s : powerHero) {
            System.out.println(s + "The number of times used is: " + Collections.frequency(power, s));
        }

        //unique power set - that it cannot contain any duplicate element,
        List<String> notDuplicatePower = new ArrayList<>();
        for (String s : powerHero) {
            if (Collections.frequency(
                    power, s) == 1) {
                notDuplicatePower.add(s);
            }
        }
        notDuplicatePower.forEach(s -> System.out.println("Power that are unique: " + s));

        //average of heroes name
       double averageName = heroes.stream()
               .collect(Collectors.averagingInt(name -> 
                       Integer.parseInt(String.valueOf(name.getName().length()))));
        System.out.println("averageName = " + averageName);

        //Concatenación de Nombres: Crea una cadena que contenga los nombres de
        //todos los héroes separados por comas.

        String names = heroes.stream().map(Hero::getName)
                .collect(Collectors.joining(","));
        System.out.println("names = " + names);

        //Tres Héroes Más Antiguos: Encuentra los tres héroes más antiguos en la lista.
        Stream<Hero> sortedHeroList = heroes.stream().sorted(Comparator.comparing(Hero::getAge).reversed())
                .limit(3);
        String olderHeroes = sortedHeroList.map(Hero::getName).collect(Collectors.joining(","));
        System.out.println("olders heroes = " + olderHeroes);

        //Conteo de Héroes por Poder: Contar cuántos héroes tienen cada poder y
        //muestra el resultado como un mapa.


        Map<String, List<String>> result =  heroes.stream()
                .collect(Collectors.groupingBy(Hero::getPower, Collectors.mapping(Hero::getName, toList())));

        Map<String, Long> result2 =  heroes.stream()
                .collect(Collectors.groupingBy(Hero::getPower, counting()));

        System.out.println("result = " + result);

        System.out.println("result2 = " + result2);


        //Héroes por Inicial de Nombre: Agrupa los héroes por la inicial de su
        //nombre y muestra cuántos hay para cada inicial.

        Map<Character, Long> heroesInitialLetter =  heroes.stream()
                .map(hero -> hero.getName().charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

        heroesInitialLetter.entrySet().forEach(
                heroesInitial -> System.out.println("heroesInitialLetter = " + heroesInitial)
        );

       // Héroes con Poder Distinto: Encuentra héroes que tengan poderes
       // diferentes a los de otro conjunto de héroes dado.

        List<Hero> heroesOtroConjunto = Arrays.asList(
                new Hero("Superman", "Super strength", 35),
                new Hero("Batman", "Intelligence", 40),
                new Hero("Wonder Woman", "Lasso of Truth", 28)
        );

        Set<String> lista = heroes.stream()
                .map(Hero::getPower)
                .filter(f -> !heroesOtroConjunto.contains(f))
                .collect(Collectors.toSet());
        System.out.println(lista);

        //Edad Promedio por Poder: Calcular la edad promedio de los héroes para
        //cada poder y muestra el resultado como un mapa.

        Map<String, Double> heroesAVG = heroes.stream()
                .collect(groupingBy(Hero::getPower, averagingLong(Hero::getAge)));

        heroesAVG.entrySet().forEach(
                heroesInitial -> System.out.println("heroesAV = " + heroesInitial)
        );

        //Héroes por Categoría de Edad: Agrupa los héroes en categorías de edad
        //        (por ejemplo, menores de 25, entre 25 y 35, mayores de 35) y muestra
        //cuántos héroes hay en cada categoría.

         Long youngestHeroes = heroes.stream().filter(hero -> hero.getAge() < 26)
                 .count();

        Long middleAgeHeroes = heroes.stream().filter(hero -> hero.getAge() > 25 && hero.getAge() < 32)
                .count();

        Long oldestHeroes = heroes.stream().filter(hero -> hero.getAge() > 35)
                        .count();

        Map<String, Long> heroesCategory = new HashMap<>();

        heroesCategory.put("less than 26", youngestHeroes);
        heroesCategory.put("between 25 and 32", middleAgeHeroes);
        heroesCategory.put("greater than 35", oldestHeroes);

        heroesCategory.entrySet().forEach(
                heroesCatego -> System.out.println("heroesAV = " + heroesCatego)
        );
    }

}
