package uz.akbarali.validator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import uz.akbarali.materiallibrary.MaterialLibrary
import uz.akbarali.mylibrary.MyValidator
import uz.akbarali.validator.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val languages = resources.getStringArray(R.array.Languages)
        val spinner = findViewById<Spinner>(R.id.spread_inside)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter



            binding.submitBtn.setOnClickListener {
                MaterialLibrary().materialDialog(this,"Akbarali","Ber","dsd","sdfs")


                var isHave = true
                if (!MyValidator.isPasswordMatching(
                        binding.password.text.toString(),
                        binding.rePassword.text.toString()
                    )
                ) {
                    binding.rePassword.error = "Password Not matching"
                    isHave = false
                }
                if (!MyValidator.isValidEmail(binding.email.text.toString())) {
                    binding.email.error = "Invalid email address"
                    isHave = false
                }
                if (!MyValidator.validateSpinner(binding.spreadInside, "djfn")) {
                    isHave = false
                }
                if (!MyValidator.isIpAddressValid(binding.address.text.toString())) {
                    binding.address.error = "Invalid IP Address"
                    isHave = false
                }
                if (!MyValidator.isPhoneNumberValid(binding.numberPhone.text.toString())) {
                    binding.numberPhone.error = "Invalid phone number"
                    isHave = false
                }
                if (!MyValidator.isValidZipCode(binding.zipCode.text.toString())) {
                    binding.zipCode.error = "Invalid zip code"
                    isHave = false
                }
                try {
                    if (!MyValidator.validateYear(Integer.parseInt(binding.year.text.toString()))) {
                        binding.year.error = "Invalid year"
                        isHave = false
                    }
                } catch (e: NumberFormatException) {
                    binding.year.error = "Invalid year"
                    isHave = false
                }
                if (isHave) {
                    startActivity(Intent(this, MainActivity2::class.java))
                    clearAll()
                }

            }
            binding.clearBtn.setOnClickListener {
                clearAll()

            }


        }

    }

    fun clearAll() {
        binding.year.setText("")
        binding.zipCode.setText("")
        binding.address.setText("")
        binding.email.setText("")
        binding.password.setText("")
        binding.rePassword.setText("")
        binding.firstName.setText("")
        binding.lastName.setText("")
        binding.userId.setText("")
        binding.numberPhone.setText("")
        binding.spreadInside.id = 0

    }
}