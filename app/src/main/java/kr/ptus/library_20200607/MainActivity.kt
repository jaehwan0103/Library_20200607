package kr.ptus.library_20200607

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()

    }


    override fun setupEvents() {

        callBtn.setOnClickListener {
            val myUri = Uri.parse("tel:${phoneNumTxt.text}")
            val myIntent = Intent(Intent.ACTION_CALL,myUri)

            startActivity(myIntent)
        }

        proflieImage.setOnClickListener {
            val myIntent = Intent(mContext,ViewProfileImageActivity::class.java)
            startActivity(myIntent)

        }


    }

    override fun setValues() {

        Glide.with(mContext).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQs5Dvhb_t65a84jxNdImgtkwb9TupgUG9Ww2xRxi7NeU3bPaui&usqp=CAU").into(proflieImage)

    }
}
