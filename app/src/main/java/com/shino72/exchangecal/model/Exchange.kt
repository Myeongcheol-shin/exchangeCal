package com.shino72.exchangecal.model

import com.google.gson.annotations.SerializedName

data class Exchange(
    @SerializedName("result") val result : String,
    @SerializedName("cur_unit") val unit : String?,
    @SerializedName("ttb") val ttb : String?,
    @SerializedName("tts") val tts : String?,
    @SerializedName("deal_bas_r") val deal : String?,
    @SerializedName("cur_nm") val name : String?
)
