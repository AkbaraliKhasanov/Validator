package uz.akbarali.validator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import uz.akbarali.mylibrary.MyValidator
import uz.akbarali.validator.databinding.ActivityMainBinding

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
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

            binding.submitBtn.setOnClickListener {
                if (!MyValidator.isPasswordMatching(
                        binding.password.text.toString(),
                        binding.rePassword.text.toString()
                    )
                ) {
                    binding.rePassword.error = "Password Not matching"
                } else if (!MyValidator.isValidEmail(binding.email.text.toString())) {
                    binding.email.error = "Invalid email address"
                } else if (!MyValidator.validateSpinner(binding.spreadInside, "djfn")) {

                }
            }


        }
    }
}