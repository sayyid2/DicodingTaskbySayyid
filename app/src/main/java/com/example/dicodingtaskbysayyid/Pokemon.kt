package com.example.dicodingtaskbysayyid

import android.os.Parcelable
import android.provider.ContactsContract.Contacts.Photo
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pokemon(
    val name:String,
    val description:String,
    val picture: String
):Parcelable
