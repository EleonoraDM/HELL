package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import entities.items.Recipe;
import factories.ItemFactory;
import repositories.HeroRepository;

import java.util.Arrays;

public class AddRecipeCommand implements Command {
    private ItemFactory itemFactory;
    private HeroRepository heroRepository;

    private String[] params;

    public AddRecipeCommand(ItemFactory itemFactory, HeroRepository heroRepository, String ...parameters) {
        this.itemFactory = itemFactory;
        this.heroRepository = heroRepository;
        this.params = parameters;
    }

    @Override
    public String execute() {
        String itemType = Recipe.class.getSimpleName();
        String name = this.params[0];
        String heroName = this.params[1];
        String[]stats = Arrays.copyOfRange(this.params, 2, this.params.length);


        Recipe item = ((Recipe) this.itemFactory.create(itemType, name, heroName, stats));
        Hero hero = this.heroRepository.getByName(heroName);
        hero.addRecipe(item);

        return String.format(OutputMessages.RECIPE_ADDED, name, heroName);
    }
}
