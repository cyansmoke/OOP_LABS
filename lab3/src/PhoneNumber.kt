enum class PhoneType {
    MOBILE,
    WORK,
    HOME
}

data class PhoneNumber(val number: String, val type: PhoneType) {
    fun check(searchSource: String): Boolean {
        return number.contains(searchSource)
    }
}