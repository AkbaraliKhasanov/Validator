package uz.akbarali.mylibrary

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import java.util.regex.Matcher
import java.util.regex.Pattern


object MyValidator {

    fun isPhoneNumberValid(phoneNumber: String): Boolean {
        var valid = true
        val regex = "^(?:0091|\\+99|8)[7-9][0-9]{9}"
        if (!phoneNumber.matches(Regex(regex))) {
            valid = false
        }
        return valid
    }

    fun isIpAddressValid(ipAddress: String): Boolean {
        var valid = true
        val IP_ADDRESS: Pattern = Pattern.compile(
            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9]))"
        )
        val matcher: Matcher = IP_ADDRESS.matcher(ipAddress)
        if (!matcher.matches()) {
            valid = false
        }
        return valid
    }

    fun isValidEmail(target: String?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target!!).matches()
    }

    fun validateYear(year: Int): Boolean {
        var isValid = year in 1901..2019
        if (!isValid) {
            isValid = false
        }
        return isValid
    }

    fun isPasswordMatching(password: String?, confirmPassword: String?): Boolean {
        val pattern = Pattern.compile(password!!, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(confirmPassword!!)
        return matcher.matches()
    }

    fun validateSpinner(spinner: Spinner, error: String?): Boolean {
        val selectedView: View? = spinner.selectedView
        if (selectedView != null && selectedView is TextView) {
            val selectedTextView = selectedView as TextView
            if (selectedTextView.text == "") {
                selectedTextView.error = error
                return false
            }
        }
        return true
    }

}