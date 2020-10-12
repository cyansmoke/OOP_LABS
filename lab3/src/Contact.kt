import java.lang.StringBuilder

data class Contact(val firstname: String, val lastname: String, val phoneNumbers: List<PhoneNumber>) {
    fun check(searchSource: String): Boolean {
        return (
            firstname.contains(searchSource) ||
            lastname.contains(searchSource) ||
            checkNumbers(searchSource)
        )
    }

    private fun checkNumbers(searchSource: String): Boolean {
        return phoneNumbers.any{it.check(searchSource)}
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$firstname $lastname\n")
        stringBuilder.append(phoneNumbers.map {
            "${it.type} ${it.number}"
        })
        stringBuilder.append("\n")
        return stringBuilder.toString()
    }
}