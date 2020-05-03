package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import entities.items.CommonItem;
import entities.items.Item;
import factories.ItemFactory;
import repositories.HeroRepository;

import java.util.Arrays;

public class AddItemCommand implements Command {
    private ItemFactory itemFactory;
    private HeroRepository heroRepository;

    private String[] params;


    public AddItemCommand(ItemFactory itemFactory, HeroRepository heroRepository, String...parameters) {
        this.itemFactory = itemFactory;
        this.heroRepository = heroRepository;
        this.params = parameters;
    }

    @Override
    public String execute() {
        String itemType = Item.class.getSimpleName();
        String name = this.params[0];
        String heroName = this.params[1];
        String[] stats = Arrays.copyOfRange(this.params, 2, this.params.length);


        Item item = ((CommonItem) this.itemFactory.create(itemType, name, heroName, stats));
        Hero hero = this.heroRepository.getByName(heroName);
        hero.addItem(item);

        return String.format(OutputMessages.ITEM_ADDED, name, heroName);
    }
}
