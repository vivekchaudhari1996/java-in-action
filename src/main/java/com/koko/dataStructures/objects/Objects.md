## Objects



1. This class consists of **static utility methods** for operating on objects.

2. These utilities include **null-safe or null-tolerant methods** for computing the hash code of an object.



## Class Definition



1. **Class**

`public final class Objects`

2. **Methods**

    1. static boolean **equals**(Object a, Object b)

        1. if both arguments are null, true is returned.

        2. `(a == b) || (a != null && a.equals(b))`

        3. Equality is determined by using the equals method of the first argument.

    2. static boolean **deepEquals**(Object a, Object b)

    3. static int **hashCode**(Object o)

        1. Returns the hash code of a non-null argument and **0 for a null argument**.

    4. static int **hash**(Object... values)

        1. Generates a hash code for a **sequence of input values**.

        2. The hash code is generated as if all the input values were placed into an array,

        3. and that array were hashed by **calling Arrays.hashCode(Object[])**.

        4. For overriding hashCode method of custom class.

        ```

        @Override public int hashCode() {

          return Objects.hash(x, y, z);

        }

        ```

    5. static String **toString**(Object o)

        1. Internally calls `String.valueOf(o)`

        2. Returns the result of calling toString for a non-null argument and "null" for a null argument.

    6. static String **toString**(Object o, String nullDefault)

        1. Returns the result of calling toString on the first argument if the first argument is not null and returns the second argument otherwise.

    7. static <T> int **compare**(T a, T b, Comparator<? super T> c)

        1. Returns 0 if the arguments are identical and

        2. c.compare(a, b) otherwise.

    8. static <T> T **requireNonNull**(T obj)

        1. This method is designed primarily for doing **parameter validation** in methods and constructors, as demonstrated below:

       ```

       public Foo(Bar bar) {

           this.bar = Objects.requireNonNull(bar);

       }

       public static <T> T requireNonNull(T obj) {

        if (obj == null)

            throw new NullPointerException();

        return obj;

        }

       ```

    9. static <T> T **requireNonNull**(T obj, String message)

        1. Checks that the specified object reference is not null and throws a **customized NullPointerException** if it is.

        ```

        public static <T> T requireNonNull(T obj, String message) {

        if (obj == null)

            throw new NullPointerException(message);

        return obj;

        }

        ```

    10. static boolean **isNull**(Object obj)

        1. Returns true if the provided reference is null otherwise returns false.

    11. static boolean **nonNull**(Object obj)

        1. Returns true if the provided reference is non-null otherwise returns false.