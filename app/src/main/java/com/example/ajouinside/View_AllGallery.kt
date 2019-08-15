package com.example.ajouinside

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_gallerylist.*
import kotlinx.android.synthetic.main.activity_maintoolbar.*

class View_AllGallery : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_allgallery)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar_Title.text="갤러리 전체보기"
        setSupportActionBar(toolbar)

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        }

        var galleryList = ArrayList<info_Gallery>()
        var gallery = info_Gallery("갤러리명1","galleryId1")
        var board1 = info_Board("게시글1","board1")
        var board2 = info_Board("게시글2","board2")
        var board3 = info_Board("게시글3","board3")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명2","galleryId2")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명3","galleryId3")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명4","galleryId4")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명5","galleryId5")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명6","galleryId6")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)

        gallery_listview.setAdapter(GalleryBoardAdapter(this,gallery_listview,galleryList))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item)
    }
}