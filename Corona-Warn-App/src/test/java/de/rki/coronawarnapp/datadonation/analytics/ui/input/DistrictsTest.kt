package de.rki.coronawarnapp.datadonation.analytics.ui.input

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import com.google.gson.Gson
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import testhelpers.BaseTest
import testhelpers.EmptyApplication

@Config(sdk = [Build.VERSION_CODES.P], application = EmptyApplication::class)
@RunWith(RobolectricTestRunner::class)
class DistrictsTest : BaseTest() {

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    val context: Context
        get() = ApplicationProvider.getApplicationContext()

    fun createInstance() = Districts(
        context = context,
        gson = Gson()
    )

    @Test
    fun `loading from assets and parsing`() = runBlockingTest {
        val districts = createInstance().loadDistricts()
        districts.size shouldBe 412
        districts.last() shouldBe Districts.District(
            districtName = "SK Weimar",
            districtShortName = "WE",
            districtId = 11016055,
            federalStateName = "Thüringen",
            federalStateShortName = "TH",
            federalStateId = 13000016
        )
    }
}
