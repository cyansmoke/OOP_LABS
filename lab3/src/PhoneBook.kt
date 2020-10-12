import java.lang.StringBuilder

class PhoneBook() {
    private val contacts = ArrayList<Contact>()

    constructor(initList: List<Contact>): this() {
        contacts.addAll(initList)
    }

    fun add(contact: Contact) {
        contacts.add(contact)
    }

    fun remove(contact: Contact) {
        contacts.remove(contact);
    }

    operator fun get(i: Int): Contact {
        return contacts[i];
    }

    operator fun set(i: Int, contact: Contact) {
        contacts[i] = contact;
    }

    fun find(source: String): PhoneBook {
        return PhoneBook(contacts.filter { it.check(source) })
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        contacts.forEach { contact ->
            stringBuilder.append(contact.toString())
        }
        return stringBuilder.toString()
    }
}