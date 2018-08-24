package io.github.jetsetpaul.movieskotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/**
 * Created by pauljoiner on 8/20/18.
 */
@Parcelize
class Filter(val category: String, val subfilters: List<String>): Parcelable