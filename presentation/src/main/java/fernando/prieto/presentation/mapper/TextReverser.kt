package fernando.prieto.presentation.mapper

import javax.inject.Inject

interface TextReverser {
    fun reverse(originalText: String): String
}

class TextReverserImpl @Inject constructor() : TextReverser {
    override fun reverse(originalText: String): String =
        StringBuilder(originalText).reverse().toString()
}
