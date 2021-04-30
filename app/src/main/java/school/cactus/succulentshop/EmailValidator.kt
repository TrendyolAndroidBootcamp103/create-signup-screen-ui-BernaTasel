package school.cactus.succulentshop
/**
must not be empty	Email is required.
must contain @ and .	Email is invalid.
must be longer than 5 characters	Email is invalid.
must be shorter than 50 characters	Email is invalid.
 */
class EmailValidator: Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_is_required
        !field.contains("@") -> R.string.email_is_invalid
        !field.contains(".") -> R.string.email_is_invalid
        field.length < 5 -> R.string.email_is_invalid
        field.length > 50 -> R.string.email_is_invalid
        else -> null
    }
}