package com.example.ajouinside

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_gallery_popularity_ranking.*
import kotlinx.android.synthetic.main.activity_gallerylist.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val FINISH_INTERVAL_TIME:Long = 2000;
    var backPressedTime:Long = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        var DataList = ArrayList<myGroup>()
        var temp = myGroup("인기순위")
        temp.child.add("인기 갤러리1")
        temp.child.add("인기 갤러리2")
        temp.child.add("인기 갤러리3")
        DataList.add(temp)

        expand_list.setAdapter(ExpandAdapter(this,expand_list,DataList))

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

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            var tempTime:Long = System.currentTimeMillis()
            var intervalTime:Long = tempTime-backPressedTime;

            if(0<=intervalTime && FINISH_INTERVAL_TIME>= intervalTime){
                finishAffinity()
                System.runFinalization()
                System.exit(0);
            }
            else{
                backPressedTime = tempTime
                Toast.makeText(this,"한번 더 뒤로가기 시, 종료됩니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_menu_viewall -> {
                val nextIntent = Intent(this,View_AllGallery::class.java)
                startActivity(nextIntent)
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
