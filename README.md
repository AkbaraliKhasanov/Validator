# Validator
#### Add the following to your app/build.gradle file:

	dependencies {
	        implementation 'com.github.AkbaraliKhasanov:Validator:1.0.2'
	}
#### Open settings.gradle file and add the below line inside repositories
	maven { url "https://jitpack.io" }
#### Examples to use
	 if (!MyValidator.isValidEmail(binding.inputEmail.text.toString())) {
            binding.inputEmail.error = "Invalid email address"
        } 
