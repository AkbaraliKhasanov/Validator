package uz.akbarali.mylibrary

object MyValidator {
    fun isPhoneNumberValid(phoneNumber: String): Boolean {
        var valid = true
        val regex = "^(?:0091|\\+99|8)[7-9][0-9]{9}"
        if (!phoneNumber.matches(Regex(regex))) {
            valid = false
        }
        return valid
    }
}