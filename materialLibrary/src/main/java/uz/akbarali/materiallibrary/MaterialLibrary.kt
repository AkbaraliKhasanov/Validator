package uz.akbarali.materiallibrary

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color.*
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.color.MaterialColors
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

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

    fun materialBottomSheet(context: Context) {
        var bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
        val inflate = LayoutInflater.from(context).inflate(R.layout.bottomsheet, null)
        bottomSheetDialog.setContentView(inflate)

        bottomSheetDialog.show()
    }

    fun colorMaterialDialog(context: Context) {
        val colors = intArrayOf(RED, GREEN, BLUE)
        MaterialDialog(context).show {
            title(R.string.colors)
            colorChooser(colors, initialSelection = BLUE) { dialog, color ->
                // Use color integer
            }
            positiveButton(R.string.select) {
                dismiss()
            }
        }
    }
}