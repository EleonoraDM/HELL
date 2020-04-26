package factories;

public interface ItemFactory<T> {

    T create(String name,
             String heroName,
             String... parameters);
}
