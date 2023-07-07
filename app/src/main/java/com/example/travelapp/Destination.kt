package com.example.travelapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Destination(
    val name: String,
    val description: String,
    val photo: Int,
    val location: String,
    val price: String,
    val distace: String

):Parcelable
