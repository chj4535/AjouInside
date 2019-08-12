package com.example.ajouinside

class info_Gallery(name:String, id:String){
    var galleryName=String()
    var galleryId=String()
    var boardList:ArrayList<info_Board>
    init {
        this.galleryName=name
        this.galleryId=id
        this.boardList=ArrayList()
    }
}