package com.sendy.chatapp.ui.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import com.sendy.chatapp.R
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.android.synthetic.main.signup_options.view.*

class LandingPage : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.sendy.chatapp.R.layout.activity_landing_page)

        btnOtherSignUpOptions.setOnClickListener {
            alertDialogOptions()
        }
        loginLayout.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }

    private fun alertDialogOptions() {
        val builder = AlertDialog.Builder(this@LandingPage)
        builder.setTitle("Continue With")

        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.signup_options, null)
        dialogView.tvEmailOption.setOnClickListener {
            startActivity(Intent(this, EmailSignUp::class.java))
        }
        dialogView.tvFacebookOption.setOnClickListener {
            startActivity(Intent(this, FacebookSignUp::class.java))
        }
        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()
    }
}
