package prieto.fernando.presentation.transformer

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.junit.MockitoJUnit
import prieto.fernando.presentation.mapper.TextReverserImpl

@RunWith(Parameterized::class)
class TextReverserImplTest(
    private val givenOriginalText: String,
    private val expected: String
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<String>> = listOf(
            arrayOf(
                "This is a long text", "txet gnol a si sihT"
            ),
            arrayOf(
                "Hello", "olleH"
            ),
            arrayOf(
                "This is a long text", "txet gnol a si sihT"
            ),
            arrayOf(
                "This is a long text", "txet gnol a si sihT"
            )
        )
    }

    private lateinit var cut: TextReverserImpl

    @get:Rule
    var rule: MethodRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        cut = TextReverserImpl()
    }

    @Test
    fun `Given originalText when reverse then returns expected result`() {
        // When
        val actualValue = cut.reverse(givenOriginalText)

        // Then
        assertEquals(expected, actualValue)
    }
}