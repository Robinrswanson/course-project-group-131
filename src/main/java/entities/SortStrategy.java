package entities;

public interface SortStrategy {
    // This strategy for all the different types of sort, as strategy allows for a switch at runtime of the
    // algorithm used, so you can sort though multiple different attributes at once.
    void sort();

}
