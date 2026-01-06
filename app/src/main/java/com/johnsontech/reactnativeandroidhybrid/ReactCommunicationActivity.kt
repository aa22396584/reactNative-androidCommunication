package com.johnsontech.reactnativeandroidhybrid

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage
import com.johnsontech.reactnativeandroidhybrid.other.AndroidWidgetPackage

class ReactCommunicationActivity : AppCompatActivity() {

    private var mReactRootView: ReactRootView? = null
    private var mReactInstanceManager: ReactInstanceManager? = null
    private var reactPackage: AndroidWidgetPackage? = null
    private var mClickTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_react_comunucatuin)

        mReactRootView = ReactRootView(this)
        reactPackage = AndroidWidgetPackage()
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(MainReactPackage())
                .addPackage(reactPackage)   //加入AndroidModule
                .setUseDeveloperSupport(BuildConfig.DEBUG) // 現代 React Native 在 Debug 模式下會使用特定開發支援
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build()

        val reactRootView1 = findViewById<ReactRootView>(R.id.react_root_view1)
        val reactRootView2 = findViewById<ReactRootView>(R.id.react_root_view2)
        val nativeBtn = findViewById<Button>(R.id.native_btn)

        reactRootView1.startReactApplication(mReactInstanceManager, "Communication2", null)
        reactRootView2.startReactApplication(mReactInstanceManager, "Communication3", null)

        nativeBtn.setOnClickListener {
            reactPackage!!.getToastModule().sendMessage("這是一條Android發送給React的消息${mClickTime++}")
        }
    }
}
