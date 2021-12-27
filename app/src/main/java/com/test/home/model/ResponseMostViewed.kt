package com.test.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseMostViewed(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("results")
	val results: ArrayList<ResultsItem>? = null,

	@field:SerializedName("num_results")
	val numResults: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
):Serializable

data class MediaMetadataItem(

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
):Serializable
data class ResultsItem(

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("media")
	val media: ArrayList<MediaItem>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("des_facet")
	val desFacet: ArrayList<String>? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("published_date")
	val publishedDate: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("byline")
	val byline: String? = null,

	@field:SerializedName("abstract")
	val abstract: String? = null

):Serializable
data class MediaItem(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("media-metadata")
	val mediaMetadata: ArrayList<MediaMetadataItem>? = null,

	@field:SerializedName("subtype")
	val subtype: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

):Serializable


/*package com.test.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResponseMostViewed(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("results")
	val results: ArrayList<ResultsItem>? = null,

	@field:SerializedName("num_results")
	val numResults: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
):Parcelable
{
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(ResultsItem::class.java.classLoader) as? ArrayList<ResultsItem>,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(copyright)
		parcel.writeValue(numResults)
		parcel.writeString(status)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseMostViewed> {
		override fun createFromParcel(parcel: Parcel): ResponseMostViewed {
			return ResponseMostViewed(parcel)
		}

		override fun newArray(size: Int): Array<ResponseMostViewed?> {
			return arrayOfNulls(size)
		}
	}
}

data class MediaMetadataItem(

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
):Parcelable
{
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(format)
		parcel.writeValue(width)
		parcel.writeString(url)
		parcel.writeValue(height)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<MediaMetadataItem> {
		override fun createFromParcel(parcel: Parcel): MediaMetadataItem {
			return MediaMetadataItem(parcel)
		}

		override fun newArray(size: Int): Array<MediaMetadataItem?> {
			return arrayOfNulls(size)
		}
	}
}

data class ResultsItem(

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("media")
	val media: ArrayList<MediaItem>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("des_facet")
	val desFacet: ArrayList<String>? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("published_date")
	val publishedDate: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("byline")
	val byline: String? = null,

	@field:SerializedName("abstract")
	val abstract: String? = null

):Parcelable
{
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(MediaItem::class.java.classLoader) as? ArrayList<MediaItem>,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(String::class.java.classLoader) as? ArrayList<String>,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Long::class.java.classLoader) as? Long,
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(source)
		parcel.writeString(type)
		parcel.writeString(title)
		parcel.writeString(uri)
		parcel.writeString(url)
		parcel.writeValue(id)
		parcel.writeString(publishedDate)
		parcel.writeString(updated)
		parcel.writeString(byline)
		parcel.writeString(abstract)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResultsItem> {
		override fun createFromParcel(parcel: Parcel): ResultsItem {
			return ResultsItem(parcel)
		}

		override fun newArray(size: Int): Array<ResultsItem?> {
			return arrayOfNulls(size)
		}
	}
}

data class MediaItem(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("media-metadata")
	val mediaMetadata: ArrayList<MediaMetadataItem>? = null,

	@field:SerializedName("subtype")
	val subtype: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	):Parcelable
{
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(MediaMetadataItem::class.java.classLoader) as? ArrayList<MediaMetadataItem>,
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(copyright)
		parcel.writeString(subtype)
		parcel.writeString(caption)
		parcel.writeString(type)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<MediaItem> {
		override fun createFromParcel(parcel: Parcel): MediaItem {
			return MediaItem(parcel)
		}

		override fun newArray(size: Int): Array<MediaItem?> {
			return arrayOfNulls(size)
		}
	}
}*/
