import java.lang.StringBuilder

data class Contact(val firstname: String, val lastname: String, val phoneNumbers: List<PhoneNumber>) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$firstname $lastname\n")
        stringBuilder.append(phoneNumbers)
        stringBuilder.append("\n")
        return stringBuilder.toString()
    }
}