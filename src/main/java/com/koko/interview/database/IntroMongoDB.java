package com.koko.interview.database;

public class IntroMongoDB {

    /**
     * JSON Documents
     *  Javascript Object Notation - JSON
     *  ex:
     *  {
     *      field: value,
     *      field: value
     *  }
     *
     *  Best thing about JSON documents, that values can be of any type, strings , numeral, or other documents.
     *
     *  **Comparison with RDBMS:
     *
     *  ## In RDBMS, we can add many columns to one table. But when to use a new table.
     *  ## If there is a 1->many mapping found, its better to create a new table and store data and map with original table
     *  ## using an ID. Like user can have many hobbies, so hobbies are stored in separate table and joined with UserID.
     *
     *  Let's take a User table with columns id, name, cell, city, longitude, latitude.
     *
     *  1. RDBMS will store all values in separate columns.
     *     JSON Doc will store like a collection of objects, each object for a user.
     *     {
     *         "_id": 1,
     *         "name": "Leslie",
     *         ...
     *         "location": [
     *              latitude, longitude ]
     *     }
     *     Here, we can store location in one field.
     *
     *  2. For Hobbies, and job history, we will use separate tables in RDBMS.
     *      Here, we can add fields to our object.
     *      {
     *          ...
     *          "hobbies": [ array of hobbies ],
     *          "history": [    // array of objects
     *              {
     *                  "jobTitle": x,
     *                  "company": y
     *              }
     *              ]
     *      }
     *
     *  3. Add another user Ron with no location values.
     *      RDBMS will have to insert null in unknown column values. Extra space consumed to store null.
     *      Doc can either omit those fields, or add null.
     *
     *  4. Now, lets suppose we add a user with school history. No job history.
     *      RDBMS, we will have to either create a column named school , or add another table for school history.
     *      Creating a new column in Prod can be difficult and require approvals.
     *      Also, every row of user table have to be modified to store null in school column.
     *
     *      Doc will have no such issues. Object of new user can contain any new fields without affecting
     *      previous added objects. Docs have flexible schemas.
     *
     *
     *  **Terms related to RDBMS and JSON Doc.
     *
     *  1. Row maps to an object. Rows of multiple linked tables can also map to an object.
     *  2. Column map to a field.
     *  3. Table maps to a Collection. Group of objects.
     *  4. Join maps to Embedding. Rule of Thumb: Data that is accessed together should be stored together.
     *      Like above, hobbies and job history were need to be joined in RDBMS, but object can store all such values
     *      within itself.
     *  5. There is possibility of joining data from multiple objects in MongoDB.Ex: lookup functionality.
     *  6. Some NoSQL db support ACID transactions like MongoDB. Multi-document ACID transactions. Though, if you are
     *      updating multiple documents in one go, you may need to look on the design of your data model.
     *
     *
     *  **Features provided by DBaaS in MongoDB:
     *
     *  1. Hosts DB for us and keeps it updated with latest versions.
     *  2. MongoDB Atlas is the service.
     *  3. It provides MongoDB Query API which is a powerful tool to query DB.
     *      like db.inventory.find(
     *      { "name" :"Ron" })
     *
     *  4. It provides Atlas Lake to store data and perform analytics.
     *  5. Change Stream: Real time notifications to applications when changes are made on objects or collections.
     *  6. MongoDB Compass : to visualize and edit data from desktop.
     *  7. MongoDB Charts: To perform analytics to see data in graphs form.
     *
     *
     */
}
