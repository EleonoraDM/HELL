package commands;

import factories.HeroFactory;
import factories.ItemFactory;
import repositories.HeroRepository;

public abstract class CommandImpl implements Command {
    private HeroFactory heroFactory;
    private HeroRepository heroRepository;

    private ItemFactory itemFactory;

    private String[] parameters;

    protected CommandImpl() {
    }

    protected CommandImpl(String[] parameters) {
        this.parameters = parameters;
    }

    void setHeroFactory(HeroFactory heroFactory) {
        this.heroFactory = heroFactory;
    }

    void setHeroRepository(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    void setItemFactory(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    HeroFactory getHeroFactory() {
        return this.heroFactory;
    }

    HeroRepository getHeroRepository() {
        return this.heroRepository;
    }

    ItemFactory getItemFactory() {
        return this.itemFactory;
    }

    public String[] getParameters() {
        return this.parameters;
    }
}
