package com.ubaya.a160419081_myrecipe.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.model.RecipeDatabase
import java.lang.Exception

val DB_NAME = "recipedb"

fun buildDb(context: Context):RecipeDatabase{
    val db = Room.databaseBuilder(context, RecipeDatabase::class.java, DB_NAME).fallbackToDestructiveMigration().build()
    return db
}

fun ImageView.loadImage(url:String, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })

}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(v:ImageView, url:String, pb:ProgressBar){
    v.loadImage(url, pb)
}

