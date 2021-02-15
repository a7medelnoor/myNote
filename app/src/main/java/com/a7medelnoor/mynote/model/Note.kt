package com.a7medelnoor.mynote.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "noteTable")
@kotlinx.android.parcel.Parcelize
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitleName: String,
    val noteBody: String
):Parcelable