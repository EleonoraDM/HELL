package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import entities.items.Recipe;
import factories.HeroFactory;
import factories.ItemFactory;
import repositories.HeroRepository;

import java.util.Arrays;

public class AddRecipeCommand extends CommandImpl {

    public AddRecipeCommand(ItemFactory itemFactory,
                            HeroRepository heroRepository,
                            String[] parameters) {
        super(parameters);
        this.setItemFactory(itemFactory);
        this.setHeroRepository(heroRepository);
    }

    @Override
    public String execute() {
        String itemType = Recipe.class.getSimpleName();

        String[] parameters = this.getParameters();
        String name = parameters[0];
        String heroName = parameters[1];
        String[] stats = Arrays.copyOfRange(parameters, 2, parameters.length);


        Recipe item = ((Recipe) this.getItemFactory().create(itemType, name, heroName, stats));
        Hero hero = this.getHeroRepository().getByName(heroName);
        hero.addRecipe(item);

        return String.format(OutputMessages.RECIPE_ADDED, name, heroName);
    }
}
