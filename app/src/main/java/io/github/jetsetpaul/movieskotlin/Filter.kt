package io.github.jetsetpaul.movieskotlin

import java.io.Serializable

/**
 * Created by pauljoiner on 8/20/18.
 */
class Filter(val category: String, val subfilters: List<String>): Serializable