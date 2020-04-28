package factories;

public interface ItemFactory<T> {

    T create(String itemType,
             String name,
             String heroName,
             String... parameters);
}
