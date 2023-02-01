package com.koko.basic;

/** Singleton is a design pattern that ensures that a class can only have one object.
 * need to follow
 * constructor should be private
 * Singletons can be used while working with databases. They can be used to create a connection pool to access the database while reusing the same connection for all the clients.
 */


class Database {
    //a reference to the object of the class. yha static
    private static Database dbObject;

    // this line ensure that object cant to create outside of class kyuki access specifier private hai
    private Database() {
    }
    // this method returns the reference to the only object of the class. Since the method static, it can be accessed using the class name.
    public static Database getInstance() {

        // create object if it's not already created
        if(dbObject == null) {
            dbObject = new Database();
        }

        // returns the singleton object
        return dbObject;
    }

    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}

class SingletonClass {
    public static void main(String[] args) {
        Database db1;

        // refers to the only object of Database
        db1= Database.getInstance();

        db1.getConnection();
    }
}

