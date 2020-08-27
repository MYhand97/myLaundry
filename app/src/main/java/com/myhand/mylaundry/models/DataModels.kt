package com.myhand.mylaundry.models

class DataModels{
    var id:Int ?= 0
    var nama:String ?= null
    var alamat:String ?= null
    var notelp:String ?= null

    constructor(id: Int?, nama: String?, alamat: String?, notelp: String?) {
        this.id = id
        this.nama = nama
        this.alamat = alamat
        this.notelp = notelp
    }
}