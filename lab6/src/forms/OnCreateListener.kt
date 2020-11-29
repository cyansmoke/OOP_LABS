package forms

import shapes.BaseShape

interface OnCreateListener {
    fun create(shape: BaseShape)
}