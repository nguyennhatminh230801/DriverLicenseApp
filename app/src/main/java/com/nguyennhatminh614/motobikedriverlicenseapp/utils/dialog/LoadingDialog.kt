package com.nguyennhatminh614.motobikedriverlicenseapp.utils.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.nguyennhatminh614.motobikedriverlicenseapp.databinding.DialogLoadingLayoutBinding

object LoadingDialog {
    private var dialog: AlertDialog? = null
    fun showLoadingDialog(context: Context?) {
        val windowLayoutParams = WindowManager.LayoutParams()
        windowLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        windowLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        if (dialog == null) {
            val dialogBinding = DialogLoadingLayoutBinding.inflate(
                LayoutInflater.from(context),
                null,
                false
            )
            dialog = AlertDialog.Builder(context)
                .setView(dialogBinding.root)
                .setCancelable(false)
                .create()
        }

        dialog?.window?.attributes = windowLayoutParams

        dialog?.show()
    }

    fun hideLoadingDialog() {
        dialog?.dismiss()
    }
}
