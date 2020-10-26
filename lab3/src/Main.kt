fun main() {
    val phoneBook = PhoneBook();
    phoneBook.add(
        Contact(
            "Jimmy",
            "Page",
            arrayListOf(PhoneNumber("+77771339123", PhoneType.HOME))
        )
    )
    phoneBook.add(
        Contact(
            "Ritchie",
            "Blackmore",
            arrayListOf(
                PhoneNumber("+8913912333", PhoneType.WORK),
                PhoneNumber("+7313313213", PhoneType.MOBILE)
            )
        )
    )
    phoneBook.add(
        Contact(
            "Jimmy",
            "Hendrix",
            arrayListOf(PhoneNumber("+31139567", PhoneType.WORK))
        )
    )
    println(phoneBook);
    println(phoneBook.find("Jimmy"))
    println(phoneBook.find("+7"))
    println(phoneBook[1])
    val newContact = Contact(
        "Jim",
        "Morrison",
        arrayListOf(PhoneNumber("903133", PhoneType.HOME))
    )
    val oneMoreNewContact = Contact(
        "Freddie",
        "Mercury",
        arrayListOf(PhoneNumber("+7903133", PhoneType.MOBILE))
    )
    phoneBook[1] = newContact
    println(phoneBook[1])
    phoneBook.remove(newContact)
    println(phoneBook)
    phoneBook.add(newContact)
    phoneBook.updateContact(newContact, oneMoreNewContact)
    println(phoneBook);
}