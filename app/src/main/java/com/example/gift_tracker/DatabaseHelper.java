package com.example.gift_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat
    private static final String LOG = "dbHelperDebug";

    // Singleton Instance Variable
    private static DatabaseHelper dbInstance;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "giftTracker";

    // Table Names
    private static final String TABLE_RECIPIENT = "recipient";
    private static final String TABLE_GIFT = "gift";

    // Common Columns
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "name";

    // Recipient Table Columns

    // Gift Table Columns
    private static final String KEY_DESCRIPTION = "description";


    // Constructors (set to private because using Singleton
    private DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private DatabaseHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }


    // Recipient Table Create
    private static final String CREATE_TABLE_RECIPIENT = "CREATE TABLE " + TABLE_RECIPIENT + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_Name + " TEXT"
            + ")";


    // Gift Table Create
    private static final String CREATE_TABLE_GIFT = "CREATE TABLE " + TABLE_GIFT + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_Name + " TEXT,"
            + KEY_DESCRIPTION + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RECIPIENT);
        db.execSQL(CREATE_TABLE_GIFT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIFT);

        onCreate(db);
    }

    // ************************ Singleton Instance ************************ //

    public static synchronized DatabaseHelper getInstance(Context context) {
        if(dbInstance == null ) {
            dbInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

    // Update test

    // ************************ Recipient table functions ************************ //

    // Create
    public long addRecipient(Recipient recipient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, recipient.getName());

        long recipient_id = db.insert(TABLE_RECIPIENT, null, values);

        db.close();

        return recipient_id;
    }

    public long addGift(Gift gift) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, gift.getName());
        values.put(KEY_DESCRIPTION, gift.description);

        long gift_id = db.insert(TABLE_GIFT, null, values);

        db.close();

        return  gift_id;
    }

    // Read
    public Recipient getRecipient(long recipient_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_RECIPIENT + " WHERE " + KEY_ID + " = " + recipient_id;

        Cursor c = db.rawQuery(query, null);

        if(c != null) {
            c.moveToFirst();
        }

        Recipient recipient = new Recipient(
                //c.getInt(c.getColumnIndex(KEY_ID)),
                c.getString(c.getColumnIndex(KEY_Name))
        );

        c.close();

        return recipient;
    }

    public Gift getGift(long gift_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_GIFT + " WHERE " + KEY_ID + "=" + gift_id;

        Cursor c = db.rawQuery(query, null);

        if(c != null) {
            c.moveToFirst();
        }

        Gift gift = new Gift(
                c.getString(c.getColumnIndex(KEY_Name)),
                c.getString(c.getColumnIndex(KEY_DESCRIPTION))
        );

        c.close();

        return gift;
    }

    // Retrieve all records
    public ArrayList<Recipient> getAllRecipients() {
        ArrayList<Recipient> recipients = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_RECIPIENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                Recipient r = new Recipient(
                        //c.getInt(c.getColumnIndex(KEY_ID)),
                        c.getString(c.getColumnIndex(KEY_Name))
                );

                recipients.add(r);
            } while (c.moveToNext());
        }

        db.close();

        return recipients;
    }

    public ArrayList<Gift> getAllGifts() {
        ArrayList<Gift> gifts = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_GIFT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                Gift gift = new Gift(
                        c.getString(c.getColumnIndex(KEY_Name)),
                        c.getString(c.getColumnIndex(KEY_DESCRIPTION))
                );
                gifts.add(gift);
            } while (c.moveToNext());
        }

        db.close();

        return gifts;
    }

    // Record Count
    public int getRecipientCount() {
        String query = "SELECT * FROM " + TABLE_RECIPIENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        int count = c.getCount();

        c.close();

        return count;
    }

    public int getGiftCount() {
        String query = "SELECT * FROM " + TABLE_GIFT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        int count = c.getCount();

        c.close();

        return count;
    }

    // Update
    public int updateRecipient(Recipient recipient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_Name, recipient.getName());

        return db.update(TABLE_RECIPIENT, contentValues, KEY_ID + " = ?", new String[] {String.valueOf(recipient.getId())});
    }

    public int updateGift(Gift gift) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_Name, gift.getName());
        contentValues.put(KEY_DESCRIPTION, gift.getDescription());

        return db.update(TABLE_GIFT, contentValues, KEY_ID + " = ?", new String[] {String.valueOf(gift.getId())});
    }

    // Delete
    public void deleteRecipient(Recipient recipient, boolean delete_all_tags) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_RECIPIENT, KEY_ID + " = ?", new String[] {String.valueOf(recipient.getId())});
    }

    public void deleteGift(Gift gift, boolean delete_all_tags) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_GIFT, KEY_ID + " = ? ", new String[] {String.valueOf(gift.getId())});
    }

    public void deleteAllRecipientRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_RECIPIENT);
    }

    public void deleteAllGiftRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_GIFT);
    }


}
