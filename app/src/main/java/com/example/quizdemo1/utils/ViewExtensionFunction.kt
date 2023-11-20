package com.example.quizdemo1.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.location.LocationManager
import android.os.Build
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quizdemo1.R
import java.security.Permissions
import java.util.*

fun AppCompatActivity.statusBar() {
    window.apply {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                attributes.layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            }
        } else {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            statusBarColor = Color.TRANSPARENT
        }
    }
}

fun checkGpsPermission(context: Context): Boolean {
    val locationManager: LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    var gpsEnabled = false
    var networkEnabled = false
    try {
        gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
    try {
        networkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }

    var gpsAndNetworkEnable = false
    if (gpsEnabled && networkEnabled) {
        gpsAndNetworkEnable = true
    }
    return gpsAndNetworkEnable
}

fun AppCompatActivity.fullScreen(){
    // For Using Full Screen--------------------------------------------------------------------
    //window.setFlags(512, 512)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.navigationBarColor = this.resources.getColor(R.color.black)
        window.statusBarColor = this.resources.getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        //window.decorView.systemUiVisibility = View.STATUS_BAR_HIDDEN
    }
    //------------------------------------------------------------------------------------------
}

fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
    val win = activity.window
    val winParams = win.attributes
    if (on) {
        winParams.flags = winParams.flags or bits
    } else {
        winParams.flags = winParams.flags and bits.inv()
    }
    win.attributes = winParams
}
fun AppCompatActivity.statusBarTransparent() {
    if (Build.VERSION.SDK_INT in 19..20) {
        setWindowFlag(
            this,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            true
        )
    }
    if (Build.VERSION.SDK_INT >= 19) {
        this.window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
    if (Build.VERSION.SDK_INT >= 21) {
        setWindowFlag(
            this,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            false
        )
        this.window.statusBarColor = Color.TRANSPARENT
    }
}
/*fun checkLocationPermission(context: Context): Boolean {
    var granted = false
    val permissions = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    Permissions.check(context, permissions, null, null, object : Permissions() {
        override fun onGranted() {
            granted = true
        }

        override fun onDenied(context: Context?, deniedPermissions: java.util.ArrayList<String>?) {
            granted = false
            super.onDenied(context, deniedPermissions)
        }
    })
    return granted
}*/

fun Fragment.fullScreen(){
    val window = activity?.window
    // For Using Full Screen--------------------------------------------------------------------
    //window.setFlags(512, 512)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
       // window?.navigationBarColor = this.resources.getColor(R.color.black)
        window?.statusBarColor = this.resources.getColor(R.color.black)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        //window.decorView.systemUiVisibility = View.STATUS_BAR_HIDDEN
    }
    //------------------------------------------------------------------------------------------
}
@SuppressLint("ResourceAsColor")
fun Fragment.statusBarTransparent() {
    if (Build.VERSION.SDK_INT in 19..33) {
        setWindowFlag(
            requireActivity(),
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            true
        )
    }
    if (Build.VERSION.SDK_INT >= 19) {
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
    if (Build.VERSION.SDK_INT >= 21) {
        setWindowFlag(
            requireActivity(),
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            false
        )
        requireActivity().window.statusBarColor = R.color.black
    }
}
fun myLog(string :String){
    Log.e("Roopal===",string)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


}

fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


}
fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


}
fun EditText.getValue():String =this.text.toString().trim()

fun TextView.getValue():String =this.text.toString().trim()


fun AppCompatActivity.statusBarTransparentWithWhite() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }
}


fun getDate(timestamp: Long) :String {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = timestamp * 1000L
    val date = DateFormat.format("dd/MM/yyyy",calendar).toString()
    return date
}
