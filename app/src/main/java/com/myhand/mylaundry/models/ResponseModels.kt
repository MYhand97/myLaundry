package com.myhand.mylaundry.models

class ResponseModels{
    var kode: Int ?= 0
    var pesan: String ?= null
    var data: List<DataModels> ?= null

    constructor(kode: Int?, pesan: String?, data: List<DataModels>?) {
        this.kode = kode
        this.pesan = pesan
        this.data = data
    }
}