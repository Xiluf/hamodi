package com.example.hamodi.Classes;

import static com.example.hamodi.DataTables.TablesString.ProductTable.*;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Product implements sqlInterface {

    //region Attribute
    protected int pid;


    protected String GameName;
    protected String ProdDisc;
    protected int Quantity;
    protected double saleprice;
    protected double Gameprice;
    protected byte[] imageByte;
    //endregion

    //region Constructors
    public Product(String GameName,String ProdDisc,int quantity,double saleprice,double Gameprice,byte[] image){
        this.saleprice=saleprice;
        this.Gameprice=Gameprice;
        this.GameName=GameName;
        this.ProdDisc=ProdDisc;
        this.Quantity=quantity;
        this.imageByte = image;
    }

    public Product() {

    }

    public Product(Product p) {
        pid = p.getPid();
        Gameprice = p.getGameprice();
        GameName = p.getGameName();
        saleprice = p.getSaleprice();
        ProdDisc = p.getProdDisc();
        Quantity = p.getQuantity();
        imageByte = p.getImageByte();
    }
    //endregion

    //region Add,Delete,Update,Select Sql
    @Override
    public long Add(SQLiteDatabase db) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, GameName);
        values.put(COLUMN_PRODUCT_DESCRIPTION, ProdDisc);
        values.put(COLUMN_PRODUCT_BUYPRICE, Gameprice);
        values.put(COLUMN_PRODUCT_SALEPRICE, saleprice);
        values.put(COLUMN_PRODUCT_STOCK, Quantity);
        values.put(COLUMN_PRODUCT_IMAGE, imageByte);


// Insert the new row, returning the primary key value of the new row
        return db.insert(TABLE_PRODUCT, null, values);

    }

    @Override
    public int Delete(SQLiteDatabase db, int id) {
        String selection = BaseColumns._ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = {id+""};
// Issue SQL statement.
        return db.delete(TABLE_PRODUCT, selection, selectionArgs);

    }

    @Override
    public int Update(SQLiteDatabase db, int id) {
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, GameName);
        values.put(COLUMN_PRODUCT_DESCRIPTION, ProdDisc);
        values.put(COLUMN_PRODUCT_BUYPRICE, Gameprice);
        values.put(COLUMN_PRODUCT_SALEPRICE, saleprice);
        values.put(COLUMN_PRODUCT_STOCK, Quantity);
        values.put(COLUMN_PRODUCT_IMAGE, imageByte);

// Which row to update, based on the title
        String selection = BaseColumns._ID + " LIKE ?";
        String[] selectionArgs = { id+"" };

        return  db.update(
                TABLE_PRODUCT,
                values,
                selection,
                selectionArgs);

    }


    @Override
    public Cursor Select(SQLiteDatabase db) {
        String[] projection = {
                BaseColumns._ID,
                COLUMN_PRODUCT_NAME,
                COLUMN_PRODUCT_DESCRIPTION,
                COLUMN_PRODUCT_IMAGE,
                COLUMN_PRODUCT_STOCK,
                COLUMN_PRODUCT_SALEPRICE,
                COLUMN_PRODUCT_BUYPRICE
        };

// How you want the results sorted in the resulting Cursor
        Cursor c = db.query(TABLE_PRODUCT,
                projection,
                null,
                null,
                null,
                null,
                null);
        return c;
    }
    public Cursor SelectById(SQLiteDatabase db,String id) {
        String[] projection = {
                BaseColumns._ID,
                COLUMN_PRODUCT_NAME,
                COLUMN_PRODUCT_DESCRIPTION,
                COLUMN_PRODUCT_IMAGE,
                COLUMN_PRODUCT_STOCK,
                COLUMN_PRODUCT_SALEPRICE,
                COLUMN_PRODUCT_BUYPRICE
        };
        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = {id};

        Cursor c = db.query(
                TABLE_PRODUCT,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null  );
        return c;
    }



    //endregion

    //region Setter and Getter
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getProdDisc() {
        return ProdDisc;
    }

    public void setProdDisc(String prodDisc) {
        ProdDisc = prodDisc;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public double getGameprice() {
        return Gameprice;
    }

    public void setGameprice(double gameprice) {
        Gameprice = gameprice;
    }

    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    //endregion
    @Override
    public String toString(){
        return GameName + " \n price: " + Gameprice;
    }
}
