package com.example.chris.studygroup;

/**
 * Created by DJE66 on 12/06/2016.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler_Group extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "Group";
    private static final String KEY_PH_NO = "Group Description";
    private static final String Leader_ID ="Leader ID";
    private static final String User_ID1 ="User ID 1";
    private static final String User_ID2="User ID 2";
    private static final String User_ID3 ="User ID 3";
    private static final String User_ID4="User ID 4";
    private static final String User_ID5 ="User ID 5";
    private static final String is_FULL ="Is Full";
    private static final String INDEX ="Index";
    private static final String SUBJECT="Subject";


    public DataBaseHandler_Group(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")"+Leader_ID + " TEXT,"+ User_ID1+" TEXT,"+ User_ID2+" TEXT,"+ User_ID3+" TEXT,"+ User_ID4+" TEXT,"+ User_ID5+" TEXT,"+is_FULL+" TEXT,"+INDEX+" TEXT"+SUBJECT;
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(groupdata contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getGroupName()); // Contact Name
        values.put(KEY_PH_NO, contact.getGroupDescription()); // Contact Phone
        values.put(Leader_ID, contact.getLeader());
        int user[]=contact.getUsers();
        values.put(User_ID1, user[0]);
        values.put(User_ID2, user[1]);
        values.put(User_ID3, user[2]);
        values.put(User_ID4, user[3]);
        values.put(User_ID5, user[4]);
        values.put(is_FULL, contact.isFull);
        values.put(INDEX, contact.index);
        values.put(SUBJECT, contact.getSubject());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    groupdata getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO, Leader_ID, User_ID1, User_ID2, User_ID3, User_ID4, User_ID5, is_FULL, INDEX, SUBJECT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        groupdata contact = new groupdata(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)),Integer.parseInt(cursor.getString(5)),Integer.parseInt(cursor.getString(6)),Integer.parseInt(cursor.getString(7)),Integer.parseInt(cursor.getString(8)),Integer.parseInt(cursor.getString(10)),Integer.parseInt(cursor.getString(9)),cursor.getString(11));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<groupdata> getAllContacts() {
        List<groupdata> contactList = new ArrayList<groupdata>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                groupdata contact = new groupdata();
                contact.setGroupid(Integer.parseInt(cursor.getString(0)));
                contact.setGroupname(cursor.getString(1));
                contact.setGroupDescription(cursor.getString(2));
                contact.addLeader(Integer.parseInt(cursor.getString(3)));
                int user[]=new int[5];
                user[0]=Integer.parseInt(cursor.getString(4));
                user[1]=Integer.parseInt(cursor.getString(5));
                user[2]=Integer.parseInt(cursor.getString(6));
                user[3]=Integer.parseInt(cursor.getString(7));
                user[4]=Integer.parseInt(cursor.getString(8));
                contact.setIsFull(Integer.parseInt(cursor.getString(9)));
                contact.setIndex(Integer.parseInt(cursor.getString(10)));
                contact.setSubject(cursor.getString(11));









                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(groupdata contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getGroupName());
        values.put(KEY_PH_NO, contact.getGroupDescription());
        values.put(Leader_ID, contact.getLeader());
        int user[]=contact.getUsers();
        values.put(User_ID1, user[0]);
        values.put(User_ID2, user[1]);
        values.put(User_ID3, user[2]);
        values.put(User_ID4, user[3]);
        values.put(User_ID5, user[4]);
        values.put(is_FULL, contact.isFull);
        values.put(INDEX, contact.index);
        values.put(SUBJECT, contact.getSubject());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getGroupid()) });
    }

    // Deleting single contact
    public void deleteContact(groupdata contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getGroupid()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
