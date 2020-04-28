import entities.heroes.Barbarian;
import entities.heroes.Hero;
import entities.items.CommonItem;
import entities.items.Item;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Barbarian("Ivan");
        Item item = new CommonItem("Knife",
                0, 10, 0, 0, 30);
        hero.addItem(item);

        System.out.print(hero.toString());
    }
}