package store

class WriteFileException(val reason: String) : Exception()

class ReadFileException(val reason: String) : Exception()