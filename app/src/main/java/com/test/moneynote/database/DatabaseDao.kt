package com.test.moneynote.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface DatabaseDao {

    @Insert
    fun newListItem(item: ListItem)

    @Update
    fun updateListItem(item: ListItem)

    @Query("DELETE FROM list_item_table")
    fun clearList()

    @Query("DELETE FROM list_item_table WHERE list_item_id = :key")
    fun deleteItem(key: Long)

    @Query("SELECT * FROM list_item_table ORDER BY list_item_id ASC")
    fun getAllListItem(): LiveData<List<ListItem>>

}



//@Insert
//fun insertQuizSet(quiz: QuizSet)
//
//@Update
//fun updateQuizSet(quiz: QuizSet)
//
//@Query("SELECT * from quiz_set_table WHERE quiz_set_id = :key")
//fun getQuizSet(key: Long): LiveData<QuizSet?>
//
//@Query("DELETE FROM quiz_set_table")
//fun clearQuizSetDataBase()
//
//@Query("DELETE FROM quiz_set_table WHERE quiz_set_id = :key")
//fun clearAQuizSet(key: Long)
//
//@Query("SELECT * FROM quiz_set_table ORDER BY quiz_set_id ASC LIMIT 1")
//fun getRecentQuizSet(): QuizSet?
//
//@Query("SELECT * FROM quiz_set_table ORDER BY quiz_set_id ASC")