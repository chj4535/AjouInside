package com.example.ajouinside

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class GalleryAdapter(var context: Context, var expandableListView : ExpandableListView, var GalleryList:ArrayList<info_Gallery>) : BaseExpandableListAdapter(){
    override fun getGroup(galleryPosition: Int): String {
        return GalleryList[galleryPosition].galleryName
    }

    override fun isChildSelectable(galleryPosition: Int, boardPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(galleryPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.activity_gallerylist_gallery,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.galleryName)
        title?.text = getGroup(galleryPosition)
        expandableListView.expandGroup(galleryPosition)
//        btn_expand?.setOnClickListener {
//            if(expandableListView.isGroupExpanded(groupPosition))
//                expandableListView.collapseGroup(groupPosition)
//            else
//                expandableListView.expandGroup(groupPosition)
//            //Toast.makeText(context, getGroup(groupPosition),Toast.LENGTH_SHORT).show()
//        }
        return convertView
    }

    override fun getChildrenCount(galleryPosition: Int): Int {
        return GalleryList[galleryPosition].boardList.size
    }

    override fun getChild(galleryPosition: Int, boardPosition: Int): info_Board {
        return GalleryList[galleryPosition].boardList[boardPosition]
    }

    override fun getGroupId(galleryPosition: Int): Long {
        return galleryPosition.toLong()
    }

    override fun getChildView(galleryPosition: Int, boardPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.activity_gallerylist_board,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.boardName)
        title?.text = getChild(galleryPosition,boardPosition).boardName
        title?.setOnClickListener {
            Toast.makeText(context, getChild(galleryPosition,boardPosition).boardName,Toast.LENGTH_SHORT).show()
        }
        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return GalleryList.size
    }

}