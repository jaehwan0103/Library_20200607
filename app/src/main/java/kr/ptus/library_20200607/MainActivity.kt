package kr.ptus.library_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    Toast.makeText(mContext,"권한이 거부되어 통화를 할 수 없습니다.", Toast.LENGTH_SHORT).show()

                }

            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener).setDeniedMessage("거절되면 통화할 수 없으니 [설정]에서 권한을 허가해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE).check()

        }

        proflieImage.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)

        }


    }

    override fun setValues() {

        Glide.with(mContext)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQs5Dvhb_t65a84jxNdImgtkwb9TupgUG9Ww2xRxi7NeU3bPaui&usqp=CAU")
            .into(proflieImage)

    }
}
