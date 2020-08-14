package com.example.totorial.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.TABLE_NAME)
class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Int,

    @ColumnInfo(name = "user_name")
    var name: String,

    @ColumnInfo(name = "user_email")
    var email: String
) {
    companion object {
        const val TABLE_NAME: String = "user_table"
    }
}