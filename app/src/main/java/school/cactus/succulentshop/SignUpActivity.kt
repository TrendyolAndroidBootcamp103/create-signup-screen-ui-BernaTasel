package school.cactus.succulentshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val emailValidator = EmailValidator()
    private val userNameValidator = UserNameValidator()
    private val passwordValidator = InitPasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener {
                emailInputLayout.validate()
                userNameInputLayout.validate()
                passwordInputLayout.validate()

            }

            logInButton.setOnClickListener {
                navigateToLogIn()
            }
        }
    }

    private fun navigateToLogIn() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.emailInputLayout -> emailValidator
        binding.userNameInputLayout -> userNameValidator
        binding.passwordInputLayout -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}