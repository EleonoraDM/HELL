package core;

public interface HellController {

    String createHero(String heroName, String heroType);

    String addItem(String itemType,
                   String name,
                   String heroName,
                   String... parameters);

    String addRecipeItem(String itemType,
                         String name,
                         String heroName,
                         String... parameters);

    String inspectHero(String name);

    String reportHeroes();
}
