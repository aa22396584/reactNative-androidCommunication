package com.johnsontech.reactnativeandroidhybrid.other

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.ArrayList

class AndroidWidgetPackage : ReactPackage {

    private var toastModule: ToastAndroidModule? = null

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        val modules = ArrayList<NativeModule>()
        toastModule = ToastAndroidModule(reactContext)
        modules.add(toastModule!!)
        return modules
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return emptyList()
    }

    fun getToastModule(): ToastAndroidModule {
        return toastModule ?: throw IllegalStateException("ToastModule not initialized")
    }
}