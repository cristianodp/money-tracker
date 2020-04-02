package com.cdp.moneytracker.repository.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.time.LocalDateTime


abstract class BaseEntity(
    @PrimaryKey(autoGenerate = true) @NonNull
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "creation_date")
    var creationDate: LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "modification_date")
    var modificationDate: LocalDateTime = LocalDateTime.now()
)