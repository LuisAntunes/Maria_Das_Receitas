package com.example.mariadasreceitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_details).setOnClickListener {
            openDetailsActivity()
        }

        findViewById<Button>(R.id.show_dialog).setOnClickListener {
            showAppDialog()
        }
    }

    private fun openDetailsActivity() {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

    private fun showAppDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Receitas")
        builder.setMessage("Bela Receita")
        builder.apply {
            setPositiveButton("Guardar Receita") { _, _ ->
                Toast.makeText(this@MainActivity, "Receita Guardada", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancelar Receita") { _, _ ->
                Log.d(TAG, "Cancelado")
            }
        }
        builder.create().show()
    }


}