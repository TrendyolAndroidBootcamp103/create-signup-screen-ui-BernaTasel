package school.cactus.succulentshop
/**
must not be empty	Username is required.
must not consist characters except: a-z, 0-9 and _	Username can only include a-z, 0-9 and _ characters.
must be longer than 2 characters	Username is too short.
must be shorter than 20 characters	Username is too long.
 */
class UserNameValidator: Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_is_required
        field.length <= 2 -> R.string.username_is_too_short
        field.length > 20 -> R.string.username_is_too_long
        !field.matches("^[a-z0-9_]+\$".toRegex()) -> R.string.username_contains_other_chars
        else -> null
    }
}