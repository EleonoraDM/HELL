package core;

public interface HellController {

    String createHero(String heroName, String heroType);

    String addItem(String name,
                   String heroName,
                   String... parameters);

    String addRecipeItem(String name,
                         String heroName,
                         String... parameters);

    String inspectHero(String name);

    String reportHeroes();
}
