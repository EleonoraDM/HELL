package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import entities.items.CommonItem;
import entities.items.Item;
import factories.ItemFactory;
import repositories.HeroRepository;

import java.util.Arrays;

public class AddItemCommand extends CommandImpl {


    public AddItemCommand(ItemFactory itemFactory,
                          HeroRepository heroRepository,
                          String[] parameters) {
        super(parameters);
        this.setHeroRepository(heroRepository);
        this.setItemFactory(itemFactory);
    }

    @Override
    public String execute() {
        String itemType = Item.class.getSimpleName();

        String[] parameters = this.getParameters();
        String name = parameters[0];
        String heroName = parameters[1];
        String[] stats = Arrays.copyOfRange(parameters, 2, parameters.length);


        Item item = ((CommonItem) this.getItemFactory().create(itemType, name, heroName, stats));
        Hero hero = this.getHeroRepository().getByName(heroName);
        hero.addItem(item);

        return String.format(OutputMessages.ITEM_ADDED, name, heroName);
    }
}
