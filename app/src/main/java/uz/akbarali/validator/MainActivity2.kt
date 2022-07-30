package uz.akbarali.validator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.akbarali.materiallibrary.MaterialLibrary
import uz.akbarali.validator.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.argb.setOnClickListener {
            MaterialLibrary().colorMaterialDialog(this)
        }
        binding.apply {
            sheet.setOnClickListener {
                MaterialLibrary().materialBottomSheet(this@MainActivity2)
            }
            date.setOnClickListener {
                MaterialLibrary().materialDatePicker(supportFragmentManager)
            }
            basic.setOnClickListener {
                MaterialLibrary().materialDialog(
                    this@MainActivity2,
                    "What is Lorem Ipsum?",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    "OK",
                    "Cancel"
                )
            }
            choice.setOnClickListener {
                MaterialLibrary().materialCheckbox(this@MainActivity2)
            }
        }
    }
}