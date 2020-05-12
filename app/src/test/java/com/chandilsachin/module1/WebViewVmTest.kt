package com.meesho.supply.web

import android.os.Build
import com.meesho.supply.TestApplication
import com.meesho.supply.network.Urls
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.N], manifest = Config.NONE, application = TestApplication::class)
class WebViewVmTest {

    private lateinit var vm: WebViewVm

    @Test
    fun shouldShowLoading_resellerLogoShowLoading() {
        val args = WebViewArgs.create(Urls.RESELLER_LOGO, null)
        vm = WebViewVm(args)
        assertEquals(false, vm.showLoading())
    }

    @Test
    fun shouldShowLoading_websiteBuilderShowLoading() {
        val args = WebViewArgs.create(Urls.WEBSITE_BUILDER, null)
        vm = WebViewVm(args)
        assertEquals(false, vm.showLoading())
    }

    @Test
    fun shouldShowLoading_dontShowLoading() {
        val args = WebViewArgs.create("https://somelink.com", null)
        vm = WebViewVm(args)
        assertEquals(true, vm.showLoading())
    }
}
