package com.test.moneynote.database

import androidx.room.*

@Entity(tableName = "list_item_table")
data class ListItem (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_item_id")
    val listItemId: Long = 0L,

    @ColumnInfo(name = "list_item_value")
    var value: Long = 0L,

    @ColumnInfo(name = "list_item_description")
    var description: String = "",

    @ColumnInfo(name = "list_item_date")
    var date: String = "",
)