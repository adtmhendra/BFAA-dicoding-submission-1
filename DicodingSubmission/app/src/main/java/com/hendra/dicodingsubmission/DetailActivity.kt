package com.hendra.dicodingsubmission

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // hiding action bar
        this.supportActionBar?.hide()

        val user = intent.getParcelableExtra(EXTRA_DATA) as? User

        tvName.text = user?.name.toString()
        tvUsername.text = user?.username.toString()
        tvCompany.text = user?.company.toString()
        tvLocation.text = user?.location.toString()
        tvFollowers.text = user?.followers.toString()
        tvFolowing.text = user?.following.toString()
        tvRepository.text = user?.repository.toString()
        Glide.with(this).load(user?.avatar).into(imgAvatar)
        Glide.with(this).load(user?.background).into(imgBackground)

        imgButtonBack.setOnClickListener(this)
        imgButtonEmail.setOnClickListener(this)
        btnFollow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.imgButtonBack  -> finish()
            R.id.btnFollow      -> Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show()
            R.id.imgButtonEmail -> {
                val email = "mailto:testemail@dicoding.submission1"
                val intentEmail = Intent(Intent.ACTION_VIEW, Uri.parse(email))
                startActivity(intentEmail)
            }
        }
    }
}