package uz.akbarali.materiallibrary

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MaterialLibrary() {
    fun materialDialog(
        context: Context,
        title: String,
        message: String,
        positiveButton: String,
        negativeButton: String
    ) {

        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(negativeButton) { dialog, which ->
                Toast.makeText(context, "${which}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setPositiveButton(positiveButton) { dialog, which ->
                Toast.makeText(context, "${dialog}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }.show()
    }

    fun materialCheckbox(
        context: Context
    ) {
        val animals = arrayOf("Twitter", "Google", "Instagram", "Facebook")
        val checkedItems = booleanArrayOf(false, true, false, true)
        MaterialAlertDialogBuilder(context)
            .setTitle("Social Networks")
            .setMultiChoiceItems(
                animals,
                checkedItems
            ) { p0, which, isChecked ->
                return@setMultiChoiceItems
            }
            .setPositiveButton("Choose") { dialog, which ->
                Toast.makeText(context, "${dialog}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }.show()
    }

    fun materialDatePicker(getSupportFragmentManager: FragmentManager) {
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("SELECT A DATE")
            .build()
            .show(getSupportFragmentManager, "DATE_PICKER_RANGE")
    }



}