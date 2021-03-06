package com.ruheng.suiyue.data.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Avatars(@SerializedName("small")
                   val small: String = "",
                   @SerializedName("large")
                   val large: String = "",
                   @SerializedName("medium")
                   val medium: String = "") : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(small)
        writeString(large)
        writeString(medium)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Avatars> = object : Parcelable.Creator<Avatars> {
            override fun createFromParcel(source: Parcel): Avatars = Avatars(source)
            override fun newArray(size: Int): Array<Avatars?> = arrayOfNulls(size)
        }
    }
}