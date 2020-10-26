import java.lang.IllegalArgumentException
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

    private fun checkContact(contact: Contact, source: String) =
        contact.firstname.contains(source) ||
        contact.lastname.contains(source) ||
        contact.phoneNumbers.any{ it.number.contains(source) }

    fun find(source: String) = PhoneBook(contacts.filter { checkContact(it, source) })

    fun updateContact(old: Contact, new: Contact) {
        val oldIndex = contacts.indexOf(old);
        if (oldIndex != -1) {
            contacts[oldIndex] = new
        } else {
            throw IllegalArgumentException("Old contact is not in the phone book")
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        contacts.forEach { contact ->
            stringBuilder.append(contact.toString())
        }
        return stringBuilder.toString()
    }
}