package uz.akbarali.validator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uz.akbarali.mylibrary.MyValidator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = "Main1"
//        Log.d(TAG,"${MyValidator.isIpAddressValid("192.168.1.1")}" )
//        Log.d(TAG,"${MyValidator.isValidEmail("@basgeekall.com")}" )
        Log.d(TAG,"${MyValidator.isPhoneNumberValid("+984-125@323#")}" )
        Log.d(TAG,"${MyValidator.validateYear(2022)}" )
    }
}