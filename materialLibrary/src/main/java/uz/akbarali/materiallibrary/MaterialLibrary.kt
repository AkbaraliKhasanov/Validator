package uz.akbarali.materiallibrary

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.widget.Toast
import androidx.core.content.contentValuesOf
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
            }
    }

}