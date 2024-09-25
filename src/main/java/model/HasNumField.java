package model;

/**
 * Interface represents an entity that has a numeric field. This interface can be implemented
 * by classes that need to expose a numeric field and its name, allowing operations such as sorting
 * or filtering based on this numeric value.
 *
 * @param <T> the type of the implementing class
 */
public interface HasNumField<T> {

    /**
     * Returns the value of the numeric field associated with the implementing class.
     *
     * @return the numeric value
     */
    int getNumField();

    /**
     * Returns the name of the numeric field associated with the implementing class.
     *
     * @return the name of the numeric field as a string
     */
    String getNumFieldName();
}
