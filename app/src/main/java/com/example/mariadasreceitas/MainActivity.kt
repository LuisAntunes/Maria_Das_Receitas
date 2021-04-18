package com.example.mariadasreceitas

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"
private  const val REQUEST_IMAGE_CAPTURE = 100

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_camera).setOnClickListener {
            openNativeCamera()
        }

        findViewById<Button>(R.id.open_details).setOnClickListener {
            openDetailsActivity()
        }

        findViewById<Button>(R.id.show_dialog).setOnClickListener {
            showAppDialog()
        }

        findViewById<Button>(R.id.open_profile).setOnClickListener {
            openProfileActivity()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.imageView).setImageBitmap(imageBitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openNativeCamera(){ //Calling this method will open the default camera application.
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }

    private fun openDetailsActivity(){ //Calling this method will open a new activity.

        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

    private fun showAppDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Receitas")
        builder.setMessage("Bela Receita")
        builder.apply {
            setPositiveButton("Guardar") { _, _ ->
                Toast.makeText(this@MainActivity, "Receita Guardada", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancelar") { _, _ ->
                Log.d(TAG, "Cancelado")
            }
        }
        builder.create().show()
    }
/*
    private fun showAppSnackbar() {
        Snackbar.make(
                findViewById<ConstraintLayout>(R.id.container),
                R.string.snackbar_message,
                Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action_thanks) {
                    Toast.makeText(this@MainActivity, R.string.snackbar_action_thanks_selected, Toast.LENGTH_SHORT).show()
                }
                .show()
    }*/
    private fun openProfileActivity(){ //Calling this method will open a new activity.

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}