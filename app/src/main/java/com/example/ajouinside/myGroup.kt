package com.example.ajouinside

class myGroup(name:String){
    var child:ArrayList<String>
    var groupName=String()
    init {
        this.groupName=name
        child=ArrayList()
    }
}