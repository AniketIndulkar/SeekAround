package com.androidvoyage.colorpalettes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.provider.MediaStore



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val openGalleryIntent= Intent()
            openGalleryIntent.action=android.content.Intent.ACTION_GET_CONTENT
            openGalleryIntent.type="image/*"
            startActivityForResult(openGalleryIntent,1111)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getColorPalette(bitmap : Bitmap) : Palette = Palette.from(bitmap).generate();

    fun generateColorPalette(bitmap : Bitmap){
        Palette.from(bitmap).generate {

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode ==1111 && resultCode==Activity.RESULT_OK){
            if (data!=null){
                val imageUri=data.data;
                if (imageUri!=null){
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                    val colrPalette : Palette=getColorPalette(bitmap)
                    colrPalette.darkMutedSwatch

                    println(colrPalette.darkMutedSwatch!!.bodyTextColor)
                    println(colrPalette.darkVibrantSwatch!!.titleTextColor)
                    println(colrPalette.dominantSwatch)
                    println(colrPalette.lightMutedSwatch)
                    println(colrPalette.lightVibrantSwatch)
                    println(colrPalette.mutedSwatch)
                    println(colrPalette.swatches)
                }
            }
        }
    }
}
