package main.javabasic.container;

/**
 * @author lee
 * @date 2020-09-09
 */
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere" + id;
    }
}
