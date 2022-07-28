package uz.akbarali.materiallibrary

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.core.content.contentValuesOf
import com.google.android.material.dialog.MaterialDialogs

class MaterialLibrary() {
    fun materialDialog(
        context: Context,
        title: String,
        message: String,
        positiveButton: String,
        negativeButton: String
    ) {
        val create = AlertDialog.Builder(context).create()
        create.setTitle(title)
        create.setMessage(message)
        create.show()
    }

}