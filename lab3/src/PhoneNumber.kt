enum class PhoneType {
    MOBILE,
    WORK,
    HOME
}

data class PhoneNumber(val number: String, val type: PhoneType) {
    override fun toString() = "$type $number"
}