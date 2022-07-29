package com.play1xbet.sports.betting.sports.mvvmart.local.response

data class DataDemo(
    val `data`: List<Data>,
    val flag: String,
    val status: String


)

data class Data(
    val trans_amt: String,
    val trans_date: String,
    val trans_from: String,
    val trans_id: String,
    val trans_method: String,
    val trans_to: String

)

