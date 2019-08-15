package com.example.ajouinside

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_gallery_popularity_ranking.*
import kotlinx.android.synthetic.main.activity_gallerylist.*

class GalleryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_view)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


        var galleryList = ArrayList<info_Gallery>()
        var gallery = info_Gallery("갤러리명1", "galleryId1")
        var board1 = info_Board("게시글1", "board1")
        var board2 = info_Board("게시글2", "board2")
        var board3 = info_Board("게시글3", "board3")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명2", "galleryId2")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명3", "galleryId3")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명4", "galleryId4")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명5", "galleryId5")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)
        gallery = info_Gallery("갤러리명6", "galleryId6")
        gallery.boardList.add(board1)
        gallery.boardList.add(board2)
        gallery.boardList.add(board3)
        galleryList.add(gallery)

        gallery_listview.setAdapter(GalleryBoardAdapter(this, gallery_listview, galleryList))
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}