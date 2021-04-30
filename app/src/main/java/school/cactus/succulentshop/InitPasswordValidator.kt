package school.cactus.succulentshop
/**
must not be empty	Password is required.
must be longer than 7 characters	Password is too short.
must be shorter than 40 characters	Password is too long.
must contain at least one digit	Password must contain one digit, one uppercase letter, one lowercase letter and one special character.
must contain at least one lowercase letter	Password must contain one digit, one uppercase letter, one lowercase letter and one special character.
must contain at least one uppercase letter	Password must contain one digit, one uppercase letter, one lowercase letter and one special character.
must contain at least on special character	Password must contain one digit, one uppercase letter, one lowercase letter and one special character.
 */
class InitPasswordValidator: Validator {
    val specialCharacters = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
    val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$specialCharacters])(?=\\S+$).{8,20}$"

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        field.length < 7 -> R.string.password_is_too_short
        field.length > 40 -> R.string.password_is_too_long
        !field.matches(PASSWORD_REGEX.toRegex()) -> R.string.password_must_contain
        else -> null
    }
}