package com.example.hamodi.DataTables;

import android.provider.BaseColumns;

public class TablesString {

    public TablesString() {
    }
    //region Product Table
    public static class ProductTable implements BaseColumns {
        public static final String TABLE_PRODUCT = "Game";
        public static final String COLUMN_PRODUCT_NAME = "GameName";
        public static final String COLUMN_PRODUCT_DESCRIPTION = "Description";
        public static final String COLUMN_PRODUCT_IMAGE = "GameImage";
        public static final String COLUMN_PRODUCT_STOCK = "Stock";
        public static final String COLUMN_PRODUCT_SALEPRICE = "SalePrice";
        public static final String COLUMN_PRODUCT_BUYPRICE = "GamePrice";

    }
    //endregion

    //region Cart Table
    public static class CartTable implements BaseColumns {
        public static final String TABLE_CART = "Cart";
        public static final String COLUMN_PRODUCT_ID = "PID";
        public static final String COLUMN_PRODUCT_QUANTITY = "Quantity";
        public static final String COLUMN_USER_ID = "UID";


    }
    //endregion

    //region Sale Table
    public static class SaleTable implements BaseColumns {
        public static final String TABLE_SALE = "SALE";
        public static final String COLUMN_SALE_PROD_ID = "PID";
        public static final String COLUMN_SALE_USER_ID = "UID";
        public static final String  COLUMN_SALE_PRICE= " SalePrice";
        public static final String  Buy_SALE_PRICE= " BuyPrice";

    }
    //endregion
}
